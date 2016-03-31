package com.bugtracker.test.util;

import com.bugtracker.entity.Project;

/**
 * Created by Vlados on 16.03.2016.
 */
public class ProjectUtil {

    public static Project createProject() {
        Project project = new Project();
        project.setName("BugTracker");

        return project;
    }
}
