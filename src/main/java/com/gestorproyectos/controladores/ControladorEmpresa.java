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

import com.gestorproyectos.dto.EmpresaDTO;
import com.gestorproyectos.entidades.Empresa;
import com.gestorproyectos.servicios.ServicioEmpresa;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/empresa")
public class ControladorEmpresa {
	
	@Autowired
	ServicioEmpresa servicioEmpresa;
	
	@GetMapping("/listar")
	public List<Empresa> listar(){
		return servicioEmpresa.listar();
	}
	
	@PostMapping
	public Empresa crear(@RequestBody Empresa empresaDTO){
		return servicioEmpresa.crear(empresaDTO);
	}
	
	@GetMapping("/{id}")
	public Empresa buscar(@PathVariable(value = "id") Integer id) {
		return servicioEmpresa.buscar(Long.valueOf(id));
	}
	
	@PutMapping ("/{id}")
	public Empresa actualizar(@RequestBody EmpresaDTO empresaDTO, @PathVariable(value = "id") Long id){
		return servicioEmpresa.actualizar(empresaDTO, id);
	}
	
	@DeleteMapping ("/{id}")
	public Empresa borrar( @PathVariable(value = "id") Long id){
		return servicioEmpresa.borrar(id);
	}
}
