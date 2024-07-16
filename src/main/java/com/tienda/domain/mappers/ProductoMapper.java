package com.tienda.domain.mappers;

import com.tienda.domain.dtos.ProductoDto;
import com.tienda.domain.entities.ProductoEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

    ProductoDto productToDto(ProductoEntity productoEntity);
    ProductoEntity productoDtoToProducto(ProductoDto productoDto);
    List<ProductoDto> productosToDtos(List<ProductoEntity> productoEntities);
}
