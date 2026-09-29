package com.northbeam.expense.service;

import com.northbeam.expense.model.Category;
import com.northbeam.expense.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> listAll() {
        return repo.findAll();
    }

    public Optional<Category> findById(String id) {
        return repo.findById(id);
    }

    public Category create(String name, String description, int receiptThreshold, String currency) {
        Category c = new Category();
        c.setId("cat-" + UUID.randomUUID().toString().substring(0, 8));
        c.setName(name);
        c.setDescription(description);
        c.setReceiptThreshold(receiptThreshold);
        c.setCurrency(currency != null ? currency : "USD");
        Instant now = Instant.now();
        c.setCreatedAt(now);
        c.setUpdatedAt(now);
        return repo.save(c);
    }

    public Optional<Category> update(String id, String name, String description, Integer receiptThreshold, String currency) {
        return repo.findById(id).map(c -> {
            if (name != null) c.setName(name);
            if (description != null) c.setDescription(description);
            if (receiptThreshold != null) c.setReceiptThreshold(receiptThreshold);
            if (currency != null) c.setCurrency(currency);
            c.setUpdatedAt(Instant.now());
            return repo.save(c);
        });
    }

    public boolean delete(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
