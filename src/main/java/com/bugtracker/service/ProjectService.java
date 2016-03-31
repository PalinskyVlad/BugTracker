package com.bugtracker.service;

import com.bugtracker.entity.Project;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectService {

    Project addProject(Project project);
    void delete(long id);
    Project getByName(String name);
    Project editProject(Project project);
    List<Project> getAll();

}
