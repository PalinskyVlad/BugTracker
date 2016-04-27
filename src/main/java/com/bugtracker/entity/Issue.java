package com.bugtracker.entity;

import com.bugtracker.entity.enums.IssuePriorityEnum;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.entity.enums.IssueTypeEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "issue_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueTypeEnum issueType;

    @Column(name = "summary")
    private String summary;

    @Column(name = "priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private IssuePriorityEnum priority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "issue_project_component",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "project_component_id", referencedColumnName = "id")
    )
    private Set<ProjectComponent> components = new HashSet<ProjectComponent>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "issue_project_version",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "project_version_id", referencedColumnName = "id")
    )
    private Set<ProjectVersion> versions = new HashSet<ProjectVersion>();

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private IssueStatusEnum status;

    @Column(name = "environment")
    private String environment;

    @Column(name = "description")
    private String description;

    @ManyToMany
    @JoinTable(name = "issue_user",
            joinColumns = @JoinColumn(name = "issue_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
    )
    private Set<User> users;

    @Column(name = "created_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "resolved_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resolvedDate;

    public Issue() {

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

    public Set<ProjectVersion> getVersions() {
        return versions;
    }

    public void setVersions(Set<ProjectVersion> versions) {
        this.versions = versions;
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
