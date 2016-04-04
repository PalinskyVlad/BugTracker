package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.mapper.IssueMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.IssueRepository;
import com.bugtracker.service.IssueService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private IssueMapper mapper;


    @Override
    public IssueDTO addIssue(IssueDTO issueDTO) {
        IssueDTO savedIssue = mapper.issueToIssueDTO(issueRepository.saveAndFlush(mapper.issueDTOToIssue(issueDTO)));

        return savedIssue;
    }

    @Override
    public void delete(long id) {
        issueRepository.delete(id);
    }

    @Override
    public IssueDTO getByName(String name) {
        return mapper.issueToIssueDTO(issueRepository.getByName(name));
    }

    @Override
    public IssueDTO editIssue(IssueDTO issueDTO) {
        return mapper.issueToIssueDTO(issueRepository.saveAndFlush(mapper.issueDTOToIssue(issueDTO)));
    }

    @Override
    public List<IssueDTO> getAll() {
        return mapper.issuesToIssueDTOs(issueRepository.findAll());
    }
}
