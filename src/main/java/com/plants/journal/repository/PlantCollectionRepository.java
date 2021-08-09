package com.plants.journal.repository;

import com.plants.journal.domain.PlantsCollection;
import com.plants.journal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PlantCollectionRepository extends JpaRepository<PlantsCollection, UUID> {
    List<PlantsCollection> findAllByUser(User user);
}
