package com.bugtracker.validator;

import com.bugtracker.dto.ProjectDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
