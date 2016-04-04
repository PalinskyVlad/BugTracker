package com.bugtracker.service;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectComponentService {
    ProjectComponentDTO addProjectComponent(ProjectComponentDTO projectComponentDTO);
    void delete(long id);
    ProjectComponentDTO getByName(String name);
    ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO);
    List<ProjectComponentDTO> getAll();
}
