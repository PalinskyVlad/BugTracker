package com.bugtracker.mapper.impl;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectVersionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class ProjectVersionMapperImpl implements ProjectVersionMapper {

    @Override
    public ProjectVersionDTO projectVersionToProjectVersionDTO(ProjectVersion projectVersion) {

        if (projectVersion == null) {
            return null;
        }

        ProjectVersionDTO projectVersionDTO = new ProjectVersionDTO();

        projectVersionDTO.setId(projectVersion.getId());
        projectVersionDTO.setName(projectVersion.getName());
        projectVersionDTO.setProject(projectVersion.getProject());
        projectVersionDTO.setRelease(projectVersion.isRelease());
        projectVersionDTO.setIssues(projectVersion.getIssues());

        return projectVersionDTO;
    }

    @Override
    public ProjectVersion projectVersionDTOToProjectVersion(ProjectVersionDTO projectVersionDTO) {
        if (projectVersionDTO == null) {
            return null;
        }

        ProjectVersion projectVersion = new ProjectVersion();

        projectVersion.setId(projectVersionDTO.getId());
        projectVersion.setName(projectVersionDTO.getName());
        projectVersion.setProject(projectVersionDTO.getProject());
        projectVersion.setRelease(projectVersionDTO.isRelease());
        projectVersion.setIssues(projectVersionDTO.getIssues());

        return projectVersion;
    }

    @Override
    public List<ProjectVersionDTO> projectVersionsToProjectVersionDTOs(List<ProjectVersion> projectVersions) {
        if (projectVersions == null) {
            return null;
        }

        List<ProjectVersionDTO> projectVersionDTOs = new ArrayList<ProjectVersionDTO>();

        for (ProjectVersion issue : projectVersions) {
            projectVersionDTOs.add(projectVersionToProjectVersionDTO(issue));
        }

        return projectVersionDTOs;
    }

    @Override
    public List<ProjectVersion> projectVersionDTOsToProjectVersions(List<ProjectVersionDTO> projectVersionDTOs) {
        if (projectVersionDTOs == null) {
            return null;
        }

        List<ProjectVersion> projectVersions = new ArrayList<ProjectVersion>();

        for (ProjectVersionDTO projectVersionDTO : projectVersionDTOs) {
            projectVersions.add(projectVersionDTOToProjectVersion(projectVersionDTO));
        }

        return projectVersions;
    }
}
