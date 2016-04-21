package com.bugtracker.mapper.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import com.bugtracker.mapper.UserMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapperImpl implements UserMapper {

    private final static MapperFacade mapper;

    static
    {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(User.class, UserDTO.class)
                .byDefault()
                .register();
        mapper = mapperFactory.getMapperFacade();
    }

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
}
