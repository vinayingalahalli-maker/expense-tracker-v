package com.northbeam.expense.controller;

import com.northbeam.expense.model.Category;
import com.northbeam.expense.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> list() {
        List<Category> cats = categoryService.listAll();
        return ResponseEntity.ok(Map.of("categories", cats.stream().map(this::toMap).toList(), "total", cats.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return categoryService.findById(id)
                .<ResponseEntity<?>>map(c -> ResponseEntity.ok(toMap(c)))
                .orElse(ResponseEntity.status(404).body(Map.of("error", "not_found", "message", "Category " + id + " does not exist.")));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> body, Authentication auth) {
        String role = (String) auth.getAuthorities().stream().findFirst().map(a -> a.getAuthority().replace("ROLE_", "")).orElse("");
        if (!"finance".equals(role)) {
            return ResponseEntity.status(403).body(Map.of("error", "forbidden", "message", "Only Finance users may create categories."));
        }
        String name = (String) body.get("name");
        if (name == null || name.isBlank()) {
            return ResponseEntity.status(422).body(Map.of(
                    "error", "validation_error",
                    "message", "Request body contains invalid fields.",
                    "details", List.of(Map.of("field", "name", "issue", "name is required and cannot be empty."))
            ));
        }
        Object thresholdObj = body.get("receipt_threshold");
        int threshold = 0;
        if (thresholdObj instanceof Number n) threshold = n.intValue();
        if (threshold <= 0) {
            return ResponseEntity.status(422).body(Map.of(
                    "error", "validation_error",
                    "message", "Request body contains invalid fields.",
                    "details", List.of(Map.of("field", "receipt_threshold", "issue", "receipt_threshold must be a positive number."))
            ));
        }
        Category c = categoryService.create(name, (String) body.get("description"), threshold, (String) body.get("currency"));
        return ResponseEntity.status(201).body(toMap(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Map<String, Object> body) {
        Object thresholdObj = body.get("receipt_threshold");
        Integer threshold = thresholdObj instanceof Number n ? n.intValue() : null;
        Optional<Category> updated = categoryService.update(id, (String) body.get("name"), (String) body.get("description"), threshold, (String) body.get("currency"));
        return updated.<ResponseEntity<?>>map(c -> ResponseEntity.ok(toMap(c)))
                .orElse(ResponseEntity.status(404).body(Map.of("error", "not_found", "message", "Category " + id + " does not exist.")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id, Authentication auth) {
        String role = (String) auth.getAuthorities().stream().findFirst().map(a -> a.getAuthority().replace("ROLE_", "")).orElse("");
        if (!"finance".equals(role)) {
            return ResponseEntity.status(403).body(Map.of("error", "forbidden", "message", "Only Finance users may delete categories."));
        }
        boolean deleted = categoryService.delete(id);
        if (!deleted) return ResponseEntity.status(404).body(Map.of("error", "not_found", "message", "Category " + id + " does not exist."));
        return ResponseEntity.noContent().build();
    }

    private Map<String, Object> toMap(Category c) {
        return Map.of(
                "id", c.getId(),
                "name", c.getName(),
                "description", c.getDescription() != null ? c.getDescription() : "",
                "receipt_threshold", c.getReceiptThreshold(),
                "currency", c.getCurrency(),
                "created_at", c.getCreatedAt().toString(),
                "updated_at", c.getUpdatedAt().toString()
        );
    }
}
