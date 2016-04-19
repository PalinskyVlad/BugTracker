package com.bugtracker.service.impl;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectRepository;
import com.bugtracker.service.ProjectService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper mapper;

    @Override
    public ProjectDTO addProject(MultipartFile image, ProjectDTO projectDTO) {
        try {
            if (image != null) {
                projectDTO.setAvatar(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProjectDTO savedProject = mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));

        return savedProject;
    }


    @Override
    public void delete(long id) {
        projectRepository.delete(id);
    }

    @Override

    public ProjectDTO getByName(String name) {
        return mapper.projectToProjectDTO(projectRepository.findByName(name));
    }

    @Override
    public ProjectDTO editProject(MultipartFile image, String name, ProjectDTO editedProjectDTO) {

        ProjectDTO projectDTO = getByName(name);
        projectDTO.setName(editedProjectDTO.getName());
        projectDTO.setDescription(editedProjectDTO.getDescription());
        projectDTO.setPrivacy(editedProjectDTO.isPrivacy());

        try {
            if (image.getBytes().length != 0) {
                projectDTO.setAvatar(image.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapper.projectToProjectDTO(projectRepository.saveAndFlush(mapper.projectDTOToProject(projectDTO)));
    }

    @Override
    public List<String> getAllNames() {
        return projectRepository.findAllNames();
    }

    @Override
    public Map<Long, String> getAllComponentsNameAndId(String projectName) {
        Map<Long, String> componentNames = new HashMap<Long, String>();
        Set<ProjectComponent> components = projectRepository.findByName(projectName).getComponents();
        for(ProjectComponent projectComponent : components) {
            componentNames.put(projectComponent.getId(), projectComponent.getName());
        }
        return componentNames;
    }

    @Override
    public Map<Long, String> getAllVersionsNameAndId(String projectName) {
        Map<Long, String>  versionNames = new HashMap<Long, String>();
        Set<ProjectVersion> versions = projectRepository.findByName(projectName).getVersions();
        for(ProjectVersion projectVersion : versions) {
            versionNames.put(projectVersion.getId(), projectVersion.getName());
        }
        return versionNames;
    }

}
