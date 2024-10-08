package com.example.ITCONSULTANCYBACKEND.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ITCONSULTANCYBACKEND.entity.InternshipApplication;
import com.example.ITCONSULTANCYBACKEND.Repository.InternshipApplicationRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class InternshipService {

    @Autowired
    private InternshipApplicationRepository internshipApplicationRepository;

    private final String UPLOAD_DIR = "C:\\uploads\\"; 
    public String applyForInternship(InternshipApplication application, MultipartFile resume) {
        // Check if the email already exists
        if (internshipApplicationRepository.existsByEmail(application.getEmail())) {
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
            // Append timestamp to the filename to avoid collisions
            String uniqueFileName = System.currentTimeMillis() + "_" + originalFilename; 
            String resumeFilePath = UPLOAD_DIR + uniqueFileName;

            try {
               
                resume.transferTo(new File(resumeFilePath));
                application.setResumeFilePath(resumeFilePath); // Save the file path in the application object
            } catch (IOException e) {
                return "Failed to upload resume: " + e.getMessage();
            }
        } else {
            return "Resume file is required.";
        }

        // Save the application if the email is unique
        internshipApplicationRepository.save(application);
        return "Application submitted successfully!";
    }
    public List<InternshipApplication> getAllInternshipApplications() {
        return internshipApplicationRepository.findAll();
    }
}
