package com.example.app1.controllers;

import com.example.app1.entities.User;
import com.example.app1.repos.UserRepository;
import com.example.app1.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
     private UserService userService;
     public UserController(UserService userService) {
         this.userService = userService;
     }

    @GetMapping
    public List<User> getAllUsers(){
         return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
         return userService.saveOneUser(newUser);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
         return userService.getOneUser(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser){
         return userService.updateOneUser(userId, newUser);

    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
         userService.deleteById(userId);
    }
}
