package com.plants.journal.dto.request;

import com.plants.journal.domain.enums.EventType;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class EventDTORequest {
    @NotNull
    private UUID plantId;

    private long date;

    @NotNull
    private EventType eventType;
    private String message;
}
