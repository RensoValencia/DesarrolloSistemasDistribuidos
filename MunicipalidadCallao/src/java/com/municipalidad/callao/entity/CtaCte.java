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
@Table(name = "CTA_CTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtaCte.findAll", query = "SELECT c FROM CtaCte c"),
    @NamedQuery(name = "CtaCte.findById", query = "SELECT c FROM CtaCte c WHERE c.id = :id"),
    @NamedQuery(name = "CtaCte.findByAnio", query = "SELECT c FROM CtaCte c WHERE c.anio = :anio"),
    @NamedQuery(name = "CtaCte.findByPeriodo", query = "SELECT c FROM CtaCte c WHERE c.periodo = :periodo"),
    @NamedQuery(name = "CtaCte.findByMontoInsoluto", query = "SELECT c FROM CtaCte c WHERE c.montoInsoluto = :montoInsoluto"),
    @NamedQuery(name = "CtaCte.findByGastoEmision", query = "SELECT c FROM CtaCte c WHERE c.gastoEmision = :gastoEmision"),
    @NamedQuery(name = "CtaCte.findByFactor", query = "SELECT c FROM CtaCte c WHERE c.factor = :factor"),
    @NamedQuery(name = "CtaCte.findByIntereses", query = "SELECT c FROM CtaCte c WHERE c.intereses = :intereses"),
    @NamedQuery(name = "CtaCte.findByEstado", query = "SELECT c FROM CtaCte c WHERE c.estado = :estado")})
public class CtaCte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERIODO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "MONTO_INSOLUTO")
    private BigDecimal montoInsoluto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GASTO_EMISION")
    private BigDecimal gastoEmision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "FACTOR")
    private String factor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTERESES")
    private BigDecimal intereses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "ID_RUBRO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rubro idRubro;
    @JoinColumn(name = "ID_VEHICULO", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;

    public CtaCte() {
    }

    public CtaCte(Long id) {
        this.id = id;
    }

    public CtaCte(Long id, Date anio, Date periodo, BigDecimal montoInsoluto, BigDecimal gastoEmision, String factor, BigDecimal intereses, String estado) {
        this.id = id;
        this.anio = anio;
        this.periodo = periodo;
        this.montoInsoluto = montoInsoluto;
        this.gastoEmision = gastoEmision;
        this.factor = factor;
        this.intereses = intereses;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAnio() {
        return anio;
    }

    public void setAnio(Date anio) {
        this.anio = anio;
    }

    public Date getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Date periodo) {
        this.periodo = periodo;
    }

    public BigDecimal getMontoInsoluto() {
        return montoInsoluto;
    }

    public void setMontoInsoluto(BigDecimal montoInsoluto) {
        this.montoInsoluto = montoInsoluto;
    }

    public BigDecimal getGastoEmision() {
        return gastoEmision;
    }

    public void setGastoEmision(BigDecimal gastoEmision) {
        this.gastoEmision = gastoEmision;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public BigDecimal getIntereses() {
        return intereses;
    }

    public void setIntereses(BigDecimal intereses) {
        this.intereses = intereses;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Rubro getIdRubro() {
        return idRubro;
    }

    public void setIdRubro(Rubro idRubro) {
        this.idRubro = idRubro;
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
        if (!(object instanceof CtaCte)) {
            return false;
        }
        CtaCte other = (CtaCte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.municipalidad.callao.entity.CtaCte[ id=" + id + " ]";
    }
    
}
