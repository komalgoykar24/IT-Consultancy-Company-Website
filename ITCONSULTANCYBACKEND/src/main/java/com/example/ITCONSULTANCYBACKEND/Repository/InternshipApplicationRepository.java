package com.example.ITCONSULTANCYBACKEND.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ITCONSULTANCYBACKEND.entity.InternshipApplication;

@Repository
public interface InternshipApplicationRepository extends JpaRepository<InternshipApplication, Long> {
    
   
    boolean existsByEmail(String email);
}
