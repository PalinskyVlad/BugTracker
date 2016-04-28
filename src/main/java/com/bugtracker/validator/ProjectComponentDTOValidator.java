package com.bugtracker.validator;

import com.bugtracker.dto.ProjectComponentDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectComponentDTOValidator implements Validator {

    private static final String NAME = "name";

    private static final String ERROR_CODE_REQUIRED_NAME = "required.name";

    @Override
    public boolean supports(Class<?> clazz) {
        return ProjectComponentDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        ProjectComponentDTO projectComponentDTO = (ProjectComponentDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, NAME,
                ERROR_CODE_REQUIRED_NAME);

    }
}
