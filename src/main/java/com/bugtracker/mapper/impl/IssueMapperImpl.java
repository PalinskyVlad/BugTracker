package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.mapper.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class IssueMapperImpl implements IssueMapper {

    private final static MapperFacade mapper;

    static
    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Issue.class, IssueDTO.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }

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
}
