package com.bugtracker.mapper;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Mapper
public interface ProjectComponentMapper {
    ProjectComponentDTO projectComponentToProjectComponentDTO(ProjectComponent projectComponent);
    ProjectComponent projectComponentDTOToProjectComponent(ProjectComponentDTO projectComponentDTO);
    List<ProjectComponentDTO> projectComponentsToProjectComponentDTOs(List<ProjectComponent> projectComponents);
    List<ProjectComponent> projectComponentDTOsToProjectComponents(List<ProjectComponentDTO> projectComponentDTOs);
}
