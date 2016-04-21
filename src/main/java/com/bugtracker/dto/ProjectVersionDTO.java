package com.bugtracker.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectVersionDTO {
    private long id;
    private String name;
    private String description;
    private ProjectDTO projectDTO;
    private boolean release;
    private Set<IssueDTO> issueDTOs = new HashSet<IssueDTO>();

    public ProjectVersionDTO(long id, String name, ProjectDTO projectDTO, Boolean release, Set<IssueDTO> issueDTOs) {
        this.id = id;
        this.name = name;
        this.projectDTO = projectDTO;
        this.release = release;
        this.issueDTOs = issueDTOs;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRelease(boolean release) {
        this.release = release;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public Boolean isRelease() {
        return release;
    }

    public void setRelease(Boolean release) {
        this.release = release;
    }

    public Set<IssueDTO> getIssueDTOs() {
        return issueDTOs;
    }

    public void setIssueDTOs(Set<IssueDTO> issueDTOs) {
        this.issueDTOs = issueDTOs;
    }
}
