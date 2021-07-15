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
public class PlantService {
    private final PlantRepository repository;
    private final PlantMapper mapper;

    @Transactional
    @SneakyThrows
    public Plant findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No Plant with id: " + id));
    }

    @Transactional
    public List<PlantDTOResponse> findAll() {
        return mapper.toDto((Collection<Plant>) repository.findAll());
    }

    @Transactional
    public UUID create(String name,
                       String description) {
        Plant plant = new Plant(name, description);
        return repository.save(plant).getId();
    }

    @Transactional
    public UUID update(PlantDTOResponse plantDTOResponse) {
        Plant plant = repository.findById(plantDTOResponse.getId())
                .orElseThrow(() -> new IllegalStateException("No Plant with id: " + plantDTOResponse.getId()));

        plant.setName(plantDTOResponse.getName());
        plant.setDescription(plantDTOResponse.getDescription());

        return repository.save(plant).getId();
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
