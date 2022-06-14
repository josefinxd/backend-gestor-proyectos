package com.gestorproyectos.servicios;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestorproyectos.entidades.Usuario;
import com.gestorproyectos.repositorios.RepositorioUsuario;

@Service
public class ServicioUsuario {
	private static Logger logger = LoggerFactory.getLogger(ServicioUsuario.class); 

	@Autowired
	RepositorioUsuario repositorioUsuario;
	
	public Usuario crear(Usuario usuarioDTO){
		Usuario usuario= new Usuario();
		usuario.setUsuario(usuarioDTO.getUsuario());
		usuario.setCorreo(usuarioDTO.getCorreo());
		usuario.setNombres(usuarioDTO.getNombres());
		usuario.setApellidos(usuarioDTO.getApellidos());
		usuario.setDireccion(usuarioDTO.getDireccion());
		usuario.setCiudad(usuarioDTO.getCiudad());
		usuario.setMunicipio(usuarioDTO.getMunicipio());
		usuario.setCelular(usuarioDTO.getCelular());
		usuario.setPassword(usuarioDTO.getPassword());
		repositorioUsuario.saveAndFlush(usuario);
		logger.info("Ya lo guarde, id {}", usuario.getIdusuario());
		return usuario;
	}
	
	public Usuario actualizar(Usuario usuarioDTO, Long id){
		Usuario usuario = buscar(id);
		
		if (usuario!=null) {
			usuario.setUsuario(usuarioDTO.getUsuario());
			usuario.setCorreo(usuarioDTO.getCorreo());
			usuario.setNombres(usuarioDTO.getNombres());
			usuario.setApellidos(usuarioDTO.getApellidos());
			usuario.setDireccion(usuarioDTO.getDireccion());
			usuario.setCiudad(usuarioDTO.getCiudad());
			usuario.setMunicipio(usuarioDTO.getMunicipio());
			usuario.setCelular(usuarioDTO.getCelular());
			usuario.setPassword(usuarioDTO.getPassword());
			repositorioUsuario.save(usuario);
			logger.info("Ya lo actualice, id {}", usuario.getIdusuario());
			return usuario;
		}
		return null;
	}
	
	
	public Usuario borrar(Long id){
		Usuario usuario = buscar(id);
		
		if (usuario!=null) {
			repositorioUsuario.delete(usuario);
			logger.info("Ya lo borre, id {}", usuario.getIdusuario());
			return usuario;
		}
		
		return null;
	}
	
	public Usuario buscar (Long id ){
		Optional<Usuario> result =  repositorioUsuario.findById(id);
		
		if (result.isPresent())
			return result.get();
		
		logger.error("No EXISTE id {}", id);
		return null;
	}
	
	public List<Usuario> listar(){
		return repositorioUsuario.findAll();
	}
	
	public Usuario login (Usuario usuarioDTO ){
		Usuario result =  repositorioUsuario.findByUser(usuarioDTO.getUsuario());
		
		if (result != null) {
			logger.info("result {}", result.getPassword());
			logger.info("usuario {}", usuarioDTO.getPassword());
			if(result.getPassword().equals(usuarioDTO.getPassword()))
				return result;
			return null;
		}
			
		
		logger.error("No EXISTE usuario {}", usuarioDTO.getUsuario());
		return null;
	}

}
