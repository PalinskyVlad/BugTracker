package com.bugtracker.service;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface UserService {

    UserDTO addUser(UserDTO userDTO);
    void delete(long id);
    UserDTO getByUsername(String username);
    UserDTO getByEmail(String email);
    UserDTO editUser(UserDTO userDTO);
    boolean confirmSecretCode(String secretCode);
    boolean checkEmail(String email);
    boolean checkUsername(String username);
}
