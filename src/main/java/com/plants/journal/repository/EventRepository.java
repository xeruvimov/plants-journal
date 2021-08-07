package com.plants.journal.repository;

import com.plants.journal.domain.Event;
import com.plants.journal.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface EventRepository extends CrudRepository<Event, UUID> {
    List<Event> findAllByUser(User user);
}
