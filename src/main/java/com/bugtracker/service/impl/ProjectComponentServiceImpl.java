package com.bugtracker.service.impl;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.ProjectComponentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectComponentRepository;
import com.bugtracker.service.ProjectComponentService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectComponentServiceImpl implements ProjectComponentService{

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private ProjectComponentMapper mapper;

    @Override
    public ProjectComponentDTO addProjectComponent(ProjectComponentDTO projectComponentDTO) {
        ProjectComponentDTO savedProjectComponent = mapper.projectComponentToProjectComponentDTO(projectComponentRepository
                                                    .saveAndFlush(mapper.projectComponentDTOToProjectComponent(projectComponentDTO)));

        return savedProjectComponent;
    }

    @Override
    public void delete(long id) {
        projectComponentRepository.delete(id);
    }

    @Override
    public ProjectComponentDTO getByName(String name) {
        return mapper.projectComponentToProjectComponentDTO(projectComponentRepository.getByName(name));
    }

    @Override
    public ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO) {
        return mapper.projectComponentToProjectComponentDTO(projectComponentRepository
                .saveAndFlush(mapper.projectComponentDTOToProjectComponent(projectComponentDTO)));
    }

    @Override
    public List<ProjectComponentDTO> getAll() {
        return mapper.projectComponentsToProjectComponentDTOs(projectComponentRepository.findAll());
    }
}
