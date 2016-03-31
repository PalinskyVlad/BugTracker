package com.bugtracker.test.util;

import com.bugtracker.entity.User;
import com.bugtracker.entity.enums.UserRoleEnum;

/**
 * Created by Vlados on 15.03.2016.
 */
public class UserUtil {

    public static User createUser() {
        User user = new User();
        user.setEmail("lolik@gmail.com");
        user.setFirstName("Grisha");
        user.setLastName("Petrov");
        user.setUsername("demon");
        user.setPassword("lalka");
        user.setRole(UserRoleEnum.ADMIN);

        return user;
    }

}
