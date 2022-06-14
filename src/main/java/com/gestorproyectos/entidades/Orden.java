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

@Entity
@Table(name = "orden")
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o"),
    @NamedQuery(name = "Orden.findByIdorden", query = "SELECT o FROM Orden o WHERE o.idorden = :idorden"),
    @NamedQuery(name = "Orden.findByFecha", query = "SELECT o FROM Orden o WHERE o.fecha = :fecha"),
    @NamedQuery(name = "Orden.findByTipo", query = "SELECT o FROM Orden o WHERE o.tipo = :tipo")})
public class Orden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idorden")
    private Long idorden;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @JoinColumn(name = "idcomprador", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idcomprador;
    @JoinColumn(name = "idvendedor", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idvendedor;
    @Basic(optional = false)
    @Column(name = "total")
    private Double total;

    public Long getIdorden() {
        return idorden;
    }

    public void setIdorden(Long idorden) {
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

    public Usuario getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(Usuario idcomprador) {
        this.idcomprador = idcomprador;
    }

    public Usuario getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Usuario idvendedor) {
        this.idvendedor = idvendedor;
    }
    
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
