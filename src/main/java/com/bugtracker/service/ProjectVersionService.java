package com.bugtracker.service;

import com.bugtracker.entity.ProjectVersion;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectVersionService {

    ProjectVersion addProjectComponent(ProjectVersion projectComponent);
    void delete(long id);
    ProjectVersion getByName(String name);
    ProjectVersion editProjectComponent(ProjectVersion projectComponent);
    List<ProjectVersion> getAll();

}
