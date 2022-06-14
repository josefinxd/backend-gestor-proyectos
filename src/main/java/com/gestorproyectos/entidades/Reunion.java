package com.gestorproyectos.entidades;

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

@Entity
@Table(name = "reunion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reunion.findAll", query = "SELECT r FROM Reunion r"),
    @NamedQuery(name = "Reunion.findByIdreunion", query = "SELECT r FROM Reunion r WHERE r.idreunion = :idreunion"),
    @NamedQuery(name = "Reunion.findByFecha", query = "SELECT r FROM Reunion r WHERE r.fecha = :fecha")})
public class Reunion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreunion")
    private Long idreunion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idcliente", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idcliente;

    public Long getIdreunion() {
        return idreunion;
    }

    public void setIdreunion(Long idreunion) {
        this.idreunion = idreunion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Usuario idcliente) {
        this.idcliente = idcliente;
    }
    
}
