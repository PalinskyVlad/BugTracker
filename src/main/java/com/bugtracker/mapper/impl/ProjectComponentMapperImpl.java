package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.ProjectComponentMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectComponentMapperImpl extends CustomMapper<ProjectComponentDTO, ProjectComponent> implements ProjectComponentMapper {

    @Autowired
    private MapperFacade mapper;

    @Override
    public ProjectComponentDTO projectComponentToProjectComponentDTO(ProjectComponent projectComponent) {
        return mapper.map(projectComponent, ProjectComponentDTO.class);
    }

    @Override
    public ProjectComponent projectComponentDTOToProjectComponent(ProjectComponentDTO projectComponentDTO) {
        return mapper.map(projectComponentDTO, ProjectComponent.class);
    }

    @Override
    public Set<ProjectComponentDTO> projectComponentsToProjectComponentDTOs(Set<ProjectComponent> projectComponents) {
        if (projectComponents == null) {
            return null;
        }

        Set<ProjectComponentDTO> projectComponentDTOs = new HashSet<ProjectComponentDTO>();

        for (ProjectComponent projectComponent : projectComponents) {
            projectComponentDTOs.add(projectComponentToProjectComponentDTO(projectComponent));
        }

        return projectComponentDTOs;
    }

    @Override
    public Set<ProjectComponent> projectComponentDTOsToProjectComponents(Set<ProjectComponentDTO> projectComponentDTOs) {
        if (projectComponentDTOs == null) {
            return null;
        }

        Set<ProjectComponent> projectComponents = new HashSet<ProjectComponent>();

        for (ProjectComponentDTO projectComponentDTO : projectComponentDTOs) {
            projectComponents.add(projectComponentDTOToProjectComponent(projectComponentDTO));
        }

        return projectComponents;
    }

    @Override
    public void mapAtoB(ProjectComponentDTO a, ProjectComponent b, MappingContext context) {
        b.setId(a.getId());
        b.setName(a.getName());
        b.setDescription(a.getDescription());
    }

    @Override
    public void mapBtoA(ProjectComponent b, ProjectComponentDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setName(b.getName());
        a.setDescription(b.getDescription());
    }
}
