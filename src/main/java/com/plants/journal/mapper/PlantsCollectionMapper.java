package com.plants.journal.mapper;

import com.plants.journal.domain.PlantsCollection;
import com.plants.journal.dto.response.PlantsCollectionResponseDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PlantsCollectionMapper extends AbstractEntityMapper<PlantsCollectionResponseDTO, PlantsCollection> {

}
