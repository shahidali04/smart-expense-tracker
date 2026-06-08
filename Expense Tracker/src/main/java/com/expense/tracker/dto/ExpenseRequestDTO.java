package com.expense.tracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    @Positive(message = "Amount must be greater then 0")
    private Double amount;

    @ NotBlank(message = "Category is required")
    private String category;

    private LocalDate expenseDate;
}
