package com.bugtracker.service;

import com.bugtracker.dto.UserDTO;

public interface MailService {
    void sendRegistrationMail(UserDTO userDTO);
}
