package com.bugtracker.controller;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.service.IssueService;
import com.bugtracker.service.ProjectComponentService;
import com.bugtracker.service.ProjectService;
import com.bugtracker.service.ProjectVersionService;
import com.bugtracker.validator.IssueDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class IssueController {

    @Autowired
    private IssueService issueService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private IssueDTOValidator issueDTOValidator;

    @InitBinder("issueDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(issueDTOValidator);
    }

    @RequestMapping(value = "/issues", method = RequestMethod.POST, params = {"create"})
    public String createIssue(@Valid @ModelAttribute("issueDTO") IssueDTO issueDTO, BindingResult result,
                              long[] components, long[] versions, String projectName) {
        issueService.addIssue(issueDTO, components, versions, projectName);
        return "redirect:/" + projectName + "/issues";
    }

    @RequestMapping(value = "{projectName}/issues", method = RequestMethod.GET)
    public String getIssues(@PathVariable String projectName, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        model.addAttribute("issues", projectService.getIssues(projectName));
        return "user/issues";
    }

    @RequestMapping(value = "{projectName}/issues/{id}", method = RequestMethod.GET)
    public String getIssue(@PathVariable String projectName, @PathVariable long id, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        model.addAttribute("issue", issueService.getById(id));
        model.addAttribute("projectVersions", issueService.getProjectVersions(id));
        model.addAttribute("projectComponents", issueService.getProjectComponents(id));
        return "user/issue";
    }

    @RequestMapping(value = "/{projectName}/issues/{id}", method = RequestMethod.POST, params = {"delete"})
    public String deleteIssue(@PathVariable String projectName, @PathVariable long id) {
        issueService.delete(id);
        return "redirect:/{projectName}/issues";
    }
}
