package com.bugtracker.test.util;

import com.bugtracker.dto.ProjectComponentDTO;

public class ProjectComponentDTOUtil {

    public static ProjectComponentDTO createProjectComponentDTO() {

        ProjectComponentDTO projectComponentDTO = new ProjectComponentDTO();
        projectComponentDTO.setName("core");
        projectComponentDTO.setDescription("It's core of project");

        return projectComponentDTO;
    }
}
