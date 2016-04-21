package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDTO userDTO = userService.getByUsername(username);

        if (!userDTO.isConfirmed()) {
            userDTO = null;
        }

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(userDTO.getRole().name()));


        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(userDTO.getUsername(),
                                                                       userDTO.getPassword(), roles);
        return userDetails;
    }
}
