package com.bugtracker.mapper.impl;

import com.bugtracker.dto.*;
import com.bugtracker.entity.*;
import com.bugtracker.mapper.*;
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
public class IssueMapperImpl extends CustomMapper<IssueDTO, Issue> implements IssueMapper{

    @Autowired
    private MapperFacade mapper;

    @Override
    public IssueDTO issueToIssueDTO(Issue issue) {
        return mapper.map(issue, IssueDTO.class);
    }

    @Override
    public Issue issueDTOToIssue(IssueDTO issueDTO) {
        return mapper.map(issueDTO, Issue.class);
    }

    @Override
    public Set<IssueDTO> issuesToIssueDTOs(Set<Issue> issues) {
        if (issues == null) {
            return null;
        }

        Set<IssueDTO> issueDTOs = new HashSet<IssueDTO>();

        for (Issue issue : issues) {
            issueDTOs.add(issueToIssueDTO(issue));
        }

        return issueDTOs;
    }

    @Override
    public Set<Issue> issueDTOsToIssues(Set<IssueDTO> issueDTOs) {
        if (issueDTOs == null) {
            return null;
        }

        Set<Issue> issues = new HashSet<Issue>();

        for (IssueDTO issueDTO : issueDTOs) {
            issues.add(issueDTOToIssue(issueDTO));
        }

        return issues;
    }

    @Override
    public void mapAtoB(IssueDTO a, Issue b, MappingContext context) {
        b.setId(a.getId());
        b.setName(a.getName());
        b.setIssueType(a.getIssueType());
        b.setSummary(a.getSummary());
        b.setPriority(a.getPriority());
        b.setStatus(a.getStatus());
        b.setEnvironment(a.getEnvironment());
        b.setDescription(a.getDescription());
        b.setCreatedDate(a.getCreatedDate());
        b.setUpdatedDate(a.getUpdatedDate());
        b.setResolvedDate(a.getResolvedDate());
    }

    @Override
    public void mapBtoA(Issue b, IssueDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setName(b.getName());
        a.setIssueType(b.getIssueType());
        a.setSummary(b.getSummary());
        a.setPriority(b.getPriority());
        a.setStatus(b.getStatus());
        a.setEnvironment(b.getEnvironment());
        a.setDescription(b.getDescription());
        a.setCreatedDate(b.getCreatedDate());
        a.setUpdatedDate(b.getUpdatedDate());
        a.setResolvedDate(b.getResolvedDate());
    }
}
