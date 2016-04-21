package com.bugtracker.service.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.Project;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.entity.ProjectVersion;
import com.bugtracker.entity.enums.IssueStatusEnum;
import com.bugtracker.mapper.IssueMapper;
import com.bugtracker.mapper.ProjectComponentMapper;
import com.bugtracker.mapper.ProjectMapper;
import com.bugtracker.mapper.ProjectVersionMapper;
import com.bugtracker.repository.ProjectComponentRepository;
import com.bugtracker.repository.ProjectRepository;
import com.bugtracker.repository.ProjectVersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.IssueRepository;
import com.bugtracker.service.IssueService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;

@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectComponentRepository projectComponentRepository;

    @Autowired
    private ProjectVersionRepository projectVersionRepository;

    @Autowired
    private ProjectComponentMapper projectComponentMapper;

    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private IssueMapper issueMapper;


    @Override
    public IssueDTO addIssue(IssueDTO issueDTO, long[] components, long[] versions, String projectName) {
        ProjectComponent projectComponent;
        ProjectVersion projectVersion;
        issueDTO.setCreatedDate(new Date());
        issueDTO.setStatus(IssueStatusEnum.OPEN);
        Issue issue = issueMapper.issueDTOToIssue(issueDTO);
        Project project = projectRepository.findByName(projectName);

        issue.setProject(project);
        project.getIssues().add(issue);

        for(long id : components) {
            projectComponent = projectComponentRepository.findOne(id);
            issue.getComponents().add(projectComponent);
            projectComponent.getIssues().add(issue);
        }

        for(long id : versions) {
            projectVersion = projectVersionRepository.findOne(id);
            issue.getVersions().add(projectVersion);
            projectVersion.getIssues().add(issue);
        }

        IssueDTO savedIssue = issueMapper.issueToIssueDTO(issueRepository.saveAndFlush(issue));

        return savedIssue;
    }

    @Override
    public void delete(long id) {
        issueRepository.delete(id);
    }

    @Override
    public IssueDTO getByName(String name) {
        return issueMapper.issueToIssueDTO(issueRepository.getByName(name));
    }

    @Override
    public IssueDTO getById(long id) {
        return issueMapper.issueToIssueDTO(issueRepository.getById(id));
    }

    @Override
    public ProjectDTO getProjectByIssueId(long id) {
        return projectMapper.projectToProjectDTO(issueRepository.getById(id).getProject());
    }

    @Override
    public Set<ProjectComponentDTO> getProjectComponentsByIssueId(long id) {
        return projectComponentMapper.projectComponentsToProjectComponentDTOs(issueRepository.getById(id).getComponents());
    }

    @Override
    public Set<ProjectVersionDTO> getProjectVersionsByIssueId(long id) {
        return projectVersionMapper.projectVersionsToProjectVersionDTOs(issueRepository.getById(id).getVersions());
    }

    @Override
    public IssueDTO editIssue(IssueDTO issueDTO) {
        return issueMapper.issueToIssueDTO(issueRepository.saveAndFlush(issueMapper.issueDTOToIssue(issueDTO)));
    }

    @Override
    public Set<IssueDTO> getIssues(String projectName) {
        return issueMapper.issuesToIssueDTOs(projectRepository.findByName(projectName).getIssues());
    }

}
