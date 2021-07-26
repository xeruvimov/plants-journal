package com.plants.journal.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Data
public class EventDTORequest {
    @NotEmpty
    private UUID plantId;

    @NotEmpty
    private long date;

    @NotEmpty
    private String eventType;
    private String message;
}
