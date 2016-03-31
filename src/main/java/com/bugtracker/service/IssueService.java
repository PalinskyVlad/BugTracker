package com.bugtracker.service;

import com.bugtracker.entity.Issue;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface IssueService {

    Issue addIssue(Issue issue);
    void delete(long id);
    Issue getByName(String name);
    Issue editIssue(Issue issue);
    List<Issue> getAll();

}
