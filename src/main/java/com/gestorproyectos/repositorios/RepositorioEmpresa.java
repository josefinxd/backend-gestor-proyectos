package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Empresa;

@Repository
public interface RepositorioEmpresa extends JpaRepository<Empresa, Long> {

}
