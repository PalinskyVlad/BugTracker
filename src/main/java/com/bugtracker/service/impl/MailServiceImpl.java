package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    private static final String FROM_EMAIL = "bugtracker.hunter@gmail.com";
    private static final String PLEASE_VERIFY_TITLE = "\"Please verify your e-mail address\"";
    private static final String PLEASE_VERIFY_MESSAGE = "Please verify your email address so we know that it's really you!";
    private static final String HI = "Hi ";
    private static final String CONFIRM_URL = "localhost:8080/confirm/";


    @Autowired
    private MailSender MailSender;

    public void sendRegistrationMail(UserDTO userDTO) {
        String secretCode = java.util.UUID.randomUUID().toString();
        userDTO.setSecretCode(secretCode);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDTO.getEmail());
        message.setFrom(FROM_EMAIL);
        message.setSubject(PLEASE_VERIFY_TITLE);
        message.setText(HI + userDTO.getLastName() + " " + userDTO.getFirstName() + ",\n" +
                PLEASE_VERIFY_MESSAGE + "\n" +
                CONFIRM_URL + secretCode);
        MailSender.send((SimpleMailMessage) message);
    }
}
