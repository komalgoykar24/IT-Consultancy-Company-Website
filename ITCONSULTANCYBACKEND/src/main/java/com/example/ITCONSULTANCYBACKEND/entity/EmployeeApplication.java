package com.example.ITCONSULTANCYBACKEND.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeeApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String position;
    private String message;
    private String resumeFilePath; // Store the path to the uploaded resume

    // Getters and Setters for all fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResumeFilePath() {
        return resumeFilePath;
    }

    public void setResumeFilePath(String resumeFilePath) {
        this.resumeFilePath = resumeFilePath;
    }
}
