package com.northbeam.expense.repository;

import com.northbeam.expense.model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, String> {
    List<Claim> findByEmployeeId(String employeeId);
    List<Claim> findByStatus(String status);
    List<Claim> findByEmployeeIdAndStatus(String employeeId, String status);
}
