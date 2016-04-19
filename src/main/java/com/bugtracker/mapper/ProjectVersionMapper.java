package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;

import java.util.Set;

public interface ProjectVersionMapper {
    ProjectVersionDTO projectVersionToProjectVersionDTO(ProjectVersion projectVersion);
    ProjectVersion projectVersionDTOToProjectVersion(ProjectVersionDTO projectVersionDTO);
    Set<ProjectVersionDTO> projectVersionsToProjectVersionDTOs(Set<ProjectVersion> projectVersions);
    Set<ProjectVersion> projectVersionDTOsToProjectVersions(Set<ProjectVersionDTO> projectVersionDTOs);
}
