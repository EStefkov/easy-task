package com.example.easytask.repositories;

import com.example.easytask.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // JpaRepository already provides basic CRUD operations
    // You can add custom queries if needed
}