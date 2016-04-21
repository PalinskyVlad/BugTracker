package com.bugtracker.service;

import com.bugtracker.dto.UserDTO;

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
