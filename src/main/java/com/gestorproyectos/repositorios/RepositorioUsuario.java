package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{

}
