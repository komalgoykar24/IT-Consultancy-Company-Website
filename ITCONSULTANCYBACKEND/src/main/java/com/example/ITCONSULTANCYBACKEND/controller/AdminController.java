package com.example.ITCONSULTANCYBACKEND.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ITCONSULTANCYBACKEND.entity.EmployeeApplication;
import com.example.ITCONSULTANCYBACKEND.entity.InternshipApplication;
import com.example.ITCONSULTANCYBACKEND.entity.Users;
import com.example.ITCONSULTANCYBACKEND.service.AdminService;
import com.example.ITCONSULTANCYBACKEND.service.EmployeeService;
import com.example.ITCONSULTANCYBACKEND.service.InternshipService;
import com.example.ITCONSULTANCYBACKEND.service.UsersService;

import dto.AdminLoginRequest;

import java.util.List;

@Controller
@RequestMapping("/")
public class AdminController {

    @Autowired
    private UsersService usersService; 

    @Autowired
    private InternshipService internshipService; 

    @Autowired
    private EmployeeService employeeService; 

    @Autowired
    private AdminService adminService; 

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AdminLoginRequest loginRequest) {
        boolean isAuthenticated = adminService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    } // Added closing bracket here

    @GetMapping("/contactDetails")
    public String getUserDetails(Model model) {
        List<Users> users = usersService.getAllUsers();
        model.addAttribute("users", users); // Add user data to the model
        return "contactDetails.html"; // Return the view name for contact details
    }

    @GetMapping("/internships")
    public String getInternshipApplications(Model model) {
        List<InternshipApplication> internships = internshipService.getAllInternshipApplications();
        model.addAttribute("internships", internships);
        return "internshipDetails.html"; // Thymeleaf template for internships
    }

    @GetMapping("/employments")
    public String getEmploymentApplications(Model model) {
        List<EmployeeApplication> employments = employeeService.getAllEmployeeApplications();
        model.addAttribute("employments", employments);
        return "employmentDetails.html"; // Thymeleaf templat
    }
}
