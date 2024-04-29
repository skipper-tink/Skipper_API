package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.repositories.jpaRepositories.ProjectRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Optional<Long> createProject(Project project) {
        return Optional.of(new Project(project))
                .map(p -> projectRepository.save(p).getId());
    }

    public Optional<Project> getProjectById(long projectId) {
        return projectRepository.findById(projectId);
    }

    public List<Project> getProjectsByEmployerId(long employerId) {
        return projectRepository.findAllByEmployerId(employerId);
    }

    public List<Project> getAllProjects() throws ServiceException {
        return projectRepository.findAll();
    }

    public Optional<Project> updateProject(long projectId, Project project) {
        return projectRepository.findById(projectId)
                .map(p -> mergeProject(p, project))
                .map(p -> projectRepository.save(p));
    }

    public Optional<Project> deleteProject(long projectId) throws ServiceException {
        return projectRepository.findById(projectId).stream()
                .peek(p -> projectRepository.deleteById(projectId))
                .findAny();
    }

    public void deleteAllProjects() {
        projectRepository.deleteAll();
    }

    private Project mergeProject(Project project, Project p) {
        project.setDescription(p.getDescription());
        project.setName(p.getName());
        project.setEmployerId(p.getEmployerId());
        project.setStatus(p.getStatus());
        return project;
    }
}
