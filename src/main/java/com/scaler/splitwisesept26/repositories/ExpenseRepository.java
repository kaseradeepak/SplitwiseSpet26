package com.scaler.splitwisesept26.repositories;

import com.scaler.splitwisesept26.models.Expense;
import com.scaler.splitwisesept26.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByGroup(Group group);
}
