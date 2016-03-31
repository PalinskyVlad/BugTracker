package com.bugtracker.service;

import com.bugtracker.entity.User;

import java.util.List;

/**
 * Created by Vlados on 15.03.2016.
 */
public interface UserService {

    User addUser(User user);
    void delete(long id);
    User getByUsername(String username);
    User getByEmail(String email);
    User editUser(User user);
    List<User> getAll();
    boolean confirmSecretCode(String secretCode);
    boolean checkEmail(String email);
    boolean checkUsername(String username);



}
