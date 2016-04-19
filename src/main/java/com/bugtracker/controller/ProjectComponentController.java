package com.bugtracker.controller;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.ProjectComponent;
import com.bugtracker.service.ProjectComponentService;
import com.bugtracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Vlados on 4/12/2016.
 */
@Controller
public class ProjectComponentController {

    @Autowired
    ProjectComponentService projectComponentService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/{projectName}/createProjectComponent")
    public ModelAndView createProjectComponent(@PathVariable String projectName, ProjectComponentDTO projectComponentDTO){
        ProjectDTO projectDTO = projectService.getByName(projectName);
        projectComponentService.addProjectComponent(projectDTO, projectComponentDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project");
        modelAndView.addObject("project", projectDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/{projectName}/projectComponents")
    public ModelAndView getProjectComponents(@PathVariable String projectName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectComponents");
        modelAndView.addObject("projectName", projectName);
        modelAndView.addObject("project", projectService.getByName(projectName));
        modelAndView.addObject("projectComponents", projectComponentService.getProjectComponents(projectName));
        return modelAndView;
    }

    @RequestMapping(value = "/projectComponent/{id}", method = RequestMethod.GET)
    public ModelAndView getProject(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectComponent");
        modelAndView.addObject("project", projectComponentService.getProjectByProjectComponentId(id));
        modelAndView.addObject("projectComponent", projectComponentService.getById(id));
        modelAndView.addObject("issues", projectComponentService.getIssues(id));
        return modelAndView;
    }

    @RequestMapping(value = "/deleteProjectComponent/{id}")
    public String deleteProject(@PathVariable long id) {
        projectComponentService.delete(id);
        return "projectComponents";
    }

}
