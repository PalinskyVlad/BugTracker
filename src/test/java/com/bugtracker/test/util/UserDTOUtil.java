package com.bugtracker.test.util;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.enums.UserRoleEnum;

/**
 * Created by Vlados on 15.03.2016.
 */
public class UserDTOUtil {

    public static UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail("lolik@gmail.com");
        userDTO.setFirstName("Grisha");
        userDTO.setLastName("Petrov");
        userDTO.setUsername("demon");
        userDTO.setPassword("lalka");
        userDTO.setRole(UserRoleEnum.ADMIN);

        return userDTO;
    }

}
