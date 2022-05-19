/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestorproyectos.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose_
 */

public class ReunionDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreunion")
    private Integer idreunion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private UsuarioDTO idusuario;
    @JoinColumn(name = "idcliente", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private UsuarioDTO idcliente;

    public ReunionDTO() {
    }

    public ReunionDTO(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public ReunionDTO(Integer idreunion, Date fecha) {
        this.idreunion = idreunion;
        this.fecha = fecha;
    }

    public Integer getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Integer idreunion) {
        this.idreunion = idreunion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(UsuarioDTO idusuario) {
        this.idusuario = idusuario;
    }

    public UsuarioDTO getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(UsuarioDTO idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreunion != null ? idreunion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReunionDTO)) {
            return false;
        }
        ReunionDTO other = (ReunionDTO) object;
        if ((this.idreunion == null && other.idreunion != null) || (this.idreunion != null && !this.idreunion.equals(other.idreunion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestorproyectos.entidades.Reunion[ idreunion=" + idreunion + " ]";
    }
    
}
