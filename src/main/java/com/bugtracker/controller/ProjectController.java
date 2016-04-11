package com.bugtracker.controller;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Vlados on 3/30/2016.
 */
@Controller
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(ProjectDTO projectDTO) {
        projectService.addProject(projectDTO);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/project", method = RequestMethod.GET)
    public String getProject() {
        return "project";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getProjects() {
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        System.out.println("1");
        return projectService.getAllNames();
    }
}
