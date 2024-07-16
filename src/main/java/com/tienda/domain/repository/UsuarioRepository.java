package com.tienda.domain.repository;

import com.tienda.domain.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    Optional<UsuarioEntity> findByUsername(String username);
}
