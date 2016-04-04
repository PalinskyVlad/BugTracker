package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Mapper
public interface ProjectMapper {
    ProjectDTO projectToProjectDTO(Project project);
    Project projectDTOToProject(ProjectDTO projectDTO);
    List<ProjectDTO> projectsToProjectDTOs(List<Project> projects);
    List<Project> projectDTOsToProjects(List<ProjectDTO> projectDTOs);
}
