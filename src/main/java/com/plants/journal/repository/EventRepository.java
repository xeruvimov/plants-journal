package com.plants.journal.repository;

import com.plants.journal.domain.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {
}
