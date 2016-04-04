package com.bugtracker.mapper;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by Vlados on 4/4/2016.
 */
@Mapper
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    List<UserDTO> usersToUserDTOs(List<User> users);
    List<User> userDTOsToUsers(List<UserDTO> userDTOs);
}
