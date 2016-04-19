package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;

import java.util.List;
import java.util.Set;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectVersionService {

    ProjectVersionDTO addProjectVersion(ProjectDTO projectDTO, ProjectVersionDTO projectVersionDTO);
    void delete(long id);
    ProjectVersionDTO getByName(String name);
    ProjectVersionDTO getById(long id);
    Set<ProjectVersionDTO> getProjectVersions(String projectName);
    Set<IssueDTO> getIssues(long id);
    ProjectDTO getProjectByProjectVersionId(long id);
    ProjectVersionDTO editProjectVersion(ProjectVersionDTO projectVersionDTO);

}
