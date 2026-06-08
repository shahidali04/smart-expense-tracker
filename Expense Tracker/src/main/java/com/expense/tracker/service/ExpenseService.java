package com.expense.tracker.service;

import com.expense.tracker.dto.ExpenseRequestDTO;
import com.expense.tracker.dto.ExpenseResponseDTO;
import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import com.expense.tracker.exception.ExpenseNotFoundException;
import com.expense.tracker.exception.UserNotFoundException;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public ExpenseService(ExpenseRepository expenseRepository,
                          UserRepository userRepository){
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }


    // DTO IMPLEMENTATION
    public ExpenseResponseDTO addExpense(
            Long userId,
            ExpenseRequestDTO requestDTO) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User Not Found"));

        Expense expense = new Expense();

        expense.setTitle(requestDTO.getTitle());
        expense.setAmount(requestDTO.getAmount());
        expense.setCategory(requestDTO.getCategory());
        expense.setExpenseDate(requestDTO.getExpenseDate());
        expense.setUser(user);

        Expense savedExpense =
                expenseRepository.save(expense);

        ExpenseResponseDTO response =
                new ExpenseResponseDTO();

        response.setId(savedExpense.getId());
        response.setTitle(savedExpense.getTitle());
        response.setAmount(savedExpense.getAmount());
        response.setCategory(savedExpense.getCategory());
        response.setExpenseDate(savedExpense.getExpenseDate());
        response.setUserId(savedExpense.getUser().getId());

        return response;
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {

        Expense expense = expenseRepository.findById(id)
                .orElseThrow();

        expense.setTitle(updatedExpense.getTitle());
        expense.setAmount(updatedExpense.getAmount());
        expense.setCategory(updatedExpense.getCategory());
        expense.setExpenseDate(updatedExpense.getExpenseDate());

        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id){
        Expense expense = expenseRepository.findById(id)
                .orElseThrow();

        expenseRepository.delete(expense);
    }

    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id)
                .orElseThrow(() ->
                new ExpenseNotFoundException(
                        "Expense Not Found"
                ));
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category);
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Page<Expense> getExpensesWithPagination(Pageable pageable){

        return expenseRepository.findAll(pageable);
    }

    public Double getTotalExpenseByUserId(Long userId){

        userRepository.findById(userId)
                .orElseThrow(() ->
                new UserNotFoundException("User Not Found"));

        return expenseRepository.getTotalExpenseByUserId(userId);
    }

    public Double getTotalExpenseByCategory(String category){

        return expenseRepository.getTotalExpenseByCategory(category);
    }

    public Double getTotalExpenseByMonth(int month){

        return expenseRepository.getTotalExpenseByMonth(month);
    }

}
