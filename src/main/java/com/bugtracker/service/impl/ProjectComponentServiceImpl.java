package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.IssueMapper;
import com.bugtracker.mapper.ProjectComponentMapper;
import com.bugtracker.mapper.ProjectMapper;
import com.bugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectComponentRepository;
import com.bugtracker.service.ProjectComponentService;

import java.util.Set;

@Service
public class ProjectComponentServiceImpl implements ProjectComponentService{

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private IssueMapper issueMapper;

    @Autowired
    private ProjectComponentMapper componentMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public ProjectComponentDTO addProjectComponent(ProjectDTO projectDTO, ProjectComponentDTO projectComponentDTO) {

        ProjectComponent projectComponent = componentMapper.projectComponentDTOToProjectComponent(projectComponentDTO);

        Project project = projectMapper.projectDTOToProject(projectDTO);


        projectComponent.setProject(project);

        project.getComponents().add(projectComponent);

        ProjectComponentDTO savedProjectComponent = componentMapper.projectComponentToProjectComponentDTO(projectComponentRepository
                                             .saveAndFlush(projectComponent));

        return savedProjectComponent;
    }

    @Override
    public void delete(long id) {
        projectComponentRepository.delete(id);
    }

    @Override
    public ProjectComponentDTO getByName(String name) {
        return componentMapper.projectComponentToProjectComponentDTO(projectComponentRepository.getByName(name));
    }

    @Override
    public ProjectComponentDTO getById(long id) {
        return componentMapper.projectComponentToProjectComponentDTO(projectComponentRepository.getById(id));
    }

    @Override
    public Set<ProjectComponentDTO> getProjectComponents(String projectName) {
        return componentMapper.projectComponentsToProjectComponentDTOs(projectRepository.findByName(projectName).getComponents());
    }

    @Override
    public Set<IssueDTO> getIssues(long id) {
        return issueMapper.issuesToIssueDTOs(projectComponentRepository.getById(id).getIssues());
    }

    @Override
    public ProjectDTO getProjectByProjectComponentId(long id) {
        return projectMapper.projectToProjectDTO(projectComponentRepository.getById(id).getProject());
    }

    @Override
    public ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO) {
        return componentMapper.projectComponentToProjectComponentDTO(projectComponentRepository
                .saveAndFlush(componentMapper.projectComponentDTOToProjectComponent(projectComponentDTO)));
    }

}
