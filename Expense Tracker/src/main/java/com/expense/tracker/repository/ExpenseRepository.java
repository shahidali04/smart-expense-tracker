package com.expense.tracker.repository;

import com.expense.tracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository
        extends JpaRepository<Expense, Long> {

    List<Expense> findByCategoryIgnoreCase(String category);

    List<Expense> findByUserId(Long userId);

    @Query("""
       SELECT COALESCE(SUM(e.amount),0)
       FROM Expense e
       WHERE e.user.id = :userId
       """)
    Double getTotalExpenseByUserId(@Param("userId") Long userId);

    @Query("""
            SELECT COALESCE(SUM(e.amount),0)
            FROM Expense e
            WHERE LOWER(e.category) = LOWER(:category)
            """)
    Double getTotalExpenseByCategory(
            @Param("category") String category);

    @Query("""
            SELECT COALESCE(SUM(e.amount),0)
            FROM Expense e 
            WHERE MONTH(e.expenseDate) = :month
            """)
    Double getTotalExpenseByMonth(@Param("month") int month);
}
