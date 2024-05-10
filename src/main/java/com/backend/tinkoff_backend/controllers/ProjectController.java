package com.backend.tinkoff_backend.controllers;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.exceptions.MyRetrievalFailureException;
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
    public ResponseEntity<Long> createProject(@RequestBody Project project) {
        return projectService.createProject(project)
                .map(id -> new ResponseEntity<>(id, HttpStatus.CREATED))
                .orElseThrow(() -> new IllegalArgumentException("Project creation error"));
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId) {
        return projectService.getProjectById(projectId)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Project getting by id error"));
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
        return projectService.updateProject(projectId, project)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseThrow(() -> new MyRetrievalFailureException("Project updating error"));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") long projectId) {
        return projectService.deleteProject(projectId)
                .map(p -> new ResponseEntity<>(p, HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new MyRetrievalFailureException("Project deletion error"));
    }

    @DeleteMapping("/projects")
    public ResponseEntity deleteAllProjects() {
        projectService.deleteAllProjects();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
