package com.plants.journal.controller;

import com.plants.journal.dto.PlantDTORequest;
import com.plants.journal.dto.PlantDTOResponse;
import com.plants.journal.service.PlantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/plant")
public class PlanController {
    private final PlantService service;

    @PostMapping(value = "/create")
    public UUID create(@RequestBody @Valid PlantDTORequest plant) {
        log.debug("Create new RepairRequest: {}", plant);
        return service.create(
                plant.getName(),
                plant.getDescription());
    }

    @GetMapping("/{id}")
    public PlantDTOResponse getById(@PathVariable UUID id) {
        log.debug("Get Plant with id: {}", id);
        return service.findById(id);
    }

    @GetMapping("/list")
    public List<PlantDTOResponse> getAll() {
        log.debug("Getting all Plant");
        return service.findAll();
    }

    @PutMapping
    public UUID update(@RequestBody @Valid PlantDTOResponse plant) {
        log.debug("Update Plant: {}", plant);
        return service.update(plant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        log.debug("Delete Plant with id: {}", id);
        service.delete(id);
    }
}
