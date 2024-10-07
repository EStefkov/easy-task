package com.example.easytask.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Task> tasks = new ArrayList<>(); // Always initialize the list

    public Project() {
        this.createdAt = LocalDateTime.now();
    }

    public Project(String projectName) {
        this.projectName = projectName;
        this.createdAt = LocalDateTime.now();
    }

    // Method to safely update the tasks
    public void updateTasks(List<Task> newTasks) {
        // Clear the current tasks and set the project reference for new tasks
        this.tasks.clear();
        for (Task task : newTasks) {
            task.setProject(this);
            this.tasks.add(task);
        }
    }
}
