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

import com.gestorproyectos.entidades.Orden;
import com.gestorproyectos.servicios.ServicioOrden;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/orden")
public class ControladorOrden {
	
	@Autowired
	ServicioOrden servicioOrden;
	
	@GetMapping("/listar")
	public List<Orden> listar(){
		return servicioOrden.listar();
	}
	
	@PostMapping
	public Orden crear(@RequestBody Orden ordenDTO){
		return servicioOrden.crear(ordenDTO);
	}
	
	@GetMapping("/{id}")
	public Orden buscar(@PathVariable(value = "id") Integer id) {
		return servicioOrden.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Orden actualizar(@RequestBody Orden ordenDTO, @PathVariable(value = "id") Long id){
		return servicioOrden.actualizar(ordenDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Orden borrar( @PathVariable(value = "id") Long id){
		return servicioOrden.borrar(id);
	}
}
