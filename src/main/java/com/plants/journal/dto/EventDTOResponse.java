package com.plants.journal.dto;

import com.plants.journal.domain.enums.EventType;
import lombok.Data;

import java.util.UUID;

@Data
public class EventDTOResponse {
    private UUID id;
    private UUID plantId;
    private EventType eventType;
    private long date;
    private String message;
}
