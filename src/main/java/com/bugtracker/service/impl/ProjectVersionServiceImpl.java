package com.bugtracker.service.impl;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.ProjectVersionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectVersionRepository;
import com.bugtracker.service.ProjectVersionService;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
@Service
public class ProjectVersionServiceImpl implements ProjectVersionService {

    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @Autowired
    private ProjectVersionMapper mapper;

    @Override
    public ProjectVersionDTO addProjectVersion(ProjectVersionDTO projectVersionDTO) {
        ProjectVersionDTO savedProjectVercion = mapper.projectVersionToProjectVersionDTO(projectVersionRepository
                                                .saveAndFlush(mapper.projectVersionDTOToProjectVersion(projectVersionDTO)));

        return savedProjectVercion;
    }

    @Override
    public void delete(long id) {
        projectVersionRepository.delete(id);
    }

    @Override
    public ProjectVersionDTO getByName(String name) {
        return mapper.projectVersionToProjectVersionDTO(projectVersionRepository.getByName(name));
    }

    @Override
    public ProjectVersionDTO editProjectVersion(ProjectVersionDTO projectVersionDTO) {
        return mapper.projectVersionToProjectVersionDTO(projectVersionRepository.saveAndFlush(mapper.projectVersionDTOToProjectVersion(projectVersionDTO)));
    }

    @Override
    public List<ProjectVersionDTO> getAll() {
        return mapper.projectVersionsToProjectVersionDTOs(projectVersionRepository.findAll());
    }
}
