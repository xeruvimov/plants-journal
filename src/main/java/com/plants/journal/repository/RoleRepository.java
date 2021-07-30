package com.plants.journal.repository;

import com.plants.journal.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
    Role findByName(String name);
}
