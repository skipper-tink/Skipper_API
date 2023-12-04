package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestParam Project project) {
        try {
            projectService.createProject(project);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
        try {
            return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/projects/{employerId}")
    public ResponseEntity<List<Project>> getProjectsByEmployerId(@PathVariable("employerId") long employerId) {
        try {
            return new ResponseEntity<>(projectService.getProjectsByEmployerId(employerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long projectId, @RequestBody Project project) {
        try {
            return new ResponseEntity<>(projectService.updateProject(projectId, project), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") long projectId) {
        try {
            projectService.deleteProject(projectId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/projects")
    public ResponseEntity<Project> deleteAllProjects() {
            projectService.deleteAllProjects();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
