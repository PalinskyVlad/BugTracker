package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Mapper
public interface ProjectVersionMapper {
    ProjectVersionDTO projectVersionToProjectVersionDTO(ProjectVersion projectVersion);
    ProjectVersion projectVersionDTOToProjectVersion(ProjectVersionDTO projectVersionDTO);
    List<ProjectVersionDTO> projectVersionsToProjectVersionDTOs(List<ProjectVersion> projectVersions);
    List<ProjectVersion> projectVersionDTOsToProjectVersions(List<ProjectVersionDTO> projectVersionDTOs);
}
