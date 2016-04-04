package com.bugtracker.dto;

import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.entity.User;
import com.bugtracker.entity.enums.IssuePriorityEnum;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.entity.enums.IssueTypeEnum;

import java.util.Date;
import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 * http://g00glen00b.be/mapstruct/
 */
public class IssueDTO {
    private long id;
    private String name;
    private Project project;
    private IssueTypeEnum issueType;
    private String summary;
    private IssuePriorityEnum priority;
    private Set<ProjectComponent> components;
    private Set<ProjectVersion> affectsVersions;
    private IssueStatusEnum status;
    private String environment;
    private String description;
    private Set<User> users;
    private Date createdDate;
    private Date updatedDate;
    private Date resolvedDate;

    public IssueDTO(long id, String name, Project project, IssueTypeEnum issueType, String summary
                    , IssuePriorityEnum priority, Set<ProjectComponent> components, Set<ProjectVersion> affectsVersions
                    , IssueStatusEnum status, String environment, String description, Set<User> users, Date createdDate
                    , Date updatedDate, Date resolvedDate) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.issueType = issueType;
        this.summary = summary;
        this.priority = priority;
        this.components = components;
        this.affectsVersions = affectsVersions;
        this.status = status;
        this.environment = environment;
        this.description = description;
        this.users = users;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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

    public Set<ProjectComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<ProjectComponent> components) {
        this.components = components;
    }

    public Set<ProjectVersion> getAffectsVersions() {
        return affectsVersions;
    }

    public void setAffectsVersions(Set<ProjectVersion> affectsVersions) {
        this.affectsVersions = affectsVersions;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
