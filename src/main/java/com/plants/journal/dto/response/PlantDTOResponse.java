package com.plants.journal.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class PlantDTOResponse {
    private UUID id;
    private String name;
    private String description;
}
