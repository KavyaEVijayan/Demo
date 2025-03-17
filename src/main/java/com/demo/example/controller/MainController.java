package com.demo.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class MainController {
    @GetMapping
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
