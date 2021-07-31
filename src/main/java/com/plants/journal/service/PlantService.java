package com.plants.journal.service;

import com.plants.journal.domain.Plant;
import com.plants.journal.domain.User;
import com.plants.journal.dto.PlantDTORequest;
import com.plants.journal.dto.PlantDTOResponse;
import com.plants.journal.mapper.PlantMapper;
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
public class PlantService implements CrudSecurityService<PlantDTOResponse, PlantDTORequest> {
    private final SecurityEntityService securityEntityService;
    private final PlantRepository repository;
    private final PlantMapper mapper;
    private final UserService userService;

    @SneakyThrows
    public PlantDTOResponse findById(UUID id, String userName) {
        Plant plant = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + id));
        securityEntityService.securityCheck(userName, plant);
        return mapper.toDto(plant);
    }

    public List<PlantDTOResponse> findAll(String userName) {
        User user = userService.getByUsername(userName);
        return mapper.toDto(repository.findAllByUser(user));
    }

    public UUID create(PlantDTORequest dto, String userName) {
        Plant plant = new Plant(dto.getName(), dto.getDescription());
        plant.setUser(userService.getByUsername(userName));
        return repository.save(plant).getId();
    }

    public UUID update(PlantDTOResponse plantDTOResponse, String userName) {
        Plant plant = repository.findById(plantDTOResponse.getId())
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + plantDTOResponse.getId()));
        securityEntityService.securityCheck(userName, plant);
        mapper.updateEntity(plantDTOResponse, plant);

        return repository.save(plant).getId();
    }

    @SneakyThrows
    public void delete(UUID id, String userName) {
        Plant plant = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + id));
        securityEntityService.securityCheck(userName, plant);
        repository.deleteById(id);
    }
}
