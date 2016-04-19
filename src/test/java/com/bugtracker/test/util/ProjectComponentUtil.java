package com.bugtracker.test.util;

import com.bugtracker.entity.ProjectComponent;

/**
 * Created by Vlados on 16.03.2016.
 */
public class ProjectComponentUtil {

    public static ProjectComponent createProjectComponent() {
        ProjectComponent projectComponent = new ProjectComponent();
        projectComponent.setName("core");
        projectComponent.setDescription("dfsdfsdf");


        return projectComponent;
    }
}
