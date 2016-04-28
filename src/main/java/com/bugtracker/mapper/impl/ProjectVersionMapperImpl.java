package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectVersionMapper;
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
public class ProjectVersionMapperImpl extends CustomMapper<ProjectVersionDTO, ProjectVersion> implements ProjectVersionMapper {

    @Autowired
    private MapperFacade mapper;

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

    @Override
    public void mapAtoB(ProjectVersionDTO a, ProjectVersion b, MappingContext context) {
        b.setId(a.getId());
        b.setName(a.getName());
        b.setDescription(a.getDescription());
    }

    @Override
    public void mapBtoA(ProjectVersion b, ProjectVersionDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setName(b.getName());
        a.setDescription(b.getDescription());
    }
}
