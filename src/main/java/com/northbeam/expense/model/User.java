package com.northbeam.expense.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String name;
    private String role;

    public User() {}
    public User(String id, String email, String password, String name, String role) {
        this.id = id; this.email = email; this.password = password; this.name = name; this.role = role;
    }
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getName() { return name; }
    public String getRole() { return role; }
}
