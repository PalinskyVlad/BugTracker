package com.bugtracker.mapper.impl;

import com.bugtracker.dto.IssueDTO;
import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.Issue;
import com.bugtracker.entity.User;
import com.bugtracker.mapper.UserMapper;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapperImpl extends CustomMapper<UserDTO, User> implements UserMapper {

    @Autowired
    private MapperFacade mapper;

    @Override
    public UserDTO userToUserDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public User userDTOToUser(UserDTO userDTO) {
        return mapper.map(userDTO, User.class);
    }

    @Override
    public Set<UserDTO> usersToUserDTOs(Set<User> users) {
        if (users == null) {
            return null;
        }

        Set<UserDTO> userDTOs = new HashSet<UserDTO>();

        for (User user : users) {
            userDTOs.add(userToUserDTO(user));
        }

        return userDTOs;
    }

    @Override
    public Set<User> userDTOsToUsers(Set<UserDTO> userDTOs) {
        if (userDTOs == null) {
            return null;
        }

        Set<User> users = new HashSet<User>();

        for (UserDTO userDTO : userDTOs) {
            users.add(userDTOToUser(userDTO));
        }

        return users;
    }

    @Override
    public void mapAtoB(UserDTO a, User b, MappingContext context) {
        b.setId(a.getId());
        b.setUsername(a.getUsername());
        b.setEmail(a.getEmail());
        b.setPassword(a.getPassword());
        b.setFirstName(a.getFirstName());
        b.setLastName(a.getLastName());
        b.setRole(a.getRole());
        b.setSecretCode(a.getSecretCode());
        b.setConfirmed(a.isConfirmed());
    }

    @Override
    public void mapBtoA(User b, UserDTO a, MappingContext context) {
        a.setId(b.getId());
        a.setUsername(b.getUsername());
        a.setEmail(b.getEmail());
        a.setPassword(b.getPassword());
        a.setFirstName(b.getFirstName());
        a.setLastName(b.getLastName());
        a.setRole(b.getRole());
        a.setSecretCode(b.getSecretCode());
        a.setConfirmed(b.isConfirmed());
    }
}
