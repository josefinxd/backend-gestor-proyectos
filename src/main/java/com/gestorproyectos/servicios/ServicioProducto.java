package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Producto;
import com.gestorproyectos.repositorios.RepositorioProducto;

@Service
public class ServicioProducto {
	private static Logger logger = LoggerFactory.getLogger(ServicioProducto.class); 

	@Autowired
	RepositorioProducto repositorioProducto;
	
	public Producto crear(Producto productoDTO){
		repositorioProducto.saveAndFlush(productoDTO);
		logger.info("Ya lo guarde, id {}", productoDTO.getIdproducto());
		return productoDTO;
	}
	
	public Producto actualizar(Producto productoDTO, Long id){
		Producto producto = buscar(id);
		
		if (producto!=null) {
			producto.setNombre(productoDTO.getNombre());
			producto.setCantidad(productoDTO.getCantidad());
			producto.setPrecio(productoDTO.getPrecio());
			producto.setIdempresa(productoDTO.getIdempresa());
			repositorioProducto.save(producto);
			logger.info("Ya lo actualice, id {}", producto.getIdproducto());
			return producto;
		}
		return null;
	}
	
	
	public Producto borrar(Long id){
		Producto producto = buscar(id);
		
		if (producto!=null) {
			repositorioProducto.delete(producto);
			logger.info("Ya lo borre, id {}", producto.getIdproducto());
			return producto;
		}
		
		return null;
	}
	
	public Producto buscar (Long id ){
		Optional<Producto> result =  repositorioProducto.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Producto> listar(){
		return repositorioProducto.findAll();
	}

}
