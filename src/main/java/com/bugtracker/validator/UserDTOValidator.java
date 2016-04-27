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

    private static final String PASSWORD = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String USERNAME = "username";

    private static final String ERROR_CODE_REQUIRED_PASSWORD = "required.password";
    private static final String ERROR_CODE_REQUIRED_FIRST_NAME = "required.firstName";
    private static final String ERROR_CODE_REQUIRED_LAST_NAME = "required.lastName";
    private static final String ERROR_CODE_REQUIRED_EMAIL = "required.email";
    private static final String ERROR_CODE_REGISTERED_EMAIL = "registered.email";
    private static final String ERROR_CODE_REQUIRED_USERNAME = "required.username";
    private static final String ERROR_CODE_REGISTERED_USERNAME = "registered.username";

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserDTO userDTO = (UserDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PASSWORD,
                ERROR_CODE_REQUIRED_PASSWORD);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIRST_NAME,
                ERROR_CODE_REQUIRED_FIRST_NAME);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, LAST_NAME,
                ERROR_CODE_REQUIRED_LAST_NAME);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, EMAIL,
                ERROR_CODE_REQUIRED_EMAIL);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, USERNAME,
                ERROR_CODE_REQUIRED_USERNAME);

        if (userService.checkEmail(userDTO.getEmail())) {
            errors.rejectValue(EMAIL, ERROR_CODE_REGISTERED_EMAIL);
        }
        if (userService.checkUsername(userDTO.getUsername())) {
            errors.rejectValue(USERNAME, ERROR_CODE_REGISTERED_USERNAME);
        }
    }
}
