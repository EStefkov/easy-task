package com.example.easytask.services;

import com.example.easytask.entities.Project;
import com.example.easytask.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project); // Save project to the database
    }

    // Get all projects
    public List<Project> getAllProjects() {
        return projectRepository.findAll(); // Return all projects from the database
    }

    // Get a project by ID
    public Project getProjectById(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        return project.orElse(null); // Return the project or null if not found
    }

    // Update an existing project
    public Project updateProject(Long projectId, Project updatedProject) {
        Optional<Project> existingProjectOpt = projectRepository.findById(projectId);

        if (existingProjectOpt.isPresent()) {
            Project existingProject = existingProjectOpt.get();

            // Update project fields
            existingProject.setProjectName(updatedProject.getProjectName());

            // Ensure tasks are updated properly
            if (updatedProject.getTasks() != null) {
                existingProject.updateTasks(updatedProject.getTasks()); // Use the updateTasks method
            }

            // Save the updated project
            return projectRepository.save(existingProject);
        }

        return null;  // Return null if project not found
    }

    // Delete a project by ID
    public boolean deleteProject(Long projectId) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId); // Delete project from the database
            return true; // Indicate that the deletion was successful
        }
        return false; // Project was not found
    }
}
