package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectVersionMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProjectVersionMapperImpl implements ProjectVersionMapper {

    private final static MapperFacade mapper;

    static
    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(ProjectVersion.class, ProjectVersionDTO.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }


    @Override
    public ProjectVersionDTO projectVersionToProjectVersionDTO(ProjectVersion projectVersion) {
        return mapper.map(projectVersion, ProjectVersionDTO.class);
    }

    @Override
    public ProjectVersion projectVersionDTOToProjectVersion(ProjectVersionDTO projectVersionDTO) {
        return mapper.map(projectVersionDTO, ProjectVersion.class);
    }

    @Override
    public Set<ProjectVersionDTO> projectVersionsToProjectVersionDTOs(Set<ProjectVersion> projectVersions) {
        if (projectVersions == null) {
            return null;
        }

        Set<ProjectVersionDTO> projectVersionDTOs = new HashSet<ProjectVersionDTO>();

        for (ProjectVersion projectVersion : projectVersions) {
            projectVersionDTOs.add(projectVersionToProjectVersionDTO(projectVersion));
        }

        return projectVersionDTOs;
    }

    @Override
    public Set<ProjectVersion> projectVersionDTOsToProjectVersions(Set<ProjectVersionDTO> projectVersionDTOs) {
        if (projectVersionDTOs == null) {
            return null;
        }

        Set<ProjectVersion> projectVersions = new HashSet<ProjectVersion>();

        for (ProjectVersionDTO projectVersionDTO : projectVersionDTOs) {
            projectVersions.add(projectVersionDTOToProjectVersion(projectVersionDTO));
        }

        return projectVersions;
    }
}
