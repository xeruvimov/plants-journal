package com.plants.journal.service;

import com.plants.journal.domain.Plant;
import com.plants.journal.dto.PlantDTOResponse;
import com.plants.journal.mapper.PlantMapper;
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
public class PlantService {
    private final PlantRepository repository;
    private final PlantMapper mapper;

    @SneakyThrows
    public PlantDTOResponse findById(UUID id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + id)));
    }

    public List<PlantDTOResponse> findAll() {
        return mapper.toDto((Collection<Plant>) repository.findAll());
    }

    public UUID create(String name,
                       String description) {
        Plant plant = new Plant(name, description);
        return repository.save(plant).getId();
    }

    public UUID update(PlantDTOResponse plantDTOResponse) {
        Plant plant = repository.findById(plantDTOResponse.getId())
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + plantDTOResponse.getId()));

        mapper.updateEntity(plantDTOResponse, plant);

        return repository.save(plant).getId();
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
