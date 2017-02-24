/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.municipalidad.callao.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RENSO
 */
@Entity
@Table(name = "CONTRIBUYENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contribuyente.findAll", query = "SELECT c FROM Contribuyente c"),
    @NamedQuery(name = "Contribuyente.findById", query = "SELECT c FROM Contribuyente c WHERE c.id = :id"),
    @NamedQuery(name = "Contribuyente.findByUsuario", query = "SELECT c FROM Contribuyente c WHERE c.usuario = :usuario"),
    @NamedQuery(name = "Contribuyente.findByClave", query = "SELECT c FROM Contribuyente c WHERE c.clave = :clave"),
    @NamedQuery(name = "Contribuyente.findByNumeroDocumento", query = "SELECT c FROM Contribuyente c WHERE c.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Contribuyente.findByNombres", query = "SELECT c FROM Contribuyente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Contribuyente.findByDistrito", query = "SELECT c FROM Contribuyente c WHERE c.distrito = :distrito"),
    @NamedQuery(name = "Contribuyente.findByDireccion", query = "SELECT c FROM Contribuyente c WHERE c.direccion = :direccion")})
public class Contribuyente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DISTRITO")
    private String distrito;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "DIRECCION")
    private String direccion;
    @JoinColumn(name = "ID_REGIMEN", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Regimen idRegimen;
    @JoinColumn(name = "ID_TIPO_PERSONA", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoPersona idTipoPersona;

    public Contribuyente() {
    }

    public Contribuyente(Long id) {
        this.id = id;
    }

    public Contribuyente(Long id, String usuario, String clave, String numeroDocumento, String nombres, String distrito, String direccion) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.numeroDocumento = numeroDocumento;
        this.nombres = nombres;
        this.distrito = distrito;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Regimen getIdRegimen() {
        return idRegimen;
    }

    public void setIdRegimen(Regimen idRegimen) {
        this.idRegimen = idRegimen;
    }

    public TipoPersona getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(TipoPersona idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
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
        if (!(object instanceof Contribuyente)) {
            return false;
        }
        Contribuyente other = (Contribuyente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.municipalidad.callao.entity.Contribuyente[ id=" + id + " ]";
    }
    
}
