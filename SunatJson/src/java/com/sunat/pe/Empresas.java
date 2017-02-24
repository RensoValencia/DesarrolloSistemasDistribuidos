/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunat.pe;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "empresas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresas.findAll", query = "SELECT e FROM Empresas e"),
    @NamedQuery(name = "Empresas.findByRuc", query = "SELECT e FROM Empresas e WHERE e.ruc = :ruc"),
    @NamedQuery(name = "Empresas.findByNombres", query = "SELECT e FROM Empresas e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empresas.findByUbigeo", query = "SELECT e FROM Empresas e WHERE e.ubigeo = :ubigeo"),
    @NamedQuery(name = "Empresas.findByDesdistri", query = "SELECT e FROM Empresas e WHERE e.desdistri = :desdistri"),
    @NamedQuery(name = "Empresas.findByDomfis", query = "SELECT e FROM Empresas e WHERE e.domfis = :domfis")})
public class Empresas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "ubigeo")
    private String ubigeo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "desdistri")
    private String desdistri;
    @Size(max = 200)
    @Column(name = "domfis")
    private String domfis;

    public Empresas() {
    }

    public Empresas(String ruc) {
        this.ruc = ruc;
    }

    public Empresas(String ruc, String nombres, String ubigeo, String desdistri) {
        this.ruc = ruc;
        this.nombres = nombres;
        this.ubigeo = ubigeo;
        this.desdistri = desdistri;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDesdistri() {
        return desdistri;
    }

    public void setDesdistri(String desdistri) {
        this.desdistri = desdistri;
    }

    public String getDomfis() {
        return domfis;
    }

    public void setDomfis(String domfis) {
        this.domfis = domfis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresas)) {
            return false;
        }
        Empresas other = (Empresas) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sunat.pe.Empresas[ ruc=" + ruc + " ]";
    }
    
}
