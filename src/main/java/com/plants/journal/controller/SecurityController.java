package com.plants.journal.controller;

import com.plants.journal.dto.UserDTO;
import com.plants.journal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/security")
public class SecurityController {
    private final UserService userService;

    @PostMapping("/registration")
    public String addUser(@RequestBody @Valid UserDTO user) {
        userService.registerNewUserAccount(user);
        return "nice cock, awsm balls";
    }
}
