package com.plants.journal.controller;

import com.plants.journal.dto.EventDTORequest;
import com.plants.journal.dto.EventDTOResponse;
import com.plants.journal.service.EventService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/event")
@SecurityRequirement(name = "journalapi")
@PreAuthorize("hasAuthority('user')")
public class EventController {
    private final EventService service;

    @PostMapping(value = "/create")
    public UUID create(@RequestBody @Valid EventDTORequest dto) {
        log.debug("Create new Event: {}", dto);
        return service.create(dto);
    }

    @GetMapping("/{id}")
    public EventDTOResponse getById(@PathVariable UUID id) {
        log.debug("Get Event with id: {}", id);
        return service.findById(id);
    }

    @GetMapping("/list")
    public List<EventDTOResponse> getAll() {
        log.debug("Getting all Event");
        return service.findAll();
    }

    @PutMapping
    public UUID update(@RequestBody @Valid EventDTOResponse event) {
        log.debug("Update Event: {}", event);
        return service.update(event);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        log.debug("Delete Event with id: {}", id);
        service.delete(id);
    }
}
