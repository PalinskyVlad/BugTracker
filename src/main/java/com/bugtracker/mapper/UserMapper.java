package com.bugtracker.mapper;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;

import java.util.Set;

public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    Set<UserDTO> usersToUserDTOs(Set<User> users);
    Set<User> userDTOsToUsers(Set<UserDTO> userDTOs);
}
