package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Asignacion;

@Repository
public interface RepositorioAsignacion extends JpaRepository<Asignacion, Long> {

}
