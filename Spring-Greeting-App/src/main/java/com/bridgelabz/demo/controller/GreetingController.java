package com.bridgelabz.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.bridgelabz.demo.service.GreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"Hello, GET request received!\"}";
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello, POST request received!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello, PUT request received!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello, DELETE request received!\"}";
    }
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greetingg")
    public String getGreetingMesssage() {
        return greetingService.getGreetingMesssage();
    }
    
    
}
