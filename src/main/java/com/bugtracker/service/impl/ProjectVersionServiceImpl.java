package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.mapper.IssueMapper;
import com.bugtracker.mapper.ProjectMapper;
import com.bugtracker.mapper.ProjectVersionMapper;
import com.bugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectVersionRepository;
import com.bugtracker.service.ProjectVersionService;

import java.util.Set;

@Service
public class ProjectVersionServiceImpl implements ProjectVersionService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @Autowired
    private IssueMapper issueMapper;

    @Autowired
    private ProjectVersionMapper versionMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ProjectVersionDTO addProjectVersion(ProjectDTO projectDTO, ProjectVersionDTO projectVersionDTO) {

        ProjectVersion projectVersion = versionMapper.projectVersionDTOToProjectVersion(projectVersionDTO);

        Project project = projectMapper.projectDTOToProject(projectDTO);

        projectVersion.setProject(project);


        project.getVersions().add(projectVersion);

        ProjectVersionDTO savedProjectComponent = versionMapper.projectVersionToProjectVersionDTO(projectVersionRepository
                .saveAndFlush(projectVersion));

        return savedProjectComponent;


    }

    @Override
    public void delete(long id) {
        projectVersionRepository.delete(id);
    }

    @Override
    public ProjectVersionDTO getByName(String name) {
        return versionMapper.projectVersionToProjectVersionDTO(projectVersionRepository.getByName(name));
    }

    @Override
    public ProjectVersionDTO getById(long id) {
        return versionMapper.projectVersionToProjectVersionDTO(projectVersionRepository.getById(id));
    }

    @Override
    public Set<ProjectVersionDTO> getProjectVersions(String projectName) {
        return versionMapper.projectVersionsToProjectVersionDTOs(projectRepository.findByName(projectName).getVersions());
    }

    @Override
    public Set<IssueDTO> getIssues(long id) {
        return issueMapper.issuesToIssueDTOs(projectVersionRepository.getById(id).getIssues());
    }

    @Override
    public ProjectDTO getProjectByProjectVersionId(long id) {
        return projectMapper.projectToProjectDTO(projectVersionRepository.getById(id).getProject());
    }

    @Override
    public ProjectVersionDTO editProjectVersion(ProjectVersionDTO projectVersionDTO) {
        return versionMapper.projectVersionToProjectVersionDTO(projectVersionRepository.saveAndFlush(versionMapper.projectVersionDTOToProjectVersion(projectVersionDTO)));
    }

}
