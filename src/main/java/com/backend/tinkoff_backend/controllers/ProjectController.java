package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
import com.backend.tinkoff_backend.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/projects")
    public ResponseEntity<Long> createProject(@RequestBody Project project) {
        Optional<Long> opt = projectService.createProject(project);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.CREATED);
        }
        throw new IllegalArgumentException("Project creation error");
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
        Optional<Project> opt = projectService.getProjectById(projectId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
        throw new MyRetrievalFailureException("Project getting by id error");
    }

    @GetMapping("/projects/{employerId}")
    public ResponseEntity<List<Project>> getProjectsByEmployerId(@PathVariable("employerId") long employerId) {
        return new ResponseEntity<>(projectService.getProjectsByEmployerId(employerId), HttpStatus.OK);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long projectId, @RequestBody Project project) {
        Optional<Project> opt = projectService.updateProject(projectId, project);
        if (opt.isPresent()) {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        } throw new MyRetrievalFailureException("Project updating error");
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") long projectId) {
        Optional<Project> opt = projectService.deleteProject(projectId);
        if (opt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } throw new MyRetrievalFailureException("Project deletion error");
    }

    @DeleteMapping("/projects")
    public ResponseEntity<Project> deleteAllProjects() {
        projectService.deleteAllProjects();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
