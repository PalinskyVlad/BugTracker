package com.bugtracker.validator;

import com.bugtracker.dto.IssueDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class IssueDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return IssueDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
