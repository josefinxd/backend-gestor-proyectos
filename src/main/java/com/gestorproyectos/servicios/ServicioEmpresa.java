package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.dto.EmpresaDTO;
import com.gestorproyectos.entidades.Empresa;
import com.gestorproyectos.repositorios.RepositorioEmpresa;

@Service
public class ServicioEmpresa {
	private static Logger logger = LoggerFactory.getLogger(ServicioEmpresa.class); 

	@Autowired
	RepositorioEmpresa repositorioEmpresa;
	
	public Empresa crear(Empresa empresaDTO){
		repositorioEmpresa.saveAndFlush(empresaDTO);
		logger.info("Ya lo guarde, id {}", empresaDTO.getIdempresa());
		return empresaDTO;
	}
	
	public Empresa actualizar(EmpresaDTO empresaDTO, Long id){
		Empresa empresa = buscar(id);
		
		if (empresa!=null) {
			empresa.setNombre(empresaDTO.getNombre());
			empresa.setDireccion(empresaDTO.getDireccion());
			empresa.setTipo(empresaDTO.getTipo());
			repositorioEmpresa.save(empresa);
			logger.info("Ya lo actualice, id {}", empresa.getIdempresa());
			return empresa;
		}
		return null;
	}
	
	
	public Empresa borrar(Long id){
		Empresa empresa = buscar(id);
		
		if (empresa!=null) {
			repositorioEmpresa.delete(empresa);
			logger.info("Ya lo borre, id {}", empresa.getIdempresa());
			return empresa;
		}
		
		return null;
	}
	
	public Empresa buscar (Long id ){
		Optional<Empresa> result =  repositorioEmpresa.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Empresa> listar(){
		return repositorioEmpresa.findAll();
	}

}
