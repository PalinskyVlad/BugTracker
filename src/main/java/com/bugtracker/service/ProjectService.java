package com.bugtracker.service;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface ProjectService {

    ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO);
    void delete(long id);
    ProjectDTO getByName(String name);
    ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO);
    List<String> getAllNames();
    Map<Long, String> getAllComponentsNameAndId(String projectName);
    Map<Long, String> getAllVersionsNameAndId(String projectName);

}
