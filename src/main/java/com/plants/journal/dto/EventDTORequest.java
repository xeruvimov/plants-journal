package com.plants.journal.dto;

import com.plants.journal.domain.enums.EventType;
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
    private EventType eventType;
    private String message;
}
