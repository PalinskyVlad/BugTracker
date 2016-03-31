package com.bugtracker.service.impl;

import com.bugtracker.entity.User;
import com.bugtracker.service.MailService;
import com.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;


/**
 * Created by Vlados on 3/31/2016.
 */
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailSender MailSender;

    public void sendRegistrationMail(User user) {
        String secretCode = java.util.UUID.randomUUID().toString();
        user.setSecretCode(secretCode);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setFrom("bugtracker.hunter@gmail.com");
        message.setSubject("Please verify your e-mail address");
        message.setText("Hi " + user.getLastName() + " " + user.getFirstName() + ",\n" +
                "Please verify your email address so we know that it's really you!" + "\n" +
                "localhost:8080/confirm/" + secretCode);
        MailSender.send((SimpleMailMessage) message);
    }
}
