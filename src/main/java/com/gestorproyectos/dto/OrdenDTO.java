/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestorproyectos.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jose_
 */

public class OrdenDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idorden")
    private Integer idorden;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idcomprador", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private UsuarioDTO idcomprador;
    @JoinColumn(name = "idvendedor", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private UsuarioDTO idvendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorden")
    private Collection<DetalleDTO> detalleCollection;

    public OrdenDTO() {
    }

    public OrdenDTO(Integer idorden) {
        this.idorden = idorden;
    }

    public OrdenDTO(Integer idorden, Date fecha, String tipo) {
        this.idorden = idorden;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public UsuarioDTO getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(UsuarioDTO idcomprador) {
        this.idcomprador = idcomprador;
    }

    public UsuarioDTO getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(UsuarioDTO idvendedor) {
        this.idvendedor = idvendedor;
    }

    @XmlTransient
    public Collection<DetalleDTO> getDetalleCollection() {
        return detalleCollection;
    }

    public void setDetalleCollection(Collection<DetalleDTO> detalleCollection) {
        this.detalleCollection = detalleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorden != null ? idorden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDTO)) {
            return false;
        }
        OrdenDTO other = (OrdenDTO) object;
        if ((this.idorden == null && other.idorden != null) || (this.idorden != null && !this.idorden.equals(other.idorden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestorproyectos.entidades.Orden[ idorden=" + idorden + " ]";
    }
    
}
