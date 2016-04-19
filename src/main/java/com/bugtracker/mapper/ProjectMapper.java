package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;

import java.util.Set;

public interface ProjectMapper {
    ProjectDTO projectToProjectDTO(Project project);
    Project projectDTOToProject(ProjectDTO projectDTO);
    Set<ProjectDTO> projectsToProjectDTOs(Set<Project> projects);
    Set<Project> projectDTOsToProjects(Set<ProjectDTO> projectDTOs);
}
