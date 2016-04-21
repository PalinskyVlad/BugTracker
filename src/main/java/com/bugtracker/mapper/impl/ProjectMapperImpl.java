package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.mapper.ProjectMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectMapperImpl implements ProjectMapper {

    private final static MapperFacade mapper;

    static
    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Project.class, ProjectDTO.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }

    @Override
    public ProjectDTO projectToProjectDTO(Project project) {
        return mapper.map(project, ProjectDTO.class);
    }

    @Override
    public Project projectDTOToProject(ProjectDTO projectDTO) {
        return mapper.map(projectDTO, Project.class);
    }

    @Override
    public Set<ProjectDTO> projectsToProjectDTOs(Set<Project> projects) {
        if (projects == null) {
            return null;
        }

        Set<ProjectDTO> projectDTOs = new HashSet<ProjectDTO>();

        for (Project project : projects) {
            projectDTOs.add(projectToProjectDTO(project));
        }

        return projectDTOs;
    }

    @Override
    public Set<Project> projectDTOsToProjects(Set<ProjectDTO> projectDTOs) {
        if (projectDTOs == null) {
            return null;
        }

        Set<Project> projects = new HashSet<Project>();

        for (ProjectDTO issueDTO : projectDTOs) {
            projects.add(projectDTOToProject(issueDTO));
        }

        return projects;
    }
}
