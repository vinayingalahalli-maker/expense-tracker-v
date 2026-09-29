package com.northbeam.expense.repository;

import com.northbeam.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
    List<Expense> findByEmployeeId(String employeeId);
    List<Expense> findByClaimId(String claimId);
    List<Expense> findByEmployeeIdAndStatus(String employeeId, String status);
    List<Expense> findByEmployeeIdAndCategoryId(String employeeId, String categoryId);
}
