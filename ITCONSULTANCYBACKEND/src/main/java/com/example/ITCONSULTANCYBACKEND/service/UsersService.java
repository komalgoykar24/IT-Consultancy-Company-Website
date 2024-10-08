package com.example.ITCONSULTANCYBACKEND.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ITCONSULTANCYBACKEND.Repository.UsersRepository;
import com.example.ITCONSULTANCYBACKEND.entity.Users;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository; // Autowire UsersRepository

    // Method to add a new user
    public String addUser(Users user) {
        usersRepository.save(user); // Save user to the repository
        return "User added successfully"; // Return success message
    }


    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
}
