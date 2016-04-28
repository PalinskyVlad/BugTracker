package com.bugtracker.service;

import com.bugtracker.dto.UserDTO;

import java.util.Set;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO getByUsername(String username);
    Set<UserDTO> getAllUsers();
    UserDTO editUser(UserDTO userDTO);
    void delete(long id);

    boolean confirmSecretCode(String secretCode);
    boolean checkEmail(String email);
    boolean checkUsername(String username);
}
