package com.bugtracker.test.util;

import com.bugtracker.dto.ProjectVersionDTO;

public class ProjectVersionDTOUtil {

    public static ProjectVersionDTO createProjectVersionDTO() {
        ProjectVersionDTO projectVersionDTO = new ProjectVersionDTO();
        projectVersionDTO.setName("1.0.0");
        projectVersionDTO.setDescription("It's version of my project");
        return projectVersionDTO;
    }
}
