package com.plants.journal.controller;

import com.plants.journal.dto.request.PlantsCollectionRequestDTO;
import com.plants.journal.dto.request.PlantsCollectionUpdateDTO;
import com.plants.journal.dto.response.PlantsCollectionResponseDTO;
import com.plants.journal.service.PlantsCollectionService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/plants-collection")
@SecurityRequirement(name = "journalapi")
@PreAuthorize("hasAuthority('ROLE_USER')")
public class PlantsCollectionController {
    private final PlantsCollectionService service;

    @PostMapping("/create")
    public UUID create(@RequestBody @Valid PlantsCollectionRequestDTO dto, Principal principal) {
        log.debug("Create new PlantsCollection: {}", dto);
        return service.create(dto, principal.getName());
    }

    @GetMapping("/{id}")
    public PlantsCollectionResponseDTO getById(@PathVariable UUID id, Principal principal) {
        log.debug("Get PlantsCollection by id: {}", id);
        return service.findById(id, principal.getName());
    }

    @GetMapping("/list")
    public List<PlantsCollectionResponseDTO> getAll(Principal principal) {
        log.debug("Get all PlantsCollection");
        return service.findAll(principal.getName());
    }

    @PutMapping
    public UUID update(@RequestBody @Valid PlantsCollectionUpdateDTO dto, Principal principal) {
        log.debug("Update PlantsCollection: {}", dto);
        return service.update(dto, principal.getName());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id, Principal principal) {
        log.debug("Delete PlantsCollection with id: {}", id);
        service.delete(id, principal.getName());
    }
}
