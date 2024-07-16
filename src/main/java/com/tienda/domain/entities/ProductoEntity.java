package com.tienda.domain.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagenPath;
    private String descripcion;
    private double valor;
    private int stock;
}
