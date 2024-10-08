package com.example.ITCONSULTANCYBACKEND.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ITCONSULTANCYBACKEND.entity.Users;
public interface UsersRepository extends JpaRepository<Users, String> {
    // Additional query methods (if needed) can be defined here
}
