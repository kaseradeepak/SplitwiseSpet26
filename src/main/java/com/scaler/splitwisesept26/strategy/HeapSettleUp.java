package com.scaler.splitwisesept26.strategy;

import com.scaler.splitwisesept26.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class HeapSettleUp implements SettleUpStrategy {
    @Override
    public List<Expense> settleUp(Set<Expense> expenses) {
        // DSA problem.


        // Implement settle-up algorithm using Min & Max Heap.
        return List.of();
    }
}
