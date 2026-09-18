package com.scaler.splitwisesept26.strategy;

import com.scaler.splitwisesept26.models.Expense;

import java.util.List;
import java.util.Set;

public interface SettleUpStrategy {
    List<Expense> settleUp(Set<Expense> expenses);
}
