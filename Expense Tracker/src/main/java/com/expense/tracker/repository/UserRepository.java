package com.expense.tracker.repository;

import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository
    extends JpaRepository<User, Long>{

}
