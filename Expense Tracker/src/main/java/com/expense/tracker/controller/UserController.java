package com.expense.tracker.controller;

import com.expense.tracker.entity.User;
import com.expense.tracker.repository.UserRepository;
import com.expense.tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user){

        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return "User Delete Successfully";
    }
}
