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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
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
    private IssueMapper issueMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private ProjectComponentMapper projectComponentMapper;

    @Autowired
    private ProjectVersionMapper projectVersionMapper;

    @Override
    public IssueDTO addIssue(IssueDTO issueDTO, long[] componentIndexes, long[] versionIndexes, String projectName) {
        issueDTO.setCreatedDate(new Date());
        issueDTO.setStatus(IssueStatusEnum.OPEN);
        Issue issue = issueMapper.issueDTOToIssue(issueDTO);
        Project project = projectRepository.findByName(projectName);

        issue.setProject(project);
        project.getIssues().add(issue);

        List<Long> componentIndexesList = new ArrayList<Long>();

        for(int i = 0; i < componentIndexes.length; i++) {
            componentIndexesList.add(componentIndexes[i]);
        }

        List<ProjectComponent> componentList = projectComponentRepository.findAll(componentIndexesList);

        for(ProjectComponent projectComponent : componentList) {
            issue.getComponents().add(projectComponent);
            projectComponent.getIssues().add(issue);
        }

        List<Long> versionIndexesList = new ArrayList<Long>();

        for(int i = 0; i < versionIndexes.length; i++) {
            versionIndexesList.add(versionIndexes[i]);
        }

        List<ProjectVersion> versionList = projectVersionRepository.findAll(versionIndexesList);

        for(ProjectVersion projectVersion : versionList) {
            issue.getVersions().add(projectVersion);
            projectVersion.getIssues().add(issue);
        }

        IssueDTO savedIssue = issueMapper.issueToIssueDTO(issueRepository.saveAndFlush(issue));

        return savedIssue;
    }

    @Override
    public IssueDTO getByName(String name) {
        return issueMapper.issueToIssueDTO(issueRepository.findByName(name));
    }

    @Override
    public IssueDTO getById(long id) {
        return issueMapper.issueToIssueDTO(issueRepository.findById(id));
    }

    @Override
    public IssueDTO editIssue(IssueDTO issueDTO) {
        return issueMapper.issueToIssueDTO(issueRepository.saveAndFlush(issueMapper.issueDTOToIssue(issueDTO)));
    }

    @Override
    public void delete(long id) {
        issueRepository.delete(id);
    }

    @Override
    public ProjectDTO getProject(long id) {
        return projectMapper.projectToProjectDTO(issueRepository.findById(id).getProject());
    }

    @Override
    public Set<ProjectComponentDTO> getProjectComponents(long id) {
        return projectComponentMapper.projectComponentsToProjectComponentDTOs(issueRepository.findById(id).getComponents());
    }

    @Override
    public Set<ProjectVersionDTO> getProjectVersions(long id) {
        return projectVersionMapper.projectVersionsToProjectVersionDTOs(issueRepository.findById(id).getVersions());
    }

    @Override
    public boolean checkName(String name) {
        if (issueRepository.findByName(name) != null) {
            return true;
        }
        return false;
    }
}
