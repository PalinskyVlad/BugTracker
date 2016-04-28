package com.bugtracker.service;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProjectService {
    ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO);
    ProjectDTO getByName(String name);
    ProjectDTO getById(long id);
    ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO);
    void delete(long id);

    List<String> getAllNames();
    Map<Long, String> getAllComponentsNameAndId(String projectName);
    Map<Long, String> getAllVersionsNameAndId(String projectName);

    byte[] getAvatar(String projectName);
    Set<IssueDTO> getIssues(String projectName);
    Set<ProjectVersionDTO> getProjectVersions(String projectName);
    Set<ProjectComponentDTO> getProjectComponents(String projectName);

    boolean checkName(String name);
}
