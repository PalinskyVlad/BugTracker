package com.bugtracker.dto;

import com.bugtracker.entity.Issue;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;

import java.util.Set;

/**
 * Created by Vlados on 4/4/2016.
 */
public class ProjectDTO {
    private long id;
    private String name;
    private String description;
    private boolean privacy;
    private byte[] avatar;
    private Set<ProjectComponent> components;
    private Set<ProjectVersion> versions;
    private Set<Issue> issues;

    public ProjectDTO(long id, String name, String description, boolean privacy, byte[] avatar
                        ,Set<ProjectComponent> components, Set<ProjectVersion> versions, Set<Issue> issues) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.avatar = avatar;
        this.components = components;
        this.versions = versions;
        this.issues = issues;
    }

    public ProjectDTO() {
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

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
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

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
