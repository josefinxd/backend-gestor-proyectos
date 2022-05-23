package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Asignacion;
import com.gestorproyectos.repositorios.RepositorioAsignacion;

@Service
public class ServicioAsignacion {
	private static Logger logger = LoggerFactory.getLogger(ServicioAsignacion.class); 

	@Autowired
	RepositorioAsignacion repositorioAsignacion;
	
	public Asignacion crear(Asignacion asignacionDTO){
		repositorioAsignacion.saveAndFlush(asignacionDTO);
		logger.info("Ya lo guarde, id {}", asignacionDTO.getIdasignacion());
		return asignacionDTO;
	}
	
	public Asignacion actualizar(Asignacion asignacionDTO, Long id){
		Asignacion asignacion = buscar(id);
		
		if (asignacion!=null) {
			asignacion.setRol(asignacionDTO.getRol());
			asignacion.setIdempresa(asignacionDTO.getIdempresa());
			asignacion.setIdusuario(asignacionDTO.getIdusuario());
			repositorioAsignacion.save(asignacion);
			logger.info("Ya lo actualice, id {}", asignacion.getIdasignacion());
			return asignacion;
		}
		return null;
	}
	
	
	public Asignacion borrar(Long id){
		Asignacion asignacion = buscar(id);
		
		if (asignacion!=null) {
			repositorioAsignacion.delete(asignacion);
			logger.info("Ya lo borre, id {}", asignacion.getIdasignacion());
			return asignacion;
		}
		
		return null;
	}
	
	public Asignacion buscar (Long id ){
		Optional<Asignacion> result =  repositorioAsignacion.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Asignacion> listar(){
		return repositorioAsignacion.findAll();
	}

}
