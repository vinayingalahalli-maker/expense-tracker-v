package com.northbeam.expense;

import com.northbeam.expense.model.*;
import com.northbeam.expense.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepo, CategoryRepository categoryRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Seed users
        if (userRepo.count() == 0) {
            userRepo.save(new User("usr-001", "alice@northbeam.com", passwordEncoder.encode("password123"), "Alice Chen", "employee"));
            userRepo.save(new User("usr-002", "bob@northbeam.com", passwordEncoder.encode("password123"), "Bob Martinez", "approver"));
            userRepo.save(new User("usr-003", "carol@northbeam.com", passwordEncoder.encode("password123"), "Carol Singh", "finance"));
        }

        // Seed categories
        if (categoryRepo.count() == 0) {
            Instant now = Instant.parse("2024-01-01T00:00:00Z");
            categoryRepo.save(new Category("cat-001", "Travel", "Flights, trains, taxis and other transport", 50, "USD", now, now));
            categoryRepo.save(new Category("cat-002", "Meals & Entertainment", "Business meals and client entertainment", 25, "USD", now, now));
            categoryRepo.save(new Category("cat-003", "Accommodation", "Hotels and other lodging", 100, "USD", now, now));
            categoryRepo.save(new Category("cat-004", "Office Supplies", "Stationery, equipment and other office items", 30, "USD", now, now));
        }
    }
}
