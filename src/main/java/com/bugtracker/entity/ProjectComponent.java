package com.bugtracker.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vlados on 14.03.2016.
 */
@Entity
@Table(name = "project_component")
public class ProjectComponent {

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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "components")
    private Set<Issue> issues;

    public ProjectComponent() {

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

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }
}
