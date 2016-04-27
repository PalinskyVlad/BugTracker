package com.bugtracker.controller;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.MailService;
import com.bugtracker.service.UserService;
import com.bugtracker.utils.VerifyRecaptcha;
import com.bugtracker.validator.UserDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserDTOValidator userDTOValidator;

    @InitBinder("userDTO")
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userDTOValidator);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displaySignUpForm() {
        return "signUp";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String addUser(@Valid @ModelAttribute("userDTO") UserDTO userDTO , BindingResult result,
                          @RequestParam("g-recaptcha-response") String recaptcha) throws IOException {
        boolean verify = VerifyRecaptcha.verify(recaptcha);
        if (!verify) {
            return "signUP";
        }
        if (result.hasErrors()) {
            return "signUp";
        }
        mailService.sendRegistrationMail(userDTO);
        userService.addUser(userDTO);
        return "signUpSuccess";
    }

    @RequestMapping(value = "/profile")
    public String viewProfile(Model model, Principal principal) {
        if (principal.getName() == null) {
            return "dashboard";
        }
        model.addAttribute("user", userService.getByUsername(principal.getName()));
        return "user/profile";
    }

    @RequestMapping(value = "/confirm", params= {"secretCode"})
    public String confirm(String secretCode) {
        if (userService.confirmSecretCode(secretCode)) {
            return "confirmed";
        } else {
            return "dashboard";
        }
    }
}
