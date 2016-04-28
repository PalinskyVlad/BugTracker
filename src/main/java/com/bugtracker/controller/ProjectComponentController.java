package com.bugtracker.controller;

import com.bugtracker.dto.ProjectComponentDTO;
import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.logger.UserActionLogger;
import com.bugtracker.service.ProjectComponentService;
import com.bugtracker.service.ProjectService;
import com.bugtracker.validator.ProjectComponentDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class ProjectComponentController {

    @Autowired
    private ProjectComponentService projectComponentService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectComponentDTOValidator projectComponentDTOValidator;

    @InitBinder("projectComponentDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(projectComponentDTOValidator);
    }

    @RequestMapping(value = "/{projectName}/components", method = RequestMethod.POST, params = {"create"})
    public String createProjectComponent(@Valid @ModelAttribute("projectComponentDTO") ProjectComponentDTO projectComponentDTO, BindingResult result,
                                         @PathVariable String projectName, Model model){
        projectComponentService.addProjectComponent(projectName, projectComponentDTO);
        return "redirect:/{projectName}/components";
    }

    @RequestMapping(value = "/{projectName}/components", method = RequestMethod.GET)
    public String getProjectComponents(@PathVariable String projectName, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        model.addAttribute("projectComponents", projectService.getProjectComponents(projectName));
        return "user/projectComponents";
    }

    @RequestMapping(value = "{projectName}/components/{id}", method = RequestMethod.GET)
    public String getProject(@PathVariable String projectName, @PathVariable long id, Model model) {
        model.addAttribute("project", projectComponentService.getProject(id));
        model.addAttribute("projectComponent", projectComponentService.getById(id));
        model.addAttribute("issues", projectComponentService.getIssues(id));
        return "user/projectComponent";
    }

    @RequestMapping(value = "/{projectName}/components/{id}", method = RequestMethod.POST, params = {"delete"})
    public String deleteProject(@PathVariable String projectName, @PathVariable long id) {
        projectComponentService.delete(id);
        return "redirect:/{projectName}/components";
    }

}
