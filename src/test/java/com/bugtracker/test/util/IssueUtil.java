package com.bugtracker.test.util;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.enums.IssueTypeEnum;

/**
 * Created by Vlados on 16.03.2016.
 */
public class IssueUtil {

    public static Issue createIssue() {
        Issue issue = new Issue();

        issue.setName("BugTrackerIssue");
        issue.setIssueType(IssueTypeEnum.BUG);
        issue.setProject(new Project());

        return issue;
    }
}
