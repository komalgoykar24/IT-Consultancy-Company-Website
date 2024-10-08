package com.example.ITCONSULTANCYBACKEND.service;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    
    private final String ADMIN_USERNAME = "admin"; // Replace with your username
    private final String ADMIN_PASSWORD = "admin123"; // Replace with your password

    public boolean authenticate(String username, String password) {
        return ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password);
    }
}
