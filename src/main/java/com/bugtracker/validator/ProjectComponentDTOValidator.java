package com.bugtracker.validator;

import com.bugtracker.dto.ProjectComponentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProjectComponentDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectComponentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
