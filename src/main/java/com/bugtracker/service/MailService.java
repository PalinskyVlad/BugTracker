package com.bugtracker.service;

import com.bugtracker.entity.User;

/**
 * Created by Vlados on 3/31/2016.
 */
public interface MailService {

    void sendRegistrationMail(User user);

}
