package com.bugtracker.service;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectService {

    ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO);
    void delete(long id);
    ProjectDTO getByName(String name);
    ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO);
    List<ProjectDTO> getAll();
    List<String> getAllNames();

}
