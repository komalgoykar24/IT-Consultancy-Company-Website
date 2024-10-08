package com.example.ITCONSULTANCYBACKEND.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ITCONSULTANCYBACKEND.entity.EmployeeApplication;
import com.example.ITCONSULTANCYBACKEND.Repository.EmployeeApplicationRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeApplicationRepository employeeApplicationRepository;

    private final String UPLOAD_DIR = "C:\\uploads\\employees\\"; // Specify your employee upload directory

    public String applyForEmployee(EmployeeApplication application, MultipartFile resume) {
        // Check if the email already exists
        if (employeeApplicationRepository.existsByEmail(application.getEmail())) {
            return "Email already exists. Please use a different email.";
        }

        // Handle the resume file upload
        if (resume != null && !resume.isEmpty()) {
            // Ensure the upload directory exists
            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs(); // Create the directory if it does not exist
            }

            // Handle potential file name collisions
            String originalFilename = resume.getOriginalFilename();
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFilename; 
            String resumeFilePath = UPLOAD_DIR + uniqueFileName;

            try {
                // Save the resume file to the specified directory
                resume.transferTo(new File(resumeFilePath));
                application.setResumeFilePath(resumeFilePath); // Save the file path in the application object
            } catch (IOException e) {
                return "Failed to upload resume: " + e.getMessage();
            }
        } else {
            return "Resume file is required.";
        }

        // Save the application if the email is unique
        employeeApplicationRepository.save(application);
        return "Application submitted successfully!";
    }
    
    public List<EmployeeApplication> getAllEmployeeApplications() {
        return employeeApplicationRepository.findAll();
    }
}
