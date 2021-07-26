package com.plants.journal.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EventDTOResponse {
    private UUID plantId;
    private String eventType;
    private long date;
    private String message;
}
