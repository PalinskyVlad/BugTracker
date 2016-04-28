package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import com.bugtracker.entity.enums.UserRoleEnum;
import com.bugtracker.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.UserRepository;
import com.bugtracker.service.UserService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (!user.isConfirmed()) {
            user = null;
        }
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(), roles);
        return userDetails;
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setRole(UserRoleEnum.ROLE_USER);
        userDTO.setPassword(shaPasswordEncoder.encodePassword(userDTO.getPassword(), null));
        UserDTO savedUser = mapper.userToUserDTO(userRepository.saveAndFlush(mapper.userDTOToUser(userDTO)));

        return savedUser;
    }

    @Override
    public UserDTO getByUsername(String username) {
        return mapper.userToUserDTO(userRepository.findByUsername(username));
    }

    @Override
    public Set<UserDTO> getAllUsers() {
        return mapper.usersToUserDTOs(new HashSet<User>(userRepository.findAll()));
    }

    @Override
    public UserDTO editUser(UserDTO userDTO) {
        return mapper.userToUserDTO(userRepository.saveAndFlush(mapper.userDTOToUser(userDTO)));
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public boolean checkEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean checkUsername(String username) {
        if (userRepository.findByUsername(username) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean confirmSecretCode(String secretCode) {
        UserDTO userDTO = mapper.userToUserDTO(userRepository.findBySecretCode(secretCode));
        if (userDTO == null) { return false; }
        userDTO.setConfirmed(true);
        editUser(userDTO);
        return true;
    }
}
