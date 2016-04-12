package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.mapper.ProjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDTO projectToProjectDTO(Project project) {

        if (project == null) {
            return null;
        }

        ProjectDTO projectDTO = new ProjectDTO();

        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setPrivacy(project.isPrivacy());
        projectDTO.setAvatar(project.getAvatar());
        projectDTO.setComponents(project.getComponents());
        projectDTO.setVersions(project.getVersions());
        projectDTO.setIssues(project.getIssues());

        return projectDTO;
    }

    @Override
    public Project projectDTOToProject(ProjectDTO projectDTO) {
        if (projectDTO == null) {
            return null;
        }

        Project project = new Project();

        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setPrivacy(projectDTO.isPrivacy());
        project.setAvatar(projectDTO.getAvatar());
        project.setComponents(projectDTO.getComponents());
        project.setVersions(projectDTO.getVersions());
        project.setIssues(projectDTO.getIssues());

        return project;
    }

    @Override
    public List<ProjectDTO> projectsToProjectDTOs(List<Project> projects) {
        if (projects == null) {
            return null;
        }

        List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();

        for (Project project : projects) {
            projectDTOs.add(projectToProjectDTO(project));
        }

        return projectDTOs;
    }

    @Override
    public List<Project> projectDTOsToProjects(List<ProjectDTO> projectDTOs) {
        if (projectDTOs == null) {
            return null;
        }

        List<Project> projects = new ArrayList<Project>();

        for (ProjectDTO issueDTO : projectDTOs) {
            projects.add(projectDTOToProject(issueDTO));
        }

        return projects;
    }
}
