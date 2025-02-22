package com.bridgelabz.demo.service;


import org.springframework.stereotype.Service;

@Service
public class GreetingService {

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

  //for testing 
  //GET http://localhost:8080/greeting
//  	GET http://localhost:8080/greeting?firstName=Manish
//  		GET http://localhost:8080/greeting?lastName=Patel
//  			GET http://localhost:8080/greeting?firstName=Manish&lastName=Patel

}
