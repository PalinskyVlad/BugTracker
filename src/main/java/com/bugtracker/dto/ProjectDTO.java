package com.bugtracker.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectDTO {
    private long id;
    private String name;
    private String description;
    private boolean privacy;
    private byte[] avatar;
    private Set<ProjectComponentDTO> componentDTOs = new HashSet<ProjectComponentDTO>();
    private Set<ProjectVersionDTO> versionDTOs = new HashSet<ProjectVersionDTO>();
    private Set<IssueDTO> issueDTOs = new HashSet<IssueDTO>();

    public ProjectDTO(long id, String name, String description, boolean privacy, byte[] avatar
                        ,Set<ProjectComponentDTO> componentDTOs, Set<ProjectVersionDTO> versionDTOs, Set<IssueDTO> issueDTOs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.privacy = privacy;
        this.avatar = avatar;
        this.componentDTOs = componentDTOs;
        this.versionDTOs = versionDTOs;
        this.issueDTOs = issueDTOs;
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

    public Set<ProjectComponentDTO> getComponentDTOs() {
        return componentDTOs;
    }

    public void setComponentDTOs(Set<ProjectComponentDTO> componentDTOs) {
        this.componentDTOs = componentDTOs;
    }

    public Set<ProjectVersionDTO> getVersionDTOs() {
        return versionDTOs;
    }

    public void setVersionDTOs(Set<ProjectVersionDTO> versionDTOs) {
        this.versionDTOs = versionDTOs;
    }

    public Set<IssueDTO> getIssueDTOs() {
        return issueDTOs;
    }

    public void setIssueDTOs(Set<IssueDTO> issueDTOs) {
        this.issueDTOs = issueDTOs;
    }
}
