package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.repositories.ProjectRepository;
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
        Optional<Project> opt = projectRepository.findByEmployerIdAndName(project.getEmployerId(), project.getName());

        return Optional.empty()
                .map(p -> opt.isEmpty()
                        ? null
                        : mergeProject(new Project(), project))
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
        Optional<Project> opt = projectRepository.findById(projectId);

        //Check if new p.Name is the same as the previous
        //if it isn't, we'll check if this employer can have such a project
        return opt
                .map(p -> p.getName().equals(project.getName())
                        ? mergeProject(p, project)
                        : (projectRepository.findByEmployerIdAndName(p.getEmployerId(), project.getName()).isPresent()
                            ? null
                            : mergeProject(p, project)))
                .map(p -> projectRepository.save(p));
    }

    public Optional<Project> deleteProject(long projectId) throws ServiceException {
        Optional<Project> opt = projectRepository.findById(projectId);
        return opt
                .map(p -> {
                    projectRepository.deleteById(projectId);
                    return p;
                });
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
