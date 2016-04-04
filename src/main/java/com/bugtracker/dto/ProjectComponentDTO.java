package com.bugtracker.dto;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;

import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 */
public class ProjectComponentDTO {
    private long id;
    private String name;
    private Project project;
    private Set<Issue> issues;

    public ProjectComponentDTO(long id, String name, Project project, Set<Issue> issues) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.issues = issues;
    }

    public ProjectComponentDTO() {
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

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
