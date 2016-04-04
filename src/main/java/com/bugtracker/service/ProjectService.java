package com.bugtracker.service;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectService {

    ProjectDTO addProject(ProjectDTO projectDTO);
    void delete(long id);
    ProjectDTO getByName(String name);
    ProjectDTO editProject(ProjectDTO projectDTO);
    List<ProjectDTO> getAll();

}
