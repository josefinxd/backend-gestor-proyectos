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

import com.gestorproyectos.entidades.Reunion;
import com.gestorproyectos.servicios.ServicioReunion;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/reunion")
public class ControladorReunion {
	
	@Autowired
	ServicioReunion servicioReunion;
	
	@GetMapping("/listar")
	public List<Reunion> listar(){
		return servicioReunion.listar();
	}
	
	@PostMapping
	public Reunion crear(@RequestBody Reunion reunionDTO){
		return servicioReunion.crear(reunionDTO);
	}
	
	@GetMapping("/{id}")
	public Reunion buscar(@PathVariable(value = "id") Integer id) {
		return servicioReunion.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Reunion actualizar(@RequestBody Reunion reunionDTO, @PathVariable(value = "id") Long id){
		return servicioReunion.actualizar(reunionDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Reunion borrar( @PathVariable(value = "id") Long id){
		return servicioReunion.borrar(id);
	}
}
