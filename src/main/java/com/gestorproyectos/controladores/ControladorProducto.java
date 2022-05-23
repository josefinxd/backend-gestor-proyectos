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

import com.gestorproyectos.entidades.Producto;
import com.gestorproyectos.servicios.ServicioProducto;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/producto")
public class ControladorProducto {
	
	@Autowired
	ServicioProducto servicioProducto;
	
	@GetMapping("/listar")
	public List<Producto> listar(){
		return servicioProducto.listar();
	}
	
	@PostMapping
	public Producto crear(@RequestBody Producto productoDTO){
		return servicioProducto.crear(productoDTO);
	}
	
	@GetMapping("/{id}")
	public Producto buscar(@PathVariable(value = "id") Integer id) {
		return servicioProducto.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Producto actualizar(@RequestBody Producto productoDTO, @PathVariable(value = "id") Long id){
		return servicioProducto.actualizar(productoDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Producto borrar( @PathVariable(value = "id") Long id){
		return servicioProducto.borrar(id);
	}
}
