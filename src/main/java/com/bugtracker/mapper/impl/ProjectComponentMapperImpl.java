package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.ProjectComponentMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectComponentMapperImpl implements ProjectComponentMapper {

    private final static MapperFacade mapper;

    static
    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(ProjectComponent.class, ProjectComponentDTO.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }

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
}
