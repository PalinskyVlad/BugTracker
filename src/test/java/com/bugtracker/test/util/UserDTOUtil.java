package com.bugtracker.test.util;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.enums.UserRoleEnum;

/**
 * Created by Vlados on 15.03.2016.
 */
public class UserDTOUtil {

    public static UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("palinskyvlad@gmail.com");
        userDTO.setFirstName("Vlad");
        userDTO.setLastName("Palinsky");
        userDTO.setUsername("username");
        userDTO.setPassword("password");
        userDTO.setRole(UserRoleEnum.ADMIN);

        return userDTO;
    }

}
