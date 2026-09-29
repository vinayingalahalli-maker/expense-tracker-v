package com.northbeam.expense.repository;

import com.northbeam.expense.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {}
