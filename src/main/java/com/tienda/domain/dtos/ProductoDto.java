package com.tienda.domain.dtos;

import lombok.Data;

@Data
public class ProductoDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private double valor;
    private int stock;
    private String imagenPath;
}
