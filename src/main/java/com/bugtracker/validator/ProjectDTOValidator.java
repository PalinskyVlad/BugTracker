package com.bugtracker.validator;

import com.bugtracker.dto.ProjectDTO;
import com.bugtracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectDTOValidator implements Validator {

    private static final String NAME = "name";

    
    private static final String ERROR_CODE_REQUIRED_NAME = "required.name";
    private static final String ERROR_CODE_NOT_UNIQUE_NAME = "not.unique.name";


    @Autowired
    private ProjectService projectService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProjectDTO issueDTO = (ProjectDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, NAME,
                ERROR_CODE_REQUIRED_NAME);

        if (projectService.checkName(issueDTO.getName())) {
            errors.rejectValue(NAME, ERROR_CODE_NOT_UNIQUE_NAME);
        }

    }
}
