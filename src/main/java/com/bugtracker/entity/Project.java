package com.bugtracker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "project")
public class Project {

    private long id;

    private String name;

    private String description;

    private boolean privacy;

    private byte[] avatar;

    private Set<ProjectComponent> components = new HashSet<ProjectComponent>();

    private Set<ProjectVersion> versions = new HashSet<ProjectVersion>();

    private Set<Issue> issues = new HashSet<Issue>();

    public Project() {

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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "privacy")
    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    @Lob
    @Column(name = "avatar", nullable = false, columnDefinition = "mediumblob")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    public Set<ProjectComponent> getComponents() {
        return components;
    }

    public void setComponents(Set<ProjectComponent> components) {
        this.components = components;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = {CascadeType.REMOVE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    public Set<ProjectVersion> getVersions() {
        return versions;
    }

    public void setVersions(Set<ProjectVersion> versions) {
        this.versions = versions;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
