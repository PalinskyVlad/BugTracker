package com.bugtracker.mapper.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import com.bugtracker.mapper.UserMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {

        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setRole(user.getRole());
        userDTO.setSecretCode(user.getSecretCode());
        userDTO.setConfirmed(user.isConfirmed());
        userDTO.setIssues(user.getIssues());

        return userDTO;
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();

        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setRole(userDTO.getRole());
        user.setSecretCode(userDTO.getSecretCode());
        user.setConfirmed(userDTO.isConfirmed());
        user.setIssues(userDTO.getIssues());

        return user;
    }

    @Override
    public List<UserDTO> usersToUserDTOs(List<User> users) {
        if (users == null) {
            return null;
        }

        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (User user : users) {
            userDTOs.add(userToUserDTO(user));
        }

        return userDTOs;
    }

    @Override
    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        if (userDTOs == null) {
            return null;
        }

        List<User> users = new ArrayList<User>();

        for (UserDTO userDTO : userDTOs) {
            users.add(userDTOToUser(userDTO));
        }

        return users;
    }
}
