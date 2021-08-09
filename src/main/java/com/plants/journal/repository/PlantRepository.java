package com.plants.journal.repository;

import com.plants.journal.domain.Plant;
import com.plants.journal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlantRepository extends JpaRepository<Plant, UUID> {
    List<Plant> findAllByUser(User user);
}
