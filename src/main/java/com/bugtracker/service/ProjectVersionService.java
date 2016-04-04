package com.bugtracker.service;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectVersionService {

    ProjectVersionDTO addProjectVersion(ProjectVersionDTO projectVersionDTO);
    void delete(long id);
    ProjectVersionDTO getByName(String name);
    ProjectVersionDTO editProjectVersion(ProjectVersionDTO projectVersionDTO);
    List<ProjectVersionDTO> getAll();

}
