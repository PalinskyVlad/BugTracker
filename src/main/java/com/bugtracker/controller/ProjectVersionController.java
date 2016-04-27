package com.bugtracker.controller;

import com.bugtracker.dto.ProjectVersionDTO;
import com.bugtracker.service.ProjectService;
import com.bugtracker.service.ProjectVersionService;
import com.bugtracker.validator.ProjectVersionDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ProjectVersionController {

    @Autowired
    private ProjectVersionService projectVersionService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectVersionDTOValidator projectVersionDTOValidator;

    @InitBinder("projectVersionDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(projectVersionDTOValidator);
    }

    @RequestMapping(value = "/{projectName}/versions", method = RequestMethod.POST, params = {"create"})
    public String addProjectVersion(@Valid @ModelAttribute("projectVersionDTO") ProjectVersionDTO projectVersionDTO, BindingResult result,
                                    @PathVariable String projectName, Model model){
        projectVersionService.addProjectVersion(projectName, projectVersionDTO);
        return "redirect:/{projectName}/versions";
    }

    @RequestMapping(value = "/{projectName}/versions", method = RequestMethod.GET)
    public String getProjectVersions(@PathVariable String projectName, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        model.addAttribute("projectVersions", projectService.getProjectVersions(projectName));
        return "user/projectVersions";
    }

    @RequestMapping(value = "{projectName}/versions/{id}", method = RequestMethod.GET)
    public String getProject(@PathVariable String projectName, @PathVariable long id, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        model.addAttribute("projectVersion", projectVersionService.getById(id));
        model.addAttribute("issues", projectVersionService.getIssues(id));
        return "user/projectVersion";
    }

    @RequestMapping(value = "/{projectName}/versions/{id}", method = RequestMethod.POST, params = {"delete"})
    public String deleteProject(@PathVariable String projectName, @PathVariable long id) {
        projectVersionService.delete(id);
        return "redirect:/{projectName}/versions";
    }
}
