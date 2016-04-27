package com.bugtracker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<ProjectComponent> components = new HashSet<ProjectComponent>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<ProjectVersion> versions = new HashSet<ProjectVersion>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    private Set<Issue> issues = new HashSet<Issue>();

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
