package com.plants.journal.dto.response;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PlantsCollectionResponseDTO {
    private UUID id;
    private String title;
    private List<PlantDTOResponse> plants;
}
