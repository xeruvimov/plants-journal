package com.plants.journal.service;

import com.plants.journal.domain.Event;
import com.plants.journal.domain.Plant;
import com.plants.journal.dto.EventDTORequest;
import com.plants.journal.dto.EventDTOResponse;
import com.plants.journal.mapper.EventMapper;
import com.plants.journal.repository.EventRepository;
import com.plants.journal.repository.PlantRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService implements CrudService<EventDTOResponse, EventDTORequest> {
    private final EventRepository repository;
    private final EventMapper mapper;
    private final PlantRepository plantRepository;


    @Override
    @SneakyThrows
    public EventDTOResponse findById(UUID id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Event with id: " + id)));
    }

    @Override
    public List<EventDTOResponse> findAll() {
        return mapper.toDto((Collection<Event>) repository.findAll());
    }

    @Override
    @SneakyThrows
    public UUID create(EventDTORequest dto) {
        Plant plant = plantRepository.findById(dto.getPlantId())
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + dto.getPlantId()));

        Event event = new Event(dto.getEventType(), dto.getDate(), dto.getMessage(), plant);
        return repository.save(event).getId();
    }

    @Override
    public UUID update(EventDTOResponse dto) {
        Event event = repository.findById(dto.getEventId())
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + dto.getEventId()));

        mapper.updateEntity(dto, event);

        return repository.save(event).getId();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
