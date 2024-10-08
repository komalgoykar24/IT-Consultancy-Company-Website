package com.example.ITCONSULTANCYBACKEND.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ITCONSULTANCYBACKEND.entity.InternshipApplication;
import com.example.ITCONSULTANCYBACKEND.service.InternshipService;

@RestController
@RequestMapping("/internship")
public class InternshipController {

    @Autowired
    private InternshipService internshipService;

     
    @PostMapping("/apply")
    public ResponseEntity<String> apply(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("position") String position,
            @RequestParam("message") String message,
            @RequestParam("resume") MultipartFile resume) {
        
        try {
            InternshipApplication application = new InternshipApplication();
            application.setName(name);
            application.setEmail(email);
            application.setPhone(phone);
            application.setPosition(position);
            application.setMessage(message);

            // Call the service to process the application
            String responseMessage = internshipService.applyForInternship(application, resume);
            return ResponseEntity.ok(responseMessage);
        } catch (Exception e) {
            // Log the error for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("An error occurred while submitting your application. Please try again later.");
        }
    }

    @GetMapping("/internships")
    public List<InternshipApplication> getAllInternshipApplications() {
        return internshipService.getAllInternshipApplications();
    }
}
