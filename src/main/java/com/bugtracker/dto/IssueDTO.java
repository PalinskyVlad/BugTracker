package com.bugtracker.dto;

import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.entity.User;
import com.bugtracker.entity.enums.IssuePriorityEnum;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.entity.enums.IssueTypeEnum;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IssueDTO {
    private long id;
    private String name;
    private IssueTypeEnum issueType;
    private String summary;
    private IssuePriorityEnum priority;
    private IssueStatusEnum status;
    private String environment;
    private String description;
    private Date createdDate;
    private Date updatedDate;
    private Date resolvedDate;

    public IssueDTO(long id, String name, IssueTypeEnum issueType, String summary
                    , IssuePriorityEnum priority, IssueStatusEnum status, String environment, String description
                    , Date createdDate, Date updatedDate, Date resolvedDate) {
        this.id = id;
        this.name = name;
        this.issueType = issueType;
        this.summary = summary;
        this.priority = priority;
        this.status = status;
        this.environment = environment;
        this.description = description;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.resolvedDate = resolvedDate;
    }

    public IssueDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IssueTypeEnum getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueTypeEnum issueType) {
        this.issueType = issueType;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public IssuePriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(IssuePriorityEnum priority) {
        this.priority = priority;
    }

    public IssueStatusEnum getStatus() {
        return status;
    }

    public void setStatus(IssueStatusEnum status) {
        this.status = status;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }
}
