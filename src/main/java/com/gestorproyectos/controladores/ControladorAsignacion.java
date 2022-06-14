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

import com.gestorproyectos.entidades.Asignacion;
import com.gestorproyectos.servicios.ServicioAsignacion;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/asignacion")
public class ControladorAsignacion {
	
	@Autowired
	ServicioAsignacion servicioAsignacion;
	
	@GetMapping("/listar")
	public List<Asignacion> listar(){
		return servicioAsignacion.listar();
	}
	
	@PostMapping
	public Asignacion crear(@RequestBody Asignacion asignacionDTO){
		return servicioAsignacion.crear(asignacionDTO);
	}
	
	@GetMapping("/{id}")
	public Asignacion buscar(@PathVariable(value = "id") Integer id) {
		return servicioAsignacion.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Asignacion actualizar(@RequestBody Asignacion asignacionDTO, @PathVariable(value = "id") Long id){
		return servicioAsignacion.actualizar(asignacionDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Asignacion borrar( @PathVariable(value = "id") Long id){
		return servicioAsignacion.borrar(id);
	}
}
