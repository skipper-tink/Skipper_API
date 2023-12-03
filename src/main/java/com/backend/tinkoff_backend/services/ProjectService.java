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

    public void createProject(Project project) throws ServiceException{
        try {
            projectRepository.save(new Project(project.getProjectName(),
                    project.getProjectDescription(), project.getProjectStatus(),
                    project.getEmployerId()));
        } catch (IllegalArgumentException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public Project getProjectById(long projectId) throws ServiceException {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent())
            return projectData.get();
        throw new ServiceException("No such project");
    }

    public Project updateProject(long projectId, Project project) throws ServiceException {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent()) {
            Project _project = projectData.get();
            _project.setProjectName(project.getProjectName());
            _project.setProjectStatus(project.getProjectStatus());
            _project.setProjectDescription(project.getProjectDescription());
            _project.setEmployerId(project.getEmployerId());
            return projectRepository.save(_project);
        }
        throw new ServiceException("No such project");
    }

    public void deleteProject(long projectId) throws ServiceException {
        Optional<Project> projectData = projectRepository.findById(projectId);

        if (projectData.isPresent())
            projectRepository.deleteById(projectId);
        throw new ServiceException("No such project");
    }

    public void deleteAllProjects() throws ServiceException {
        List<Project> projects = projectRepository.findAll();

        if (projects.isEmpty())
            throw new ServiceException("No projects");
        projectRepository.deleteAll();
    }
}
