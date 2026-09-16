package com.scaler.splitwisesept26.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users_expenses")
public class UserExpense extends BaseModel{
    @ManyToOne
    private User user;

    @ManyToOne
    private Expense expense;

    private double amount;

    @Enumerated(EnumType.ORDINAL)
    private UserExpenseType userExpenseType;
}
