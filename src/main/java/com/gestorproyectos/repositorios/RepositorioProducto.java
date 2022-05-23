package com.gestorproyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestorproyectos.entidades.Producto;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long>{

}