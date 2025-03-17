package com.demo.example.controller;

import com.demo.example.entity.User;
import com.demo.example.repository.UserRepository;
import com.demo.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

//    @GetMapping("/get")
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
}
