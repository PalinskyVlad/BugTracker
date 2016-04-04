package com.bugtracker.mapper;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.Issue;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Mapper
public interface IssueMapper {
    IssueDTO issueToIssueDTO(Issue issue);
    Issue issueDTOToIssue(IssueDTO issueDTO);
    List<IssueDTO> issuesToIssueDTOs(List<Issue> issues);
    List<Issue> issueDTOsToIssues(List<IssueDTO> issueDTOs);
}
