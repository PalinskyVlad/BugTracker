package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.mapper.IssueMapper;
import com.bugtracker.mapper.ProjectComponentMapper;
import com.bugtracker.mapper.ProjectMapper;
import com.bugtracker.repository.IssueRepository;
import com.bugtracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.ProjectComponentRepository;
import com.bugtracker.service.ProjectComponentService;
import org.springframework.transaction.annotation.Transactional;

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
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectComponentMapper projectComponentMapper;


    @Override
    public ProjectComponentDTO addProjectComponent(String projectName, ProjectComponentDTO projectComponentDTO) {

        ProjectComponent projectComponent = projectComponentMapper.projectComponentDTOToProjectComponent(projectComponentDTO);

        Project project =  projectRepository.findByName(projectName);


        projectComponent.setProject(project);

        project.getComponents().add(projectComponent);

        ProjectComponentDTO savedProjectComponent = projectComponentMapper.projectComponentToProjectComponentDTO(projectComponentRepository
                                             .saveAndFlush(projectComponent));

        return savedProjectComponent;
    }

    @Override
    public ProjectComponentDTO getByName(String name) {
        return projectComponentMapper.projectComponentToProjectComponentDTO(projectComponentRepository.findByName(name));
    }

    @Override
    public ProjectComponentDTO getById(long id) {
        return projectComponentMapper.projectComponentToProjectComponentDTO(projectComponentRepository.findById(id));
    }

    @Override
    public ProjectComponentDTO editProjectComponent(ProjectComponentDTO projectComponentDTO) {
        return projectComponentMapper.projectComponentToProjectComponentDTO(projectComponentRepository
                .saveAndFlush(projectComponentMapper.projectComponentDTOToProjectComponent(projectComponentDTO)));
    }

    @Override
    public void delete(long id) {
        projectComponentRepository.delete(id);
    }

    @Override
    public Set<IssueDTO> getIssues(long id) {
        return issueMapper.issuesToIssueDTOs(projectComponentRepository.findById(id).getIssues());
    }

    @Override
    public ProjectDTO getProject(long id) {
        return projectMapper.projectToProjectDTO(projectComponentRepository.findById(id).getProject());
    }
}
