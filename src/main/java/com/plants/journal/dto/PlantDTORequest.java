package com.plants.journal.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PlantDTORequest {
    @NotEmpty
    private String name;
    private String description;
}
