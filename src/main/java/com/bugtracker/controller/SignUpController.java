package com.bugtracker.controller;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import com.bugtracker.mapper.UserMapper;
import com.bugtracker.service.MailService;
import com.bugtracker.service.UserService;
import com.bugtracker.utils.VerifyRecaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.IOException;

/**
 * Created by Vlados on 3/25/2016.
 */
@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displaySignUpForm() {
        return "signUpForm";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid UserDTO userDTO , BindingResult result,
                                @RequestParam("g-recaptcha-response") String recaptcha) throws IOException {
        ModelAndView modelAndView = new ModelAndView("signUpForm");
        if (result.hasErrors()) {
            return modelAndView;
        }
        if (userService.checkEmail(userDTO.getEmail())) {
            modelAndView.addObject("emailError", "User with the e-mail " + userDTO.getEmail() + " is already registered");
            return  modelAndView;
        }
        if (userService.checkUsername(userDTO.getUsername())) {
            modelAndView.addObject("usernameError", "User with the username " + userDTO.getUsername() + " is already registered");
            return modelAndView;
        }
        boolean verify = VerifyRecaptcha.verify(recaptcha);
        if (!verify) {
            modelAndView.addObject("captchaError", "Please verify captcha so we know that it's not robot!");
            return modelAndView;
        }
        mailService.sendRegistrationMail(userDTO);
        userService.addUser(userDTO);
        modelAndView.setViewName("signUpSuccess");
        return modelAndView;
    }

    @RequestMapping(value = "/confirm/{secretCode}")
    public String confirm(@PathVariable String secretCode) {
        if (userService.confirmSecretCode(secretCode)) {
            return "confirmed";
        } else {
            return "index";
        }
    }


}
