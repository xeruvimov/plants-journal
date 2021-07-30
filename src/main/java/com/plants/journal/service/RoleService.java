package com.plants.journal.service;

import com.plants.journal.domain.Role;
import com.plants.journal.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    @Transactional
    public Role getByName(String name) {
        return repository.findByName(name);
    }
}
