package com.northbeam.expense.service;

import com.northbeam.expense.model.Claim;
import com.northbeam.expense.model.Expense;
import com.northbeam.expense.repository.ClaimRepository;
import com.northbeam.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClaimService {

    private final ClaimRepository claimRepo;
    private final ExpenseRepository expenseRepo;
    private final ExpenseService expenseService;

    public ClaimService(ClaimRepository claimRepo, ExpenseRepository expenseRepo, ExpenseService expenseService) {
        this.claimRepo = claimRepo;
        this.expenseRepo = expenseRepo;
        this.expenseService = expenseService;
    }

    public List<Claim> listForUser(String userId, String role, String statusFilter, String employeeIdFilter) {
        List<Claim> claims;
        if ("employee".equals(role)) {
            claims = statusFilter != null
                    ? claimRepo.findByEmployeeIdAndStatus(userId, statusFilter)
                    : claimRepo.findByEmployeeId(userId);
        } else {
            // approver or finance can see all
            if (employeeIdFilter != null && statusFilter != null) {
                claims = claimRepo.findByEmployeeIdAndStatus(employeeIdFilter, statusFilter);
            } else if (employeeIdFilter != null) {
                claims = claimRepo.findByEmployeeId(employeeIdFilter);
            } else if (statusFilter != null) {
                claims = claimRepo.findByStatus(statusFilter);
            } else {
                claims = claimRepo.findAll();
            }
        }
        return claims;
    }

    public Optional<Claim> findById(String id) {
        return claimRepo.findById(id);
    }

    public record CreateResult(Claim claim, List<ValidationDetail> errors) {
        public record ValidationDetail(String expenseId, String issue) {}
    }

    public CreateResult create(String employeeId, String title, List<String> expenseIds) {
        List<CreateResult.ValidationDetail> errors = new ArrayList<>();
        List<Expense> expenses = new ArrayList<>();

        for (String eid : expenseIds) {
            Optional<Expense> opt = expenseRepo.findById(eid);
            if (opt.isEmpty()) {
                errors.add(new CreateResult.ValidationDetail(eid, "Expense " + eid + " does not exist."));
                continue;
            }
            Expense e = opt.get();
            if ("claimed".equals(e.getStatus())) {
                errors.add(new CreateResult.ValidationDetail(eid, "Expense " + eid + " is already part of claim " + e.getClaimId() + "."));
                continue;
            }
            if (e.getDate().isBefore(LocalDate.now().minusDays(90))) {
                errors.add(new CreateResult.ValidationDetail(eid, "Expense " + eid + " is older than 90 days and cannot be added to a claim."));
                continue;
            }
            expenses.add(e);
        }

        if (!errors.isEmpty()) return new CreateResult(null, errors);

        BigDecimal total = expenses.stream().map(Expense::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        String currency = expenses.isEmpty() ? "USD" : expenses.get(0).getCurrency();

        Claim claim = new Claim();
        claim.setId("clm-" + UUID.randomUUID().toString().substring(0, 8));
        claim.setEmployeeId(employeeId);
        claim.setTitle(title);
        claim.setStatus("draft");
        claim.setTotalAmount(total);
        claim.setCurrency(currency);
        Instant now = Instant.now();
        claim.setCreatedAt(now);
        claim.setUpdatedAt(now);
        claimRepo.save(claim);

        for (Expense e : expenses) {
            expenseService.markAsClaimed(e.getId(), claim.getId());
        }

        return new CreateResult(claim, List.of());
    }

    public record ActionResult(Claim claim, String error, int httpStatus, String currentStatus) {}

    public ActionResult submit(String claimId, String userId) {
        Optional<Claim> opt = claimRepo.findById(claimId);
        if (opt.isEmpty()) return new ActionResult(null, "Claim " + claimId + " does not exist.", 404, null);
        Claim claim = opt.get();
        if (!claim.getEmployeeId().equals(userId)) return new ActionResult(null, "Forbidden.", 403, null);
        if (!"draft".equals(claim.getStatus())) {
            return new ActionResult(null, "Claim " + claimId + " is already " + claim.getStatus() + " and cannot be submitted again.", 409, claim.getStatus());
        }
        claim.setStatus("submitted");
        claim.setSubmittedAt(Instant.now());
        claim.setUpdatedAt(Instant.now());
        return new ActionResult(claimRepo.save(claim), null, 200, null);
    }

    public ActionResult approve(String claimId, String approverId) {
        Optional<Claim> opt = claimRepo.findById(claimId);
        if (opt.isEmpty()) return new ActionResult(null, "Claim " + claimId + " does not exist.", 404, null);
        Claim claim = opt.get();
        if (claim.getEmployeeId().equals(approverId)) {
            return new ActionResult(null, "An approver cannot approve their own claim.", 403, null);
        }
        if (!"submitted".equals(claim.getStatus())) {
            return new ActionResult(null, "Only submitted claims can be approved. Claim " + claimId + " is in " + claim.getStatus() + " status.", 409, claim.getStatus());
        }
        claim.setStatus("approved");
        claim.setApprovedBy(approverId);
        claim.setApprovedAt(Instant.now());
        claim.setUpdatedAt(Instant.now());
        return new ActionResult(claimRepo.save(claim), null, 200, null);
    }
}
