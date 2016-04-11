package com.bugtracker.test.util;

import com.bugtracker.dto.ProjectDTO;

/**
 * Created by Vlados on 16.03.2016.
 */
public class ProjectDTOUtil {

    public static ProjectDTO createProjectDTO() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName("Spring Security Beta");
        return projectDTO;
    }
}
