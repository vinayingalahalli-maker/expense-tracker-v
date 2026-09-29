package com.northbeam.expense.controller;

import com.northbeam.expense.model.Category;
import com.northbeam.expense.model.Expense;
import com.northbeam.expense.repository.CategoryRepository;
import com.northbeam.expense.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final CategoryRepository categoryRepo;

    public ExpenseController(ExpenseService expenseService, CategoryRepository categoryRepo) {
        this.expenseService = expenseService;
        this.categoryRepo = categoryRepo;
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false) String status,
                                   @RequestParam(name = "category_id", required = false) String categoryId,
                                   Authentication auth) {
        String userId = auth.getName();
        List<Expense> expenses = expenseService.listForEmployee(userId, status, categoryId);
        return ResponseEntity.ok(Map.of("expenses", expenses.stream().map(e -> toMap(e)).toList(), "total", expenses.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id, Authentication auth) {
        Optional<Expense> opt = expenseService.findById(id);
        if (opt.isEmpty()) return ResponseEntity.status(404).body(Map.of("error", "not_found", "message", "Expense " + id + " does not exist."));
        return ResponseEntity.ok(toMap(opt.get()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body, Authentication auth) {
        String userId = auth.getName();
        String categoryId = (String) body.get("category_id");
        Object amountObj = body.get("amount");
        BigDecimal amount = amountObj instanceof Number n ? BigDecimal.valueOf(n.doubleValue()) : null;
        String dateStr = (String) body.get("date");
        LocalDate date = dateStr != null ? LocalDate.parse(dateStr) : null;

        if (categoryId == null || amount == null || date == null) {
            return ResponseEntity.status(422).body(Map.of("error", "validation_error", "message", "category_id, amount, and date are required."));
        }

        ExpenseService.CreateResult result = expenseService.create(userId, categoryId, amount,
                (String) body.get("currency"), date, (String) body.get("merchant"),
                (String) body.get("description"), (String) body.get("receipt_url"));

        if (result.error() != null) {
            return ResponseEntity.status(422).body(Map.of(
                    "error", "validation_error",
                    "message", "Request body contains invalid fields.",
                    "details", List.of(Map.of("field", result.field(), "issue", result.error()))
            ));
        }
        return ResponseEntity.status(201).body(toMap(result.expense()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Map<String, Object> body) {
        Object amountObj = body.get("amount");
        BigDecimal amount = amountObj instanceof Number n ? BigDecimal.valueOf(n.doubleValue()) : null;
        String dateStr = (String) body.get("date");
        LocalDate date = dateStr != null ? LocalDate.parse(dateStr) : null;

        ExpenseService.UpdateResult result = expenseService.update(id, (String) body.get("category_id"),
                amount, (String) body.get("currency"), date,
                (String) body.get("merchant"), (String) body.get("description"), (String) body.get("receipt_url"));

        if (result.error() != null) {
            if (result.status() == 409) return ResponseEntity.status(409).body(Map.of("error", "expense_frozen", "message", result.error()));
            return ResponseEntity.status(result.status()).body(Map.of("error", "not_found", "message", result.error()));
        }
        return ResponseEntity.ok(toMap(result.expense()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ExpenseService.DeleteResult result = expenseService.delete(id);
        if (!result.deleted()) {
            if (result.status() == 409) return ResponseEntity.status(409).body(Map.of("error", "expense_frozen", "message", result.error()));
            return ResponseEntity.status(404).body(Map.of("error", "not_found", "message", result.error()));
        }
        return ResponseEntity.noContent().build();
    }

    private Map<String, Object> toMap(Expense e) {
        Optional<Category> cat = categoryRepo.findById(e.getCategoryId());
        java.util.LinkedHashMap<String, Object> map = new java.util.LinkedHashMap<>();
        map.put("id", e.getId());
        map.put("employee_id", e.getEmployeeId());
        map.put("category_id", e.getCategoryId());
        map.put("category_name", cat.map(Category::getName).orElse(""));
        map.put("amount", e.getAmount());
        map.put("currency", e.getCurrency());
        map.put("date", e.getDate().toString());
        map.put("merchant", e.getMerchant());
        map.put("description", e.getDescription());
        map.put("receipt_url", e.getReceiptUrl());
        map.put("status", e.getStatus());
        map.put("claim_id", e.getClaimId());
        map.put("created_at", e.getCreatedAt().toString());
        map.put("updated_at", e.getUpdatedAt().toString());
        return map;
    }
}
