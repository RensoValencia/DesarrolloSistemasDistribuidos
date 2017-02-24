/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.municipalidad.callao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RENSO
 */
@Entity
@Table(name = "DECLARACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Declaracion.findAll", query = "SELECT d FROM Declaracion d"),
    @NamedQuery(name = "Declaracion.findById", query = "SELECT d FROM Declaracion d WHERE d.id = :id"),
    @NamedQuery(name = "Declaracion.findByAnioDeclaracion", query = "SELECT d FROM Declaracion d WHERE d.anioDeclaracion = :anioDeclaracion"),
    @NamedQuery(name = "Declaracion.findByMotivo", query = "SELECT d FROM Declaracion d WHERE d.motivo = :motivo"),
    @NamedQuery(name = "Declaracion.findByImpuestoAnual", query = "SELECT d FROM Declaracion d WHERE d.impuestoAnual = :impuestoAnual")})
public class Declaracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO_DECLARACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anioDeclaracion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MOTIVO")
    private String motivo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "IMPUESTO_ANUAL")
    private BigDecimal impuestoAnual;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;

    public Declaracion() {
    }

    public Declaracion(Long id) {
        this.id = id;
    }

    public Declaracion(Long id, Date anioDeclaracion, String motivo, BigDecimal impuestoAnual) {
        this.id = id;
        this.anioDeclaracion = anioDeclaracion;
        this.motivo = motivo;
        this.impuestoAnual = impuestoAnual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnioDeclaracion() {
        return anioDeclaracion;
    }

    public void setAnioDeclaracion(Date anioDeclaracion) {
        this.anioDeclaracion = anioDeclaracion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public BigDecimal getImpuestoAnual() {
        return impuestoAnual;
    }

    public void setImpuestoAnual(BigDecimal impuestoAnual) {
        this.impuestoAnual = impuestoAnual;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Declaracion)) {
            return false;
        }
        Declaracion other = (Declaracion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.municipalidad.callao.entity.Declaracion[ id=" + id + " ]";
    }
    
}
