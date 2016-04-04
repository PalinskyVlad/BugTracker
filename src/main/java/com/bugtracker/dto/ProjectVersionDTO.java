package com.bugtracker.dto;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;

import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 */
public class ProjectVersionDTO {
    private long id;
    private String name;
    private Project project;
    private boolean release;
    private Set<Issue> issues;

    public ProjectVersionDTO(long id, String name, Project project, Boolean release, Set<Issue> issues) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.release = release;
        this.issues = issues;
    }

    public ProjectVersionDTO() {
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

    public Boolean isRelease() {
        return release;
    }

    public void setRelease(Boolean release) {
        this.release = release;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
