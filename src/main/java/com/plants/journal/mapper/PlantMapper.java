package com.plants.journal.mapper;

import com.plants.journal.domain.Plant;
import com.plants.journal.dto.PlantDTOResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlantMapper extends AbstractEntityMapper<PlantDTOResponse, Plant> {
}
