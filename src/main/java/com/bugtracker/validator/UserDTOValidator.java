package com.bugtracker.validator;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserDTOValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserDTO userDTO = (UserDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "required.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "required.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "required.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "required.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
                "required.username");

        if (userService.checkEmail(userDTO.getEmail())) {
            errors.rejectValue("email", "registered.email");
        }
        if (userService.checkUsername(userDTO.getUsername())) {
            errors.rejectValue("username", "registered.username");
        }
    }
}
