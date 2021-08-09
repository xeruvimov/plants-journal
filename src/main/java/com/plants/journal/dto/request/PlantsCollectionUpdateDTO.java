package com.plants.journal.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@Data
public class PlantsCollectionUpdateDTO {
    private UUID id;

    @NotEmpty
    private String title;
    private List<UUID> plants;
}
