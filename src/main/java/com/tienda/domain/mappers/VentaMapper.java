package com.tienda.domain.mappers;

import com.tienda.domain.dtos.VentaDto;
import com.tienda.domain.entities.VentaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VentaMapper {

    VentaEntity toEntity(VentaDto ventaDto);

    VentaDto toDto(VentaEntity ventaEntity);

    List<VentaDto> toDtos(List<VentaEntity> ventaEntity);
}
