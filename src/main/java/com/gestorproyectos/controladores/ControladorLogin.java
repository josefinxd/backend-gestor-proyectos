package com.gestorproyectos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestorproyectos.entidades.Usuario;
import com.gestorproyectos.servicios.ServicioUsuario;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class ControladorLogin {
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@PostMapping
	public Usuario login(@RequestBody Usuario usuarioDTO){
		return servicioUsuario.login(usuarioDTO);
	}
}
