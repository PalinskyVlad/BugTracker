package com.bugtracker.entity;

import com.bugtracker.entity.enums.IssuePriorityEnum;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.entity.enums.IssueTypeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "issue")
public class Issue {

    private long id;

    private String name;

    private Project project;

    private IssueTypeEnum issueType;

    private String summary;

    private IssuePriorityEnum priority;

    private Set<ProjectComponent> components = new HashSet<ProjectComponent>();


    private Set<ProjectVersion> versions = new HashSet<ProjectVersion>();

    private IssueStatusEnum status;

    private String environment;

    private String description;

    private Set<User> users;

    private Date createdDate;

    private Date updatedDate;

    private Date resolvedDate;

    public Issue() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", length = 64, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id", nullable = false)
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Column(name = "issue_type", nullable = false)
    @Enumerated(EnumType.STRING)
    public IssueTypeEnum getIssueType() {
        return issueType;
    }

    public void setIssueType(IssueTypeEnum issueType) {
        this.issueType = issueType;
    }

    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    public IssuePriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(IssuePriorityEnum priority) {
        this.priority = priority;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "issue_project_component",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "project_component_id", referencedColumnName = "id")
    )
    public Set<ProjectComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<ProjectComponent> components) {
        this.components = components;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "issue_project_version",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "project_version_id", referencedColumnName = "id")
    )
    public Set<ProjectVersion> getVersions() {
        return versions;
    }

    public void setVersions(Set<ProjectVersion> versions) {
        this.versions = versions;
    }

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    public IssueStatusEnum getStatus() {
        return status;
    }

    public void setStatus(IssueStatusEnum status) {
        this.status = status;
    }

    @Column(name = "environment")
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    @JoinTable(name = "issue_user",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Column(name = "resolved_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Date resolvedDate) {
        this.resolvedDate = resolvedDate;
    }
}
