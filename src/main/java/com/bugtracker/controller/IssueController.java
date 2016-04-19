package com.bugtracker.controller;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.service.IssueService;
import com.bugtracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
public class IssueController {

    @Resource
    private IssueService issueService;

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/createIssue", method = RequestMethod.POST)
    public ModelAndView createIssue(IssueDTO issueDTO, long[] components, long[] versions, String projectName) {
        issueService.addIssue(issueDTO, components, versions, projectName);
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/{projectName}/issues")
    public ModelAndView getProjectVersions(@PathVariable String projectName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectIssues");
        modelAndView.addObject("project", projectService.getByName(projectName));
        modelAndView.addObject("issues", issueService.getIssues(projectName));
        return modelAndView;
    }


    @RequestMapping(value = "/issue/{id}", method = RequestMethod.GET)
    public ModelAndView getProject(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("issue");
        modelAndView.addObject("project", issueService.getProjectByIssueId(id));
        modelAndView.addObject("issue", issueService.getById(id));
        modelAndView.addObject("projectVersions", issueService.getProjectVersionsByIssueId(id));
        modelAndView.addObject("projectComponents", issueService.getProjectComponentsByIssueId(id));
        return modelAndView;
    }

}
