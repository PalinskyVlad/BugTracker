package com.bugtracker.entity;

import com.bugtracker.entity.Issue;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "privacy")
    private boolean privacy;

    @Lob
    @Column(name = "avatar", nullable = false, columnDefinition = "mediumblob")
    private byte[] avatar;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<ProjectComponent> components;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<ProjectVersion> versions;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Issue> issues;

    public Project() {

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
