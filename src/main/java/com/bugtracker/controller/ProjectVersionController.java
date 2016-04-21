package com.bugtracker.controller;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.logger.UserActionLogger;
import com.bugtracker.service.ProjectService;
import com.bugtracker.service.ProjectVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class ProjectVersionController {

    @Autowired
    private ProjectVersionService projectVersionService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserActionLogger logger;

    @RequestMapping(value = "/{projectName}/addProjectVersion")
    public ModelAndView addProjectVersion(@PathVariable String projectName, ProjectVersionDTO projectVersionDTO, Principal principal){
        ProjectDTO projectDTO = projectService.getByName(projectName);
        projectVersionService.addProjectVersion(projectDTO, projectVersionDTO);
        logger.projectVersionAdded(principal.getName(), projectDTO.getName(), projectVersionDTO.getName() );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project");
        modelAndView.addObject("project", projectDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/{projectName}/projectVersions")
    public ModelAndView getProjectVersions(@PathVariable String projectName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectVersions");
        modelAndView.addObject("project", projectService.getByName(projectName));
        modelAndView.addObject("projectVersions", projectVersionService.getProjectVersions(projectName));
        return modelAndView;
    }

    @RequestMapping(value = "/projectVersion/{id}", method = RequestMethod.GET)
    public ModelAndView getProject(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectVersion");
        modelAndView.addObject("project", projectVersionService.getProjectByProjectVersionId(id));
        modelAndView.addObject("projectVersion", projectVersionService.getById(id));
        modelAndView.addObject("issues", projectVersionService.getIssues(id));
        return modelAndView;
    }

    @RequestMapping(value = "/deleteProjectVersion/{id}")
    public String deleteProject(@PathVariable long id) {
        projectVersionService.delete(id);
        return "projectVersions";
    }
}
