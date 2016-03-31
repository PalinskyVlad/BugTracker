package com.bugtracker.service.impl;

import com.bugtracker.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectRepository;
import com.bugtracker.service.ProjectService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project) {
        Project savedProject = projectRepository.saveAndFlush(project);

        return savedProject;
    }

    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public Project getByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public Project editProject(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }
}
