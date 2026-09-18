package com.scaler.splitwisesept26.repositories;

import com.scaler.splitwisesept26.models.User;
import com.scaler.splitwisesept26.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {
    List<UserExpense> findByUser(User user);
}
