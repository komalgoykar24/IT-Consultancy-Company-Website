package com.example.ITCONSULTANCYBACKEND.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
  
    @Id
    @Column(unique = true, nullable = false)
    private String email;    
    
    private String name;
    private String message; // Correct spelling to 'message'

    // Default constructor
    public Users() {
    }

    // Parameterized constructor
    public Users(String email, String name, String message) { // Corrected spelling here
        super();
        this.email = email;
        this.name = name;
        this.message = message; // Corrected spelling here
    }

    // Getters and setters
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() { // Corrected getter method
        return message;
    }

    public void setMessage(String message) { // Corrected setter method
        this.message = message;
    }

    @Override
    public String toString() {
        return "Details [email=" + email + ", name=" + name + ", message=" + message + "]"; // Corrected here
    }
}
