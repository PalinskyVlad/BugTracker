package com.bugtracker.validator;

import com.bugtracker.dto.ProjectComponentDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProjectComponentDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectComponentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
