package com.plants.journal.service;

import com.plants.journal.domain.SecurityEntity;
import com.plants.journal.domain.User;
import com.plants.journal.exception.IllegalUserAccessException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityEntityService {
    private final UserService userService;

    @SneakyThrows
    public void securityCheck(String currentUserName, SecurityEntity entity) {
        User user = userService.getByUsername(currentUserName);
        if (!user.equals(entity.getUser())) {
            throw new IllegalUserAccessException("Сущность не принадлежит данному юзеру");
        }
    }
}
