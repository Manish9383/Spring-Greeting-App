package com.bridgelabz.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "greetings")
public class GreetingMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    public GreetingMessage() {}

    public GreetingMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}