package com.bugtracker.validator;

import com.bugtracker.dto.ProjectVersionDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProjectVersionDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectVersionDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
