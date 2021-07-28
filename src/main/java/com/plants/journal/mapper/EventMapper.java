package com.plants.journal.mapper;

import com.plants.journal.domain.Event;
import com.plants.journal.dto.EventDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface EventMapper extends AbstractEntityMapper<EventDTOResponse, Event> {
    @Mapping(target = "plantId", source = "event.plant.id")
    EventDTOResponse toDto(Event event);

    void updateEntity(EventDTOResponse dto, @MappingTarget Event event);
}
