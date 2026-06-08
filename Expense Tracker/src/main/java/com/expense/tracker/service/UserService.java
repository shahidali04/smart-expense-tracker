package com.expense.tracker.service;

import com.expense.tracker.entity.Expense;
import com.expense.tracker.entity.User;
import com.expense.tracker.exception.UserNotFoundException;
import com.expense.tracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not Found"));
    }

    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User Not Found"));

        userRepository.delete(user);
    }

}
