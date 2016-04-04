package com.bugtracker.service;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;

/**
 * Created by Vlados on 3/31/2016.
 */
public interface MailService {

    void sendRegistrationMail(UserDTO userDTO);

}
