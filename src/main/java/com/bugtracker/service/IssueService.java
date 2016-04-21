package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;

import java.util.Set;

public interface IssueService {

    IssueDTO addIssue(IssueDTO issueDTO, long[] components, long[] versions, String projectName);
    void delete(long id);
    IssueDTO getByName(String name);
    IssueDTO getById(long id);
    ProjectDTO getProjectByIssueId(long id);
    Set<ProjectComponentDTO> getProjectComponentsByIssueId(long id);
    Set<ProjectVersionDTO> getProjectVersionsByIssueId(long id);
    IssueDTO editIssue(IssueDTO issue);
    Set<IssueDTO> getIssues(String projectName);

}
