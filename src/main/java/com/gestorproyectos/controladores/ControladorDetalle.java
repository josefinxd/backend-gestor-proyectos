package com.gestorproyectos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestorproyectos.entidades.Detalle;
import com.gestorproyectos.entidades.Orden;
import com.gestorproyectos.servicios.ServicioDetalle;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/detalle")
public class ControladorDetalle {
	
	@Autowired
	ServicioDetalle servicioDetalle;
	
	@GetMapping("/listar")
	public List<Detalle> listar(){
		return servicioDetalle.listar();
	}
	
	@PostMapping
	public Detalle crear(@RequestBody Detalle detalleDTO){
		return servicioDetalle.crear(detalleDTO);
	}
	
	@GetMapping("/{id}")
	public Detalle buscar(@PathVariable(value = "id") Integer id) {
		return servicioDetalle.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Detalle actualizar(@RequestBody Detalle detalleDTO, @PathVariable(value = "id") Long id){
		return servicioDetalle.actualizar(detalleDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Detalle borrar( @PathVariable(value = "id") Long id){
		return servicioDetalle.borrar(id);
	}
	
	@PostMapping("/listarByOrden")
	public List<Detalle> listarByOrden(@RequestBody Orden ordenDTO){
		System.out.println(ordenDTO);
		return servicioDetalle.listarByOrden(ordenDTO);
	}
}
