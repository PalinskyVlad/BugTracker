package com.bugtracker.controller;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.MailService;
import com.bugtracker.service.UserService;
import com.bugtracker.utils.VerifyRecaptcha;
import com.bugtracker.validator.UserDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class SignUpController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private UserDTOValidator userDTOValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(userDTOValidator);
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String displaySignUpForm() {
        return "signUpForm";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute @Valid UserDTO userDTO , BindingResult result,
                                @RequestParam("g-recaptcha-response") String recaptcha) throws IOException {
        ModelAndView modelAndView = new ModelAndView("signUpForm");
        boolean verify = VerifyRecaptcha.verify(recaptcha);
        if (!verify) {
            return modelAndView;
        }
        if (result.hasErrors()) {
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
