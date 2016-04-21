package com.bugtracker.validator;

import com.bugtracker.dto.ProjectDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProjectDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
