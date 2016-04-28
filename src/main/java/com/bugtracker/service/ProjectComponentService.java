package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;

import java.util.Set;

public interface ProjectComponentService {
    ProjectComponentDTO addProjectComponent(String projectName, ProjectComponentDTO projectComponentDTO);
    ProjectComponentDTO getById(long id);
    ProjectComponentDTO getByName(String name);
    ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO);
    void delete(long id);

    Set<IssueDTO> getIssues(long id);
    ProjectDTO getProject(long id);
}
