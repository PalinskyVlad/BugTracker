package com.bugtracker.controller;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.service.IssueService;
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
public class IssueController {

    @Resource
    private IssueService issueService;

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/createIssue", method = RequestMethod.POST)
    public ModelAndView createIssue(Issue issue, String[] NAME) {

        if (NAME != null)
        for(int i = 0; i < NAME.length; i++) {
            System.out.println(NAME[i]);
        }
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @RequestMapping(value = "/test/projects")
    public String getProject() {
        return "projects";
    }

}
