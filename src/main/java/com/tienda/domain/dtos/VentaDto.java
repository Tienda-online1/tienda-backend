package com.tienda.domain.dtos;

import com.tienda.domain.entities.ProductoEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class VentaDto {
    private LocalDateTime fecha;
    private List<ProductoDto> productos;
    private double total;
}
