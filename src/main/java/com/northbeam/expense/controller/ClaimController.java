package com.northbeam.expense.controller;

import com.northbeam.expense.model.Claim;
import com.northbeam.expense.model.Expense;
import com.northbeam.expense.model.User;
import com.northbeam.expense.repository.CategoryRepository;
import com.northbeam.expense.repository.UserRepository;
import com.northbeam.expense.service.ClaimService;
import com.northbeam.expense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;
    private final ExpenseService expenseService;
    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;

    public ClaimController(ClaimService claimService, ExpenseService expenseService,
                           UserRepository userRepo, CategoryRepository categoryRepo) {
        this.claimService = claimService;
        this.expenseService = expenseService;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false) String status,
                                   @RequestParam(name = "employee_id", required = false) String employeeId,
                                   Authentication auth) {
        String userId = auth.getName();
        String role = auth.getAuthorities().stream().findFirst().map(a -> a.getAuthority().replace("ROLE_", "")).orElse("");
        List<Claim> claims = claimService.listForUser(userId, role, status, employeeId);
        return ResponseEntity.ok(Map.of("claims", claims.stream().map(c -> toListMap(c)).toList(), "total", claims.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Optional<Claim> opt = claimService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.status(404).body(Map.of("error", "not_found", "message", "Claim " + id + " does not exist."));
        return ResponseEntity.ok(toDetailMap(opt.get()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body, Authentication auth) {
        String userId = auth.getName();
        String title = (String) body.get("title");
        @SuppressWarnings("unchecked")
        List<String> expenseIds = (List<String>) body.get("expense_ids");

        if (title == null || expenseIds == null || expenseIds.isEmpty()) {
            return ResponseEntity.status(422).body(Map.of("error", "validation_error", "message", "title and expense_ids are required."));
        }

        ClaimService.CreateResult result = claimService.create(userId, title, expenseIds);
        if (!result.errors().isEmpty()) {
            return ResponseEntity.status(422).body(Map.of(
                    "error", "validation_error",
                    "message", "One or more expenses cannot be added to a claim.",
                    "details", result.errors().stream().map(d -> Map.of("expense_id", d.expenseId(), "issue", d.issue())).toList()
            ));
        }
        return ResponseEntity.status(201).body(toListMap(result.claim()));
    }

    @PostMapping("/{id}/submit")
    public ResponseEntity<?> submit(@PathVariable String id, Authentication auth) {
        String userId = auth.getName();
        ClaimService.ActionResult result = claimService.submit(id, userId);
        if (result.error() != null) {
            if (result.httpStatus() == 409) return ResponseEntity.status(409).body(Map.of("error", "invalid_state_transition", "message", result.error(), "current_status", result.currentStatus()));
            if (result.httpStatus() == 403) return ResponseEntity.status(403).body(Map.of("error", "forbidden", "message", result.error()));
            return ResponseEntity.status(result.httpStatus()).body(Map.of("error", "not_found", "message", result.error()));
        }
        return ResponseEntity.ok(toListMap(result.claim()));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable String id, Authentication auth) {
        String userId = auth.getName();
        ClaimService.ActionResult result = claimService.approve(id, userId);
        if (result.error() != null) {
            if (result.httpStatus() == 409) return ResponseEntity.status(409).body(Map.of("error", "invalid_state_transition", "message", result.error(), "current_status", result.currentStatus()));
            if (result.httpStatus() == 403) return ResponseEntity.status(403).body(Map.of("error", "forbidden", "message", result.error()));
            return ResponseEntity.status(result.httpStatus()).body(Map.of("error", "not_found", "message", result.error()));
        }
        return ResponseEntity.ok(toApproveMap(result.claim()));
    }

    private Map<String, Object> toListMap(Claim c) {
        Optional<User> user = userRepo.findById(c.getEmployeeId());
        java.util.LinkedHashMap<String, Object> map = new java.util.LinkedHashMap<>();
        map.put("id", c.getId());
        map.put("employee_id", c.getEmployeeId());
        map.put("employee_name", user.map(User::getName).orElse(""));
        map.put("title", c.getTitle());
        map.put("status", c.getStatus());
        map.put("total_amount", c.getTotalAmount());
        map.put("currency", c.getCurrency());
        map.put("expense_count", expenseService.findByClaimId(c.getId()).size());
        map.put("submitted_at", c.getSubmittedAt() != null ? c.getSubmittedAt().toString() : null);
        map.put("created_at", c.getCreatedAt().toString());
        map.put("updated_at", c.getUpdatedAt().toString());
        return map;
    }

    private Map<String, Object> toDetailMap(Claim c) {
        Optional<User> user = userRepo.findById(c.getEmployeeId());
        List<Expense> expenses = expenseService.findByClaimId(c.getId());
        java.util.LinkedHashMap<String, Object> map = new java.util.LinkedHashMap<>();
        map.put("id", c.getId());
        map.put("employee_id", c.getEmployeeId());
        map.put("employee_name", user.map(User::getName).orElse(""));
        map.put("title", c.getTitle());
        map.put("status", c.getStatus());
        map.put("total_amount", c.getTotalAmount());
        map.put("currency", c.getCurrency());
        map.put("submitted_at", c.getSubmittedAt() != null ? c.getSubmittedAt().toString() : null);
        map.put("created_at", c.getCreatedAt().toString());
        map.put("updated_at", c.getUpdatedAt().toString());
        map.put("expenses", expenses.stream().map(e -> {
            java.util.LinkedHashMap<String, Object> em = new java.util.LinkedHashMap<>();
            em.put("id", e.getId());
            em.put("category_name", categoryRepo.findById(e.getCategoryId()).map(cat -> cat.getName()).orElse(""));
            em.put("amount", e.getAmount());
            em.put("currency", e.getCurrency());
            em.put("date", e.getDate().toString());
            em.put("merchant", e.getMerchant());
            em.put("description", e.getDescription());
            return em;
        }).toList());
        return map;
    }

    private Map<String, Object> toApproveMap(Claim c) {
        Optional<User> user = userRepo.findById(c.getEmployeeId());
        List<Expense> expenses = expenseService.findByClaimId(c.getId());
        java.util.LinkedHashMap<String, Object> map = new java.util.LinkedHashMap<>();
        map.put("id", c.getId());
        map.put("employee_id", c.getEmployeeId());
        map.put("employee_name", user.map(User::getName).orElse(""));
        map.put("title", c.getTitle());
        map.put("status", c.getStatus());
        map.put("total_amount", c.getTotalAmount());
        map.put("currency", c.getCurrency());
        map.put("expense_count", expenses.size());
        map.put("approved_by", c.getApprovedBy());
        map.put("approved_at", c.getApprovedAt() != null ? c.getApprovedAt().toString() : null);
        map.put("submitted_at", c.getSubmittedAt() != null ? c.getSubmittedAt().toString() : null);
        map.put("created_at", c.getCreatedAt().toString());
        map.put("updated_at", c.getUpdatedAt().toString());
        return map;
    }
}
