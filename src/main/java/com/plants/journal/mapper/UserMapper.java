package com.plants.journal.mapper;

import com.plants.journal.domain.User;
import com.plants.journal.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends AbstractEntityMapper<UserDTO, User> {
}
