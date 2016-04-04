package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface IssueService {

    IssueDTO addIssue(IssueDTO issueDTO);
    void delete(long id);
    IssueDTO getByName(String name);
    IssueDTO editIssue(IssueDTO issue);
    List<IssueDTO> getAll();

}
