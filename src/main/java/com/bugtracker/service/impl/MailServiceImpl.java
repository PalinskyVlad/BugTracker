package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender MailSender;

    public void sendRegistrationMail(UserDTO userDTO) {
        String secretCode = java.util.UUID.randomUUID().toString();
        userDTO.setSecretCode(secretCode);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(userDTO.getEmail());
        message.setFrom("bugtracker.hunter@gmail.com");
        message.setSubject("Please verify your e-mail address");
        message.setText("Hi " + userDTO.getLastName() + " " + userDTO.getFirstName() + ",\n" +
                "Please verify your email address so we know that it's really you!" + "\n" +
                "localhost:8080/confirm/" + secretCode);
        MailSender.send((SimpleMailMessage) message);
    }
}
