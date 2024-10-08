package com.example.ITCONSULTANCYBACKEND.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class InternshipApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for each application

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String position;

    private String message;

    @Column(name = "resume_file_path") // Renamed for clarity
    private String resumeFilePath; // Path of the uploaded resume file

    // Default constructor
    public InternshipApplication() {
    }

    // Parameterized constructor
    public InternshipApplication(String name, String email, String phone, String position, String message, String resumeFilePath) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.message = message;
        this.resumeFilePath = resumeFilePath;
    }

    // Getters and setters

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

    @Override
    public String toString() {
        return "InternshipApplication [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
                + ", position=" + position + ", message=" + message + ", resumeFilePath=" + resumeFilePath + "]";
    }
}
