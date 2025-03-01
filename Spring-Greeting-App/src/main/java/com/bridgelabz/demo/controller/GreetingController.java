package com.bridgelabz.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.demo.model.GreetingMessage;
import com.bridgelabz.demo.repository.GreetingRepository;
import com.bridgelabz.demo.service.GreetingService;

@RestController
//UC1
@RequestMapping("/greeting")
public class GreetingController {
   //Use Case1
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
    
    @Autowired
    private GreetingService greetingService;

  //use case2
    @GetMapping("/greetingg")
    public String getGreetingMesssage() {
        return greetingService.getGreetingMesssage();
        

    }
    

    
    //use case 3
    @GetMapping("/param")
    public String getGreeting(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName) {
        
        return greetingService.getGreeting(firstName, lastName);

    }
    
    //use case 4
    @PostMapping("/params")
    public GreetingMessage saveGreeting(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName) {
        
        return greetingService.saveGreeting(firstName, lastName);

      
      	
    }
    
    
    //USECASE 5
    @Autowired
    private GreetingRepository greetingRepository;


    // Fetch Greeting by ID
    @GetMapping("/{id}")
    public Optional<GreetingMessage> getGreetingById(@PathVariable Long id) {
        return greetingRepository.findById(id);
        
        
    }
    
    @PostMapping("/add")
    public GreetingMessage addGreeting(@RequestParam String message) {
        GreetingMessage greeting = new GreetingMessage(message);
        return greetingRepository.save(greeting);
 
        
    }
    
  //UC6 - Import List
    @GetMapping("/all") // UC6 - Fetch all greetings
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }
    
 // UC7: Edit a greeting message
    
    @PutMapping("/update/{id}") 
    public GreetingMessage updateGreeting(@PathVariable Long id, @RequestParam String message) { 
        Optional<GreetingMessage> existingGreeting = greetingRepository.findById(id); 
        if (existingGreeting.isPresent()) { 
            GreetingMessage greeting = existingGreeting.get(); 
            greeting.setMessage(message); 
            return greetingRepository.save(greeting); 
        } else { 
            throw new RuntimeException("Greeting not found with id: " + id); 
        } 
    }
    
    // UC8: Delete a greeting message 
    @DeleteMapping("/delete/{id}") 
    public String deleteGreeting(@PathVariable Long id) { 
        if (greetingRepository.existsById(id)) { 
            greetingRepository.deleteById(id); 
            return "Greeting deleted successfully";
        } else { 
            throw new RuntimeException("Greeting not found with id: " + id);
        } 
    } 
    
    
    
    
}
