package com.gestorproyectos.dto;

/**
 *
 * @author jose_
 */

public class EmpresaDTO  {

   
    private Integer idempresa;    
    private String nombre;    
    private String direccion;    
    private String tipo;   

    public EmpresaDTO() {
    }

    public Integer getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Integer idempresa) {
        this.idempresa = idempresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

       
}
