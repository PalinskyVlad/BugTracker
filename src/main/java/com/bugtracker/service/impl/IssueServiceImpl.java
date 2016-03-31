package com.bugtracker.service.impl;

import com.bugtracker.entity.Issue;
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


    @Override
    public Issue addIssue(Issue issue) {
        Issue savedIssue = issueRepository.saveAndFlush(issue);

        return savedIssue;
    }

    @Override
    public void delete(long id) {
        issueRepository.delete(id);
    }

    @Override
    public Issue getByName(String name) {
        return issueRepository.getByName(name);
    }

    @Override
    public Issue editIssue(Issue issue) {
        return issueRepository.saveAndFlush(issue);
    }

    @Override
    public List<Issue> getAll() {
        return issueRepository.findAll();
    }
}
