package com.gestorproyectos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestorproyectos.entidades.Usuario;
import com.gestorproyectos.servicios.ServicioUsuario;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@GetMapping("/listar")
	public List<Usuario> listar(){
		return servicioUsuario.listar();
	}
	
	@PostMapping
	public Usuario crear(@RequestBody Usuario usuarioDTO){
		return servicioUsuario.crear(usuarioDTO);
	}
	
	@GetMapping("/{id}")
	public Usuario buscar(@PathVariable(value = "id") Integer id) {
		return servicioUsuario.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Usuario actualizar(@RequestBody Usuario usuarioDTO, @PathVariable(value = "id") Long id){
		return servicioUsuario.actualizar(usuarioDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Usuario borrar( @PathVariable(value = "id") Long id){
		return servicioUsuario.borrar(id);
	}
}
