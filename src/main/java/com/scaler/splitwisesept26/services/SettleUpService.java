package com.scaler.splitwisesept26.services;

import com.scaler.splitwisesept26.exceptions.GroupNotFoundException;
import com.scaler.splitwisesept26.exceptions.UserNotFoundException;
import com.scaler.splitwisesept26.models.Expense;
import com.scaler.splitwisesept26.models.Group;
import com.scaler.splitwisesept26.models.User;
import com.scaler.splitwisesept26.models.UserExpense;
import com.scaler.splitwisesept26.repositories.ExpenseRepository;
import com.scaler.splitwisesept26.repositories.GroupRepository;
import com.scaler.splitwisesept26.repositories.UserExpenseRepository;
import com.scaler.splitwisesept26.repositories.UserRepository;
import com.scaler.splitwisesept26.strategy.SettleUpStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SettleUpService {
    private UserRepository userRepository;
    private UserExpenseRepository userExpenseRepository;
    private SettleUpStrategy settleUpStrategy;
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;

    //Constructor Injection - Injecting dependency via constructor.
    public SettleUpService(UserRepository userRepository,
                           UserExpenseRepository userExpenseRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository,
                           ExpenseRepository expenseRepository) {
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> settleUpUser(Long userId) throws UserNotFoundException {
        // 1. Get the user with the given userId from the db.
        // 2. Get all the expenses for this user from the db.
        // 3. Iterate through all the expenses and find out total amount paid extra/lesser
        // by every user involved in the expenses.
        // 4. Use a settle up algorithm to settle up the amounts.

        Optional<User> optionalUser = userRepository.findById(userId);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }

        User user = optionalUser.get();

        List<UserExpense> userExpenses = userExpenseRepository.findByUser(user);

        // Get the expenses from the userExpenses.
        Set<Expense> expensesToSettleUp = new HashSet<Expense>();

        for (UserExpense userExpense : userExpenses) {
            expensesToSettleUp.add(userExpense.getExpense());
        }

        //settleUp algorithm
        List<Expense> expenses = settleUpStrategy.settleUp(expensesToSettleUp);

        /*
        user A calls settleUp functionality

        A -> B : 100 Rs
        A -> C : 80  Rs
        X -> A : 500 Rs
        X -> Y : 250 Rs
        B -> C : 50 Rs

        Only return the expenses from the list of expenses where current user is present.
         */

        List<Expense> expensesToReturn = new ArrayList<>();

        for (Expense expense : expenses) {
            for (UserExpense userExpense : userExpenses) {
                if (userExpense.getUser().equals(user)) {
                    expensesToReturn.add(expense);
                    break;
                }
            }
        }

        return expensesToReturn;
    }

    public List<Expense> settleUpGroup(Long groupId) throws GroupNotFoundException {
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if (optionalGroup.isEmpty()) {
            throw new GroupNotFoundException("Group with id: " + groupId + " not found");
        }

        Group group = optionalGroup.get();

        // Get all the expenses for this group.
        // select * from expenses where group_id = ?
        List<Expense> expensesToSettleUp = expenseRepository.findByGroup(group);

        /// TODO

        return null;
    }
}
