package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Detalle;
import com.gestorproyectos.entidades.Orden;
import com.gestorproyectos.repositorios.RepositorioDetalle;

@Service
public class ServicioDetalle {
	private static Logger logger = LoggerFactory.getLogger(ServicioDetalle.class); 

	@Autowired
	RepositorioDetalle repositorioDetalle;
	
	@Autowired
	ServicioOrden servicioOrden;
	
	public Detalle crear(Detalle detalleDTO){
		repositorioDetalle.saveAndFlush(detalleDTO);
		logger.info("Ya lo guarde, id {}", detalleDTO.getIddetalle());
		return detalleDTO;
	}
	
	public Detalle actualizar(Detalle detalleDTO, Long id){
		Detalle detalle = buscar(id);
		
		if (detalle!=null) {
			detalle.setIdorden(detalleDTO.getIdorden());
			detalle.setCantidad(detalleDTO.getCantidad());
			detalle.setIdorden(detalleDTO.getIdorden());
			repositorioDetalle.save(detalle);
			logger.info("Ya lo actualice, id {}", detalle.getIddetalle());
			return detalle;
		}
		return null;
	}
	
	
	public Detalle borrar(Long id){
		Detalle detalle = buscar(id);
		
		if (detalle!=null) {
			repositorioDetalle.delete(detalle);
			logger.info("Ya lo borre, id {}", detalle.getIddetalle());
			return detalle;
		}
		
		return null;
	}
	
	public Detalle buscar (Long id ){
		Optional<Detalle> result =  repositorioDetalle.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Detalle> listar(){
		return repositorioDetalle.findAll();
	}
	
	public List<Detalle> listarByOrden(Orden idorden){
		logger.info("listarByOrden {} {}", idorden.getIdorden(), idorden.getFecha());
		logger.info("listarByOrden {}", servicioOrden.buscar(idorden.getIdorden()).getIdorden());
		return repositorioDetalle.findByOrden(idorden);
	}

}
