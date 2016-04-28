package com.bugtracker.dto;

import java.util.HashSet;
import java.util.Set;

public class ProjectVersionDTO {
    private long id;
    private String name;
    private String description;

    public ProjectVersionDTO(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}
