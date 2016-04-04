package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.mapper.IssueMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class IssueMapperImpl implements IssueMapper {

    @Override
    public IssueDTO issueToIssueDTO(Issue issue) {
        if (issue == null) {
            return null;
        }

        IssueDTO issueDTO = new IssueDTO();

        issueDTO.setId(issue.getId());
        issueDTO.setName(issue.getName());
        issueDTO.setProject(issue.getProject());
        issueDTO.setIssueType(issue.getIssueType());
        issueDTO.setSummary(issue.getSummary());
        issueDTO.setPriority(issue.getPriority());
        issueDTO.setComponents(issue.getComponents());
        issueDTO.setAffectsVersions(issue.getAffectsVersions());
        issueDTO.setStatus(issue.getStatus());
        issueDTO.setEnvironment(issue.getEnvironment());
        issueDTO.setDescription(issue.getDescription());
        issueDTO.setUsers(issue.getUsers());
        issueDTO.setCreatedDate(issue.getCreatedDate());
        issueDTO.setUpdatedDate(issue.getUpdatedDate());
        issueDTO.setResolvedDate(issue.getResolvedDate());

        return issueDTO;
    }

    @Override
    public Issue issueDTOToIssue(IssueDTO issueDTO) {
        if (issueDTO == null) {
            return null;
        }

        Issue issue = new Issue();

        issue.setId(issueDTO.getId());
        issue.setName(issueDTO.getName());
        issue.setProject(issueDTO.getProject());
        issue.setIssueType(issueDTO.getIssueType());
        issue.setSummary(issueDTO.getSummary());
        issue.setPriority(issueDTO.getPriority());
        issue.setComponents(issueDTO.getComponents());
        issue.setAffectsVersions(issueDTO.getAffectsVersions());
        issue.setStatus(issueDTO.getStatus());
        issue.setEnvironment(issueDTO.getEnvironment());
        issue.setDescription(issueDTO.getDescription());
        issue.setUsers(issueDTO.getUsers());
        issue.setCreatedDate(issueDTO.getCreatedDate());
        issue.setUpdatedDate(issueDTO.getUpdatedDate());
        issue.setResolvedDate(issueDTO.getResolvedDate());

        return issue;
    }

    @Override
    public List<IssueDTO> issuesToIssueDTOs(List<Issue> issues) {
        if (issues == null) {
            return null;
        }

        List<IssueDTO> issueDTOs = new ArrayList<IssueDTO>();

        for (Issue issue : issues) {
            issueDTOs.add(issueToIssueDTO(issue));
        }

        return issueDTOs;
    }

    @Override
    public List<Issue> issueDTOsToIssues(List<IssueDTO> issueDTOs) {
        if (issueDTOs == null) {
            return null;
        }

        List<Issue> issues = new ArrayList<Issue>();

        for (IssueDTO issueDTO : issueDTOs) {
            issues.add(issueDTOToIssue(issueDTO));
        }

        return issues;
    }
}
