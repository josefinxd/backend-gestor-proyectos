package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Reunion;

@Repository
public interface RepositorioReunion extends JpaRepository<Reunion, Long> {

}
