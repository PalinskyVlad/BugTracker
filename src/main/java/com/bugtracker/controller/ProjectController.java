package com.bugtracker.controller;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Vlados on 3/30/2016.
 */
@Controller
public class ProjectController {

    @Resource
    private ProjectService projectService;

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public ModelAndView addProject(@RequestParam("image") MultipartFile  image, ProjectDTO projectDTO) {
        try {
            projectDTO.setAvatar(image.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ProjectDTO savedProjectDTO= projectService.addProject(image, projectDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project");
        modelAndView.addObject("project", savedProjectDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/project/{name}", method = RequestMethod.GET)
    public ModelAndView getProject(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("project");
        modelAndView.addObject("project", projectService.getByName(name));
        return modelAndView;
    }

    @RequestMapping(value = "/project/{name}/settings", method = RequestMethod.GET)
    public ModelAndView getProjectSettings(@PathVariable String name) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("projectSettings");
        modelAndView.addObject("project", projectService.getByName(name));
        return modelAndView;
    }

    @RequestMapping(value = "/showComponents", method = RequestMethod.POST)
    public @ResponseBody
    Map<Long, String> showComponents(String projectName) {
        return projectService.getAllComponentsNameAndId(projectName);
    }

    @RequestMapping(value = "/showVersions", method = RequestMethod.POST)
    public @ResponseBody
    Map<Long, String> showVersions(String projectName) {
        return projectService.getAllVersionsNameAndId(projectName);
    }

    @RequestMapping(value = "/editProject/{name}", method = RequestMethod.POST)
    public ModelAndView editProject(@PathVariable String name, @RequestParam("image") MultipartFile  image, ProjectDTO projectDTO) {

        projectService.editProject(image, name, projectDTO);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("project");
        modelAndView.addObject("project", projectDTO);

        return modelAndView;
    }

    @RequestMapping(value = "/deleteProject/{id}")
    public String deleteProject(@PathVariable long id) {
        projectService.delete(id);
        return "dashboard";
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getProjects() {
        return projectService.getAllNames();
    }


    @RequestMapping(value = "/projectImageDisplay", method = RequestMethod.GET)
    public void showImage(@RequestParam("name") String name, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(projectService.getByName(name).getAvatar());
        response.getOutputStream().close();
    }
}
