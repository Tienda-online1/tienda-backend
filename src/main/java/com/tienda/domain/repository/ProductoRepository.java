package com.tienda.domain.repository;

import com.tienda.domain.entities.ProductoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<ProductoEntity, Long> {
}
