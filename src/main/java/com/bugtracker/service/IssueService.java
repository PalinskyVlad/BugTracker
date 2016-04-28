package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;

import java.util.List;
import java.util.Set;

public interface IssueService {

    IssueDTO addIssue(IssueDTO issueDTO, long[] componentIndexes, long[] versionIndexes, String projectName);
    IssueDTO getByName(String name);
    IssueDTO getById(long id);
    IssueDTO editIssue(IssueDTO issue);
    void delete(long id);

    ProjectDTO getProject(long id);
    Set<ProjectComponentDTO> getProjectComponents(long id);
    Set<ProjectVersionDTO> getProjectVersions(long id);

    boolean checkName(String name);
}
