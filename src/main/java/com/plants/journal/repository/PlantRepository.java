package com.plants.journal.repository;

import com.plants.journal.domain.Plant;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlantRepository extends CrudRepository<Plant, UUID> {
}
