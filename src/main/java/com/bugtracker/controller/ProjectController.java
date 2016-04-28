package com.bugtracker.controller;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.logger.UserActionLogger;
import com.bugtracker.service.ProjectService;
import com.bugtracker.validator.ProjectDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @Autowired
    private ProjectDTOValidator projectDTOValidator;

    @InitBinder("projectDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(projectDTOValidator);
    }

    @RequestMapping(value = "/projects", method = RequestMethod.POST, params = {"create"})
    public String createProject(Model model, MultipartFile  image, ProjectDTO projectDTO) {
        model.addAttribute("project", projectService.addProject(image, projectDTO));
        return "user/project";
    }

    @RequestMapping(value = "/{projectName}", method = RequestMethod.GET)
    public String getProject(@PathVariable String projectName, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        return "user/project";
    }

    @RequestMapping(value = "/{projectName}", method = RequestMethod.POST, params = {"edit"})
    public String editProject(@PathVariable String projectName,
                              @RequestParam("image") MultipartFile  image,
                              @Valid @ModelAttribute("projectDTO") ProjectDTO projectDTO, BindingResult result,
                              Model model) {
        projectService.editProject(image, projectName, projectDTO);
        model.addAttribute("project", projectDTO);
        return "redirect:/{projectName}";
    }

    @RequestMapping(value = "/{projectName}/{id}", method = RequestMethod.POST, params = {"delete"})
    public String deleteProject(@PathVariable String projectName, @PathVariable long id) {
        projectService.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/{projectName}/settings", method = RequestMethod.GET)
    public String getProjectSettings(@PathVariable String projectName, Model model) {
        model.addAttribute("project", projectService.getByName(projectName));
        return "user/projectSettings";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getProjects() {
        return projectService.getAllNames();
    }

    @RequestMapping(value = "/versions", method = RequestMethod.POST)
    public @ResponseBody
    Map<Long, String> getVersions(String projectName) {
        return projectService.getAllVersionsNameAndId(projectName);
    }

    @RequestMapping(value = "/components", method = RequestMethod.POST)
    public @ResponseBody
    Map<Long, String> getComponents(String projectName) {
        return projectService.getAllComponentsNameAndId(projectName);
    }

    @RequestMapping(value = "/projectImageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("name") String name, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(projectService.getAvatar(name));
        response.getOutputStream().close();
    }
}
