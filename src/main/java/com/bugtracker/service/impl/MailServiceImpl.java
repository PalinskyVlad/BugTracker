package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

    private static final String FROM_EMAIL = "from.email";
    private static final String MESSAGE = "confirm.message";
    private static final String PLEASE_VERIFY_TITLE = "please.verify.title";

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @Autowired
    private MailSender MailSender;

    public void sendRegistrationMail(UserDTO userDTO) {

        String secretCode = java.util.UUID.randomUUID().toString();
        userDTO.setSecretCode(secretCode);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDTO.getEmail());
        message.setFrom(messageSource.getMessage(FROM_EMAIL, null, Locale.US));
        message.setSubject(messageSource.getMessage(PLEASE_VERIFY_TITLE, null, Locale.US));
        message.setText(messageSource.getMessage(MESSAGE, new Object[] { userDTO.getLastName(), userDTO.getFirstName(), secretCode} , Locale.US));
        MailSender.send((SimpleMailMessage) message);
    }
}
