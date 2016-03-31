package com.bugtracker.test.util;

import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectVersion;

/**
 * Created by Vlados on 16.03.2016.
 */
public class ProjectVersionUtil {

    public static ProjectVersion createProjectVersion() {
        ProjectVersion projectVersion = new ProjectVersion();
        projectVersion.setName("versionone");
        projectVersion.setRelease(true);
        projectVersion.setProject(new Project());
        return projectVersion;
    }
}
