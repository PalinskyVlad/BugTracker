package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;

import java.util.Set;

public interface ProjectComponentService {
    ProjectComponentDTO addProjectComponent(ProjectDTO projectDTO, ProjectComponentDTO projectComponentDTO);
    void delete(long id);
    ProjectComponentDTO getById(long id);
    ProjectComponentDTO getByName(String name);
    Set<ProjectComponentDTO> getProjectComponents(String projectName);
    Set<IssueDTO> getIssues(long id);
    ProjectDTO getProjectByProjectComponentId(long id);
    ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO);
}
