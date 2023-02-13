package com.example.school_system.repository;

import com.example.school_system.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReository extends JpaRepository<User, Long> {
}
