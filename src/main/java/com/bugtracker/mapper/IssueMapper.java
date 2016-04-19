package com.bugtracker.mapper;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.Issue;

import java.util.Set;

public interface IssueMapper {
    IssueDTO issueToIssueDTO(Issue issue);
    Issue issueDTOToIssue(IssueDTO issueDTO);
    Set<IssueDTO> issuesToIssueDTOs(Set<Issue> issues);
    Set<Issue> issueDTOsToIssues(Set<IssueDTO> issueDTOs);
}
