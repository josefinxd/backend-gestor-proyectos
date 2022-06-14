package com.gestorproyectos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Detalle;
import com.gestorproyectos.entidades.Orden;

@Repository
public interface RepositorioDetalle extends JpaRepository<Detalle, Long> {
	
	@Query(value="SELECT d.* FROM detalle d WHERE d.idorden = :idorden", nativeQuery=true)
	public List<Detalle> findByOrden(@Param("idorden") Orden idorden);
}
