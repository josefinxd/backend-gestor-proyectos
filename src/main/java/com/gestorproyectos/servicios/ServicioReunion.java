package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Reunion;
import com.gestorproyectos.repositorios.RepositorioReunion;

@Service
public class ServicioReunion {
	private static Logger logger = LoggerFactory.getLogger(ServicioReunion.class); 

	@Autowired
	RepositorioReunion repositorioReunion;
	
	public Reunion crear(Reunion reunionDTO){
		repositorioReunion.saveAndFlush(reunionDTO);
		logger.info("Ya lo guarde, id {}", reunionDTO.getIdreunion());
		return reunionDTO;
	}
	
	public Reunion actualizar(Reunion reunionDTO, Long id){
		Reunion reunion = buscar(id);
		
		if (reunion!=null) {
			reunion.setFecha(reunionDTO.getFecha());
			reunion.setIdcliente(reunionDTO.getIdcliente());
			reunion.setIdusuario(reunionDTO.getIdusuario());
			repositorioReunion.save(reunion);
			logger.info("Ya lo actualice, id {}", reunion.getIdreunion());
			return reunion;
		}
		return null;
	}
	
	
	public Reunion borrar(Long id){
		Reunion reunion = buscar(id);
		
		if (reunion!=null) {
			repositorioReunion.delete(reunion);
			logger.info("Ya lo borre, id {}", reunion.getIdreunion());
			return reunion;
		}
		
		return null;
	}
	
	public Reunion buscar (Long id ){
		Optional<Reunion> result =  repositorioReunion.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Reunion> listar(){
		return repositorioReunion.findAll();
	}

}
