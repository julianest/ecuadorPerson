package com.ecuadorPrueba.ecuador.domains.repositories;

import com.ecuadorPrueba.ecuador.domains.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByIdentificacion(String identificacion);
    Optional<Cliente> findByNombre(String nombre);
    Optional<Cliente> findById(Long id);
    boolean existsByIdentificacion(String identificacion);
    boolean existsById(Long id);
}