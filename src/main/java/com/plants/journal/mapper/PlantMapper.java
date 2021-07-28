package com.plants.journal.mapper;

import com.plants.journal.domain.Event;
import com.plants.journal.domain.Plant;
import com.plants.journal.dto.EventDTOResponse;
import com.plants.journal.dto.PlantDTOResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PlantMapper extends AbstractEntityMapper<PlantDTOResponse, Plant> {
    EventDTOResponse toDto(Event event);

    @Mapping(target = "id", ignore = true)
    void updateEntity(PlantDTOResponse plantDTOResponse, @MappingTarget Plant plant);
}
