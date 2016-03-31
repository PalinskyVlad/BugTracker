package com.bugtracker.service.impl;

import com.bugtracker.entity.ProjectVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectVersionRepository;
import com.bugtracker.service.ProjectVersionService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectVersionServiceImpl implements ProjectVersionService {

    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @Override
    public ProjectVersion addProjectComponent(ProjectVersion projectComponent) {
        ProjectVersion savedProjectVercion = projectVersionRepository.saveAndFlush(projectComponent);

        return savedProjectVercion;
    }

    @Override
    public void delete(long id) {
        projectVersionRepository.delete(id);
    }

    @Override
    public ProjectVersion getByName(String name) {
        return projectVersionRepository.getByName(name);
    }

    @Override
    public ProjectVersion editProjectComponent(ProjectVersion projectComponent) {
        return projectVersionRepository.saveAndFlush(projectComponent);
    }

    @Override
    public List<ProjectVersion> getAll() {
        return projectVersionRepository.findAll();
    }
}
