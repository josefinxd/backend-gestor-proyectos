package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Usuario;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long>{
	
	@Query(value="SELECT d.* FROM usuario d WHERE d.usuario = :usuario", nativeQuery=true)
	public Usuario findByUser(@Param("usuario") String usuario);
}
