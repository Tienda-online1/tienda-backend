package com.tienda.domain.mappers;

import com.tienda.domain.dtos.UserRequestDto;
import com.tienda.domain.entities.UsuarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioEntity dtoToUserEntity(UserRequestDto userRequestDto);
}
