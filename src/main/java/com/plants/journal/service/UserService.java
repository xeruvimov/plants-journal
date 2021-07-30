package com.plants.journal.service;

import com.plants.journal.domain.RoleConstant;
import com.plants.journal.domain.User;
import com.plants.journal.dto.UserDTO;
import com.plants.journal.mapper.UserMapper;
import com.plants.journal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public User registerNewUserAccount(UserDTO userDto) throws IllegalArgumentException {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new IllegalArgumentException("There is an account with that username: " + userDto.getUsername());
        }
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles(Collections.singleton(roleService.getByName(RoleConstant.USER_ROLE)));
        return userRepository.save(user);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
    }
}
