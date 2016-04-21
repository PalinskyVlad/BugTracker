package com.bugtracker.test.util;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.entity.enums.IssuePriorityEnum;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.entity.enums.IssueTypeEnum;

import java.util.Date;

public class IssueDTOUtil {

    public static IssueDTO createIssueDTO() {
        IssueDTO issueDTO = new IssueDTO();

        issueDTO.setName("IssueTrackerIssue");
        issueDTO.setIssueType(IssueTypeEnum.TASK);
        issueDTO.setStatus(IssueStatusEnum.OPEN);
        issueDTO.setPriority(IssuePriorityEnum.MAJOR);
        issueDTO.setSummary("It's summary");
        issueDTO.setDescription("Need writing all validators");
        issueDTO.setCreatedDate(new Date());

        return issueDTO;
    }
}
