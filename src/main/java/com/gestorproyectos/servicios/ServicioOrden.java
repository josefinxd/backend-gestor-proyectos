package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Orden;
import com.gestorproyectos.repositorios.RepositorioOrden;

@Service
public class ServicioOrden {
	private static Logger logger = LoggerFactory.getLogger(ServicioOrden.class); 

	@Autowired
	RepositorioOrden repositorioOrden;
	
	public Orden crear(Orden ordenDTO){
		repositorioOrden.saveAndFlush(ordenDTO);
		logger.info("Ya lo guarde, id {}", ordenDTO.getIdorden());
		return ordenDTO;
	}
	
	public Orden actualizar(Orden ordenDTO, Long id){
		Orden orden = buscar(id);
		
		if (orden!=null) {
			orden.setFecha(ordenDTO.getFecha());
			orden.setIdcomprador(ordenDTO.getIdcomprador());
			orden.setIdvendedor(ordenDTO.getIdvendedor());
			orden.setTipo(ordenDTO.getTipo());
			orden.setTotal(ordenDTO.getTotal());
			repositorioOrden.save(orden);
			logger.info("Ya lo actualice, id {}", orden.getIdorden());
			return orden;
		}
		return null;
	}
	
	
	public Orden borrar(Long id){
		Orden orden = buscar(id);
		
		if (orden!=null) {
			repositorioOrden.delete(orden);
			logger.info("Ya lo borre, id {}", orden.getIdorden());
			return orden;
		}
		
		return null;
	}
	
	public Orden buscar (Long id ){
		Optional<Orden> result =  repositorioOrden.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Orden> listar(){
		return repositorioOrden.findAll();
	}

}
