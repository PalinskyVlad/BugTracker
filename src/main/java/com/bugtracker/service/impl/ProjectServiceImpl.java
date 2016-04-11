package com.bugtracker.service.impl;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectRepository;
import com.bugtracker.service.ProjectService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper mapper;

    @Override
    public ProjectDTO addProject(ProjectDTO projectDTO) {
        ProjectDTO savedProject = mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));

        return savedProject;
    }

    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override
    public ProjectDTO getByName(String name) {
        return mapper.projectToProjectDTO(projectRepository.findByName(name));
    }

    @Override
    public ProjectDTO editProject(ProjectDTO projectDTO) {
        return mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));
    }

    @Override
    public List<String> getAllNames() {
        return projectRepository.findAllNames();
    }

    @Override
    public List<ProjectDTO> getAll() {
        return mapper.projectsToProjectDTOs(projectRepository.findAll());
    }
}
