package com.bugtracker.validator;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IssueDTOValidator implements Validator {

    private static final String NAME = "name";
    private static final String ISSUE_TYPE = "issueType";
    private static final String SUMMARY = "summary";
    private static final String PRIORITY = "priority";

    private static final String ERROR_CODE_REQUIRED_NAME = "required.name";
    private static final String ERROR_CODE_NOT_UNIQUE_NAME = "not.unique.name";
    private static final String ERROR_CODE_REQUIRED_ISSUE_TYPE = "required.issueType";
    private static final String ERROR_CODE_REQUIRED_SUMMARY = "required.summary";
    private static final String ERROR_CODE_REQUIRED_PRIORITY = "required.priority";

    @Autowired
    private IssueService issueService;

    @Override
    public boolean supports(Class<?> clazz) {
        return IssueDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        IssueDTO issueDTO = (IssueDTO) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, NAME,
                ERROR_CODE_REQUIRED_NAME);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, ISSUE_TYPE,
                ERROR_CODE_REQUIRED_ISSUE_TYPE);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, SUMMARY,
                ERROR_CODE_REQUIRED_SUMMARY);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, PRIORITY,
                ERROR_CODE_REQUIRED_PRIORITY);

        if (issueService.checkName(issueDTO.getName())) {
            errors.rejectValue(NAME, ERROR_CODE_NOT_UNIQUE_NAME);
        }
    }
}
