package com.northbeam.expense.service;

import com.northbeam.expense.model.Category;
import com.northbeam.expense.model.Expense;
import com.northbeam.expense.repository.CategoryRepository;
import com.northbeam.expense.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final CategoryRepository categoryRepo;

    public ExpenseService(ExpenseRepository expenseRepo, CategoryRepository categoryRepo) {
        this.expenseRepo = expenseRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Expense> listForEmployee(String employeeId, String status, String categoryId) {
        if (status != null && categoryId != null) {
            return expenseRepo.findByEmployeeId(employeeId).stream()
                    .filter(e -> status.equals(e.getStatus()) && categoryId.equals(e.getCategoryId()))
                    .toList();
        } else if (status != null) {
            return expenseRepo.findByEmployeeIdAndStatus(employeeId, status);
        } else if (categoryId != null) {
            return expenseRepo.findByEmployeeIdAndCategoryId(employeeId, categoryId);
        }
        return expenseRepo.findByEmployeeId(employeeId);
    }

    public Optional<Expense> findById(String id) {
        return expenseRepo.findById(id);
    }

    public record CreateResult(Expense expense, String error, String field) {}

    public CreateResult create(String employeeId, String categoryId, BigDecimal amount,
                               String currency, LocalDate date, String merchant,
                               String description, String receiptUrl) {
        if (date.isAfter(LocalDate.now())) {
            return new CreateResult(null, "Expense date cannot be in the future.", "date");
        }
        Optional<Category> catOpt = categoryRepo.findById(categoryId);
        if (catOpt.isEmpty()) {
            return new CreateResult(null, "Category " + categoryId + " does not exist.", "category_id");
        }
        Category cat = catOpt.get();
        if (amount.compareTo(BigDecimal.valueOf(cat.getReceiptThreshold())) > 0 && (receiptUrl == null || receiptUrl.isBlank())) {
            return new CreateResult(null, "A receipt is required for " + cat.getName() + " expenses above $" + cat.getReceiptThreshold() + ".00.", "receipt_url");
        }
        Expense e = new Expense();
        e.setId("exp-" + UUID.randomUUID().toString().substring(0, 8));
        e.setEmployeeId(employeeId);
        e.setCategoryId(categoryId);
        e.setAmount(amount);
        e.setCurrency(currency != null ? currency : "USD");
        e.setDate(date);
        e.setMerchant(merchant);
        e.setDescription(description);
        e.setReceiptUrl(receiptUrl);
        e.setStatus("unclaimed");
        Instant now = Instant.now();
        e.setCreatedAt(now);
        e.setUpdatedAt(now);
        return new CreateResult(expenseRepo.save(e), null, null);
    }

    public record UpdateResult(Expense expense, String error, int status) {}

    public UpdateResult update(String id, String categoryId, BigDecimal amount, String currency,
                               LocalDate date, String merchant, String description, String receiptUrl) {
        Optional<Expense> opt = expenseRepo.findById(id);
        if (opt.isEmpty()) return new UpdateResult(null, "Expense " + id + " does not exist.", 404);
        Expense e = opt.get();
        if ("claimed".equals(e.getStatus())) {
            return new UpdateResult(null, "Expense " + id + " is part of a submitted claim and cannot be modified.", 409);
        }
        if (categoryId != null) e.setCategoryId(categoryId);
        if (amount != null) e.setAmount(amount);
        if (currency != null) e.setCurrency(currency);
        if (date != null) e.setDate(date);
        if (merchant != null) e.setMerchant(merchant);
        if (description != null) e.setDescription(description);
        if (receiptUrl != null) e.setReceiptUrl(receiptUrl);
        e.setUpdatedAt(Instant.now());
        return new UpdateResult(expenseRepo.save(e), null, 200);
    }

    public record DeleteResult(boolean deleted, String error, int status) {}

    public DeleteResult delete(String id) {
        Optional<Expense> opt = expenseRepo.findById(id);
        if (opt.isEmpty()) return new DeleteResult(false, "Expense " + id + " does not exist.", 404);
        if ("claimed".equals(opt.get().getStatus())) {
            return new DeleteResult(false, "Expense " + id + " is part of a submitted claim and cannot be deleted.", 409);
        }
        expenseRepo.deleteById(id);
        return new DeleteResult(true, null, 204);
    }

    public List<Expense> findByClaimId(String claimId) {
        return expenseRepo.findByClaimId(claimId);
    }

    public void markAsClaimed(String expenseId, String claimId) {
        expenseRepo.findById(expenseId).ifPresent(e -> {
            e.setStatus("claimed");
            e.setClaimId(claimId);
            e.setUpdatedAt(Instant.now());
            expenseRepo.save(e);
        });
    }
}
