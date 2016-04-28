package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectMapperImpl extends CustomMapper<ProjectDTO, Project> implements ProjectMapper {

    @Autowired
    private MapperFacade mapper;

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

    @Override
    public void mapAtoB(ProjectDTO a, Project b, MappingContext context) {
        b.setId(a.getId());
        b.setName(a.getName());
        b.setDescription(a.getDescription());
    }

    @Override
    public void mapBtoA(Project b, ProjectDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setName(b.getName());
        a.setDescription(b.getDescription());
    }
}
