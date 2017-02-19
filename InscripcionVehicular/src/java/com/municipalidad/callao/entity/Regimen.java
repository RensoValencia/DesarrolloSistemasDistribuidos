package com.municipalidad.callao.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "REGIMEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regimen.findAll", query = "SELECT r FROM Regimen r"),
    @NamedQuery(name = "Regimen.findById", query = "SELECT r FROM Regimen r WHERE r.id = :id"),
    @NamedQuery(name = "Regimen.findByDescripcion", query = "SELECT r FROM Regimen r WHERE r.descripcion = :descripcion")})
public class Regimen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Regimen() {
    }

    public Regimen(Long id) {
        this.id = id;
    }

    public Regimen(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof Regimen)) {
            return false;
        }
        Regimen other = (Regimen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.municipalidad.callao.entity.Regimen[ id=" + id + " ]";
    }
    
}
