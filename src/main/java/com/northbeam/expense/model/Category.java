package com.northbeam.expense.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    private String id;
    private String name;
    private String description;
    private int receiptThreshold;
    private String currency;
    private Instant createdAt;
    private Instant updatedAt;

    public Category() {}
    public Category(String id, String name, String description, int receiptThreshold, String currency, Instant createdAt, Instant updatedAt) {
        this.id = id; this.name = name; this.description = description;
        this.receiptThreshold = receiptThreshold; this.currency = currency;
        this.createdAt = createdAt; this.updatedAt = updatedAt;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getReceiptThreshold() { return receiptThreshold; }
    public void setReceiptThreshold(int receiptThreshold) { this.receiptThreshold = receiptThreshold; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
    public Instant getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Instant updatedAt) { this.updatedAt = updatedAt; }
}
