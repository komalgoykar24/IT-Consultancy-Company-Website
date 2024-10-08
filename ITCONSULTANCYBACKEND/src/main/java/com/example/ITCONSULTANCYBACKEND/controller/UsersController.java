package com.example.ITCONSULTANCYBACKEND.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ITCONSULTANCYBACKEND.entity.Users;
import com.example.ITCONSULTANCYBACKEND.service.UsersService;

@RestController
@RequestMapping("/contact")
public class UsersController {
	@Autowired
	private UsersService service;
	
	@GetMapping("/users")
    public List<Users> getAllUsers() {
        return service.getAllUsers();
    }
	 
	@PostMapping("/adduser")
	public ResponseEntity<String> AddUser(@RequestBody Users user) {
	    String msg = service.addUser(user);
	    return ResponseEntity.ok("{\"message\":\"" + msg + "\"}"); // Return a valid JSON response
	}

	@PostMapping("/contact")
	public ResponseEntity<String> submitContact(@RequestBody Users user) {
	    try {
	        service.addUser(user); // Reuse the AddUser method to save contact details
	        return ResponseEntity.ok("{\"message\":\"Contact message submitted successfully!\"}"); 
	    } catch (Exception e) {
	        e.printStackTrace(); // Log the error
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("{\"error\":\"Failed to submit contact message\"}");
	    }
	    
	   

}
}
	
