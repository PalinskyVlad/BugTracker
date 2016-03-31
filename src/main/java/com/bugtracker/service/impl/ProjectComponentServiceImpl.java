package com.bugtracker.service.impl;

import com.bugtracker.entity.ProjectComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectComponentRepository;
import com.bugtracker.service.ProjectComponentService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectComponentServiceImpl implements ProjectComponentService{

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Override
    public ProjectComponent addProjectComponent(ProjectComponent projectComponent) {
        ProjectComponent savedProjectComponent = projectComponentRepository.saveAndFlush(projectComponent);

        return savedProjectComponent;
    }

    @Override
    public void delete(long id) {
        projectComponentRepository.delete(id);
    }

    @Override
    public ProjectComponent getByName(String name) {
        return projectComponentRepository.getByName(name);
    }

    @Override
    public ProjectComponent editProjectComponent(ProjectComponent projectComponent) {
        return null;
    }

    @Override
    public List<ProjectComponent> getAll() {
        return null;
    }
}
