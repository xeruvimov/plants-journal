package com.plants.journal.controller;

import com.plants.journal.dto.PlantDTORequest;
import com.plants.journal.dto.PlantDTOResponse;
import com.plants.journal.service.PlantService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/plant")
@SecurityRequirement(name = "journalapi")
@PreAuthorize("hasAuthority('user')")
public class PlantController {
    private final PlantService service;

    @PostMapping(value = "/create")
    public UUID create(@RequestBody @Valid PlantDTORequest plant, Principal principal) {
        log.debug("Create new Plant: {}", plant);
        return service.create(plant, principal.getName());
    }

    @GetMapping("/{id}")
    public PlantDTOResponse getById(@PathVariable UUID id, Principal principal) {
        log.debug("Get Plant with id: {}", id);
        return service.findById(id, principal.getName());
    }

    @GetMapping("/list")
    public List<PlantDTOResponse> getAll(Principal principal) {
        log.debug("Getting all Plant");
        return service.findAll(principal.getName());
    }

    @PutMapping
    public UUID update(@RequestBody @Valid PlantDTOResponse plant, Principal principal) {
        log.debug("Update Plant: {}", plant);
        return service.update(plant, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id, Principal principal) {
        log.debug("Delete Plant with id: {}", id);
        service.delete(id, principal.getName());
    }
}
