package com.bugtracker.controller;

import com.bugtracker.entity.User;
import com.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by Vlados on 4/5/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile")
    public ModelAndView viewProfile(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getByUsername(principal.getName()));
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
