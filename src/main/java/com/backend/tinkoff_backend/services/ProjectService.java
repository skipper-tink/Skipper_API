package com.backend.tinkoff_backend.services;

import com.backend.tinkoff_backend.entities.Project;
import com.backend.tinkoff_backend.repositories.ProjectRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
