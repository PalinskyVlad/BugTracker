package com.bugtracker.service;

import com.bugtracker.dto.ProjectDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO);
    void delete(long id);
    void delete(String projectName);
    ProjectDTO getByName(String name);
    ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO);
    List<String> getAllNames();
    Map<Long, String> getAllComponentsNameAndId(String projectName);
    Map<Long, String> getAllVersionsNameAndId(String projectName);

}
