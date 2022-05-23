package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Orden;

@Repository
public interface RepositorioOrden extends JpaRepository<Orden, Long> {

}
