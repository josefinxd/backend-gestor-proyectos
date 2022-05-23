package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Detalle;

@Repository
public interface RepositorioDetalle extends JpaRepository<Detalle, Long> {

}
