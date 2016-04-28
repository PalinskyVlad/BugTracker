package com.bugtracker.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectDTO {
    private long id;
    private String name;
    private String description;
    private boolean privacy;

    public ProjectDTO(long id, String name, String description, boolean privacy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.privacy = privacy;
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
}
