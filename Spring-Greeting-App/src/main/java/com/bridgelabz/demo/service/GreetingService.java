package com.bridgelabz.demo.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreetingMesssage() {
        return "{\"message\": \"Hello World\"}";
    }
}
