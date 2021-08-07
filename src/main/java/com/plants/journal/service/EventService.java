package com.plants.journal.service;

import com.plants.journal.domain.Event;
import com.plants.journal.domain.Plant;
import com.plants.journal.domain.User;
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
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class EventService implements CrudSecurityService<EventDTOResponse, EventDTORequest> {
    private final SecurityEntityService securityEntityService;
    private final EventRepository repository;
    private final EventMapper mapper;
    private final PlantRepository plantRepository;
    private final UserService userService;


    @Override
    @SneakyThrows
    public EventDTOResponse findById(UUID id, String userName) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Event with id: " + id));
        securityEntityService.securityCheck(userName, event);
        return mapper.toDto(event);
    }

    @Override
    public List<EventDTOResponse> findAll(String userName) {
        User user = userService.getByUsername(userName);
        return mapper.toDto(repository.findAllByUser(user));
    }

    @Override
    @SneakyThrows
    public UUID create(EventDTORequest dto, String userName) {
        Plant plant = plantRepository.findById(dto.getPlantId())
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + dto.getPlantId()));

        Event event = new Event(dto.getEventType(), dto.getDate(), dto.getMessage(), plant, userService.getByUsername(userName));
        return repository.save(event).getId();
    }

    @Override
    public UUID update(EventDTOResponse dto, String userName) {
        Event event = repository.findById(dto.getId())
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + dto.getId()));

        securityEntityService.securityCheck(userName, event);
        mapper.updateEntity(dto, event);

        return repository.save(event).getId();
    }

    @Override
    public void delete(UUID id, String userName) {
        Event event = repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + id));
        securityEntityService.securityCheck(userName, event);
        repository.deleteById(id);
    }
}
