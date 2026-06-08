package com.expense.tracker.controller;

import com.expense.tracker.dto.ExpenseRequestDTO;
import com.expense.tracker.dto.ExpenseResponseDTO;
import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import com.expense.tracker.repository.ExpenseRepository;
import com.expense.tracker.repository.UserRepository;
import com.expense.tracker.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;

    }

    @PostMapping("/{userId}")
    public ExpenseResponseDTO addExpense(@PathVariable Long userId,
                                         @Valid @RequestBody ExpenseRequestDTO requestDTO){

        return expenseService.addExpense(userId, requestDTO);
    }

    @GetMapping
    public List<Expense> getAllExpense(){
        return expenseService.getAllExpense();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id,
                                 @RequestBody Expense expense){
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public String deleteExpense(@PathVariable Long id){

        expenseService.deleteExpense(id);

        return "Expense Deleted successfully";
    }

    @GetMapping("/category/{category}")
    public List<Expense> getExpensesByCategory(@PathVariable String category){

        return expenseService.getExpensesByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> getExpensesByUserId(
            @PathVariable Long userId) {

        return expenseService.getExpensesByUserId(userId);
    }

    @GetMapping("/pagination")
    public Page<Expense> getExpensesWithPagination(Pageable pageable){

        return expenseService.getExpensesWithPagination(pageable);
    }

    @GetMapping("/user/{userId}/total")
    public Double getTotalExpenseByUserId(@PathVariable Long userId){

        return expenseService.getTotalExpenseByUserId(userId);
    }

    @GetMapping("/category/{category}/total")
    public Double getTotalExpenseByCategory(@PathVariable String category){

        return expenseService.getTotalExpenseByCategory(category);
    }

    @GetMapping("/month/{month}/total")
    public Double getTotalExpenseByMonth(@PathVariable int month){

        return expenseService.getTotalExpenseByMonth(month);
    }
}
