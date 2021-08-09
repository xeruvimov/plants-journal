package com.plants.journal.service;

import com.plants.journal.domain.PlantsCollection;
import com.plants.journal.domain.User;
import com.plants.journal.dto.request.PlantsCollectionRequestDTO;
import com.plants.journal.dto.request.PlantsCollectionUpdateDTO;
import com.plants.journal.dto.response.PlantsCollectionResponseDTO;
import com.plants.journal.mapper.PlantsCollectionMapper;
import com.plants.journal.repository.PlantCollectionRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class PlantsCollectionService {
    private final SecurityEntityService securityEntityService;
    private final PlantCollectionRepository repository;
    private final PlantService plantService;
    private final UserService userService;
    private final PlantsCollectionMapper mapper;

    @SneakyThrows
    public PlantsCollectionResponseDTO findById(UUID id, String userName) {
        PlantsCollection plantsCollection = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + id));
        securityEntityService.securityCheck(userName, plantsCollection);
        return mapper.toDto(plantsCollection);
    }

    public List<PlantsCollectionResponseDTO> findAll(String userName) {
        User user = userService.getByUsername(userName);
        return mapper.toDto(repository.findAllByUser(user));
    }

    public UUID create(PlantsCollectionRequestDTO dto, String userName) {
        PlantsCollection collection = new PlantsCollection();

        collection.setTitle(dto.getTitle());
        collection.setUser(userService.getByUsername(userName));
        collection.setPlants(plantService.getAllById(dto.getPlants()));

        return repository.save(collection).getId();
    }

    @SneakyThrows
    public UUID update(PlantsCollectionUpdateDTO dto, String userName) {
        PlantsCollection collection = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + dto.getId()));
        securityEntityService.securityCheck(userName, collection);
        collection.setTitle(dto.getTitle());
        collection.setPlants(plantService.getAllById(dto.getPlants()));
        return repository.save(collection).getId();
    }

    @SneakyThrows
    public void delete(UUID id, String userName) {
        PlantsCollection collection = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No Plant with id: " + id));
        securityEntityService.securityCheck(userName, collection);
        repository.delete(collection);
    }
}
