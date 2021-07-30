package com.plants.journal.repository;

import com.plants.journal.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {

    boolean existsByUsername(String email);

    Optional<User> findByUsername(String username);
}
