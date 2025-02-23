package com.bridgelabz.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.model.GreetingMessage;
import com.bridgelabz.demo.repository.GreetingRepository;

@Service
public class GreetingService {
	
	@Autowired
	private GreetingRepository greetingRepository;

    public String getGreetingMesssage() {
        return "{\"message\": \"Hello World\"}";
    }
    public String getGreeting(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return "{\"message\": \"Hello, " + firstName + " " + lastName + "!\"}";
        } else if (firstName != null && !firstName.isEmpty()) {
            return "{\"message\": \"Hello, " + firstName + "!\"}";
        } else if (lastName != null && !lastName.isEmpty()) {
            return "{\"message\": \"Hello, " + lastName + "!\"}";
        } else {
            return "{\"message\": \"Hello, World!\"}";
        }
    }


    public GreetingMessage saveGreeting(String firstName, String lastName) {
        String message;
        
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null && !firstName.isEmpty()) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null && !lastName.isEmpty()) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello, World!";
        }

        // Save message to database
        GreetingMessage greetingMessage = new GreetingMessage(message);
        return greetingRepository.save(greetingMessage);
    }
  //UC6 - Import List
    public List<GreetingMessage> getAllGreetings() { // UC6 - Service method to fetch all greetings
        return greetingRepository.findAll();
    }
    
    
}
