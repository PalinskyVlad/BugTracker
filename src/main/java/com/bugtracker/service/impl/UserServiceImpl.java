package com.bugtracker.service.impl;

import com.bugtracker.dto.UserDTO;
import com.bugtracker.entity.User;
import com.bugtracker.entity.enums.UserRoleEnum;
import com.bugtracker.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import com.bugtracker.repository.UserRepository;
import com.bugtracker.service.UserService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ShaPasswordEncoder shaPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        userDTO.setRole(UserRoleEnum.USER);
        userDTO.setPassword(shaPasswordEncoder.encodePassword(userDTO.getPassword(), null));
        UserDTO savedUser = mapper.userToUserDTO(userRepository.saveAndFlush(mapper.userDTOToUser(userDTO)));

        return savedUser;
    }

    @Override
    public UserDTO getByUsername(String username) {
        return mapper.userToUserDTO(userRepository.findByUsername(username));
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
