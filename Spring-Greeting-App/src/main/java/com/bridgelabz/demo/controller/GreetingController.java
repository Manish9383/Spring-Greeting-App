package com.bridgelabz.demo.controller;

import org.springframework.web.bind.annotation.*;

import com.bridgelabz.demo.model.GreetingMessage;
import com.bridgelabz.demo.service.GreetingService;

@RestController
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
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
        
//        curl -X GET http://localhost:8080/greeting

    }
  //use case2
    @GetMapping("/greetingg")
    public String getGreetingMesssage() {
        return greetingService.getGreetingMesssage();
        
//        http://localhost:8080/greeting/greetingg
    }
    

    
    //use case 3
    @GetMapping("/param")
    public String getGreeting(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName) {
        
        return greetingService.getGreeting(firstName, lastName);
//        http://localhost:8080/greeting/param?firstName=Manish
    }
    
    //use case 4
    @PostMapping("/params")
    public GreetingMessage saveGreeting(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName) {
        
        return greetingService.saveGreeting(firstName, lastName);
        
      //first create multiple ids..
      //POST http://localhost:8080/greeting?firstName=Manish&lastName=Patel
//      	POST http://localhost:8080/greeting?firstName=Manish&lastName=Singh
//      		
//      		 to View Data in H2 Console
      //
//      	    open the url in web---  http://localhost:8080/h2-console
//      	    Enter JDBC URL: jdbc:h2:mem:greetingdb
//      	    Run the SQL query:
      //
//      	SELECT * FROM greetings;
      //
      //	
    }
    
}
