package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.ProjectComponentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class ProjectComponentMapperImpl implements ProjectComponentMapper {

    @Override
    public ProjectComponentDTO projectComponentToProjectComponentDTO(ProjectComponent projectComponent) {

        if (projectComponent == null) {
            return null;
        }

        ProjectComponentDTO projectComponentDTO = new ProjectComponentDTO();

        projectComponentDTO.setId(projectComponent.getId());
        projectComponentDTO.setName(projectComponent.getName());
        projectComponentDTO.setProject(projectComponent.getProject());
        projectComponentDTO.setIssues(projectComponent.getIssues());

        return projectComponentDTO;
    }

    @Override
    public ProjectComponent projectComponentDTOToProjectComponent(ProjectComponentDTO projectComponentDTO) {
        if (projectComponentDTO == null) {
            return null;
        }

        ProjectComponent projectComponent = new ProjectComponent();

        projectComponent.setId(projectComponentDTO.getId());
        projectComponent.setName(projectComponentDTO.getName());
        projectComponent.setProject(projectComponentDTO.getProject());
        projectComponent.setIssues(projectComponentDTO.getIssues());

        return projectComponent;
    }

    @Override
    public List<ProjectComponentDTO> projectComponentsToProjectComponentDTOs(List<ProjectComponent> projectComponents) {
        if (projectComponents == null) {
            return null;
        }

        List<ProjectComponentDTO> projectComponentDTOs = new ArrayList<ProjectComponentDTO>();

        for (ProjectComponent issue : projectComponents) {
            projectComponentDTOs.add(projectComponentToProjectComponentDTO(issue));
        }

        return projectComponentDTOs;
    }

    @Override
    public List<ProjectComponent> projectComponentDTOsToProjectComponents(List<ProjectComponentDTO> projectComponentDTOs) {
        if (projectComponentDTOs == null) {
            return null;
        }

        List<ProjectComponent> projectComponents = new ArrayList<ProjectComponent>();

        for (ProjectComponentDTO projectComponentDTO : projectComponentDTOs) {
            projectComponents.add(projectComponentDTOToProjectComponent(projectComponentDTO));
        }

        return projectComponents;
    }
}
