package com.bugtracker.entity;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "project_version")
public class ProjectVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 64, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch =  FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "release")
    private boolean release;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "affectsVersions")
    private Set<Issue> issues;

    public ProjectVersion() {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isRelease() {
        return release;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
