package com.bugtracker.controller;

import com.bugtracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by Vlados on 3/30/2016.
 */
@Controller
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView addProject() {
        System.out.println();
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
