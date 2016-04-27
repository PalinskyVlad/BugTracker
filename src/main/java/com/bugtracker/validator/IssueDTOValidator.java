package com.bugtracker.validator;

import com.bugtracker.dto.IssueDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class IssueDTOValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return IssueDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
