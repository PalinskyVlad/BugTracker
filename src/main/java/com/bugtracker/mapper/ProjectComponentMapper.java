package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;

import java.util.Set;

public interface ProjectComponentMapper {
    ProjectComponentDTO projectComponentToProjectComponentDTO(ProjectComponent projectComponent);
    ProjectComponent projectComponentDTOToProjectComponent(ProjectComponentDTO projectComponentDTO);
    Set<ProjectComponentDTO> projectComponentsToProjectComponentDTOs(Set<ProjectComponent> projectComponents);
    Set<ProjectComponent> projectComponentDTOsToProjectComponents(Set<ProjectComponentDTO> projectComponentDTOs);
}
