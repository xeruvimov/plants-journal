package com.plants.journal.mapper;

import com.plants.journal.domain.Event;
import com.plants.journal.dto.EventDTOResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper extends AbstractEntityMapper<EventDTOResponse, Event> {
}
