package com.example.demospringbuddyproject.repo;

import com.example.demospringbuddyproject.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}