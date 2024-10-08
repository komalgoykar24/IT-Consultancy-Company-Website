package com.example.ITCONSULTANCYBACKEND.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITCONSULTANCYBACKEND.entity.EmployeeApplication;

@Repository
public interface EmployeeApplicationRepository extends JpaRepository<EmployeeApplication, Long> {
    
    // Add a method to check if an email already exists in the database
    boolean existsByEmail(String email);
}
