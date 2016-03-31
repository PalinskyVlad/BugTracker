package com.bugtracker.service;

import com.bugtracker.entity.ProjectComponent;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectComponentService {
    ProjectComponent addProjectComponent(ProjectComponent projectComponent);
    void delete(long id);
    ProjectComponent getByName(String name);
    ProjectComponent editProjectComponent(ProjectComponent projectComponent);
    List<ProjectComponent> getAll();
}
