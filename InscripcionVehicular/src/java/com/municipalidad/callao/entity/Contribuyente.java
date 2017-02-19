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
    @NamedQuery(name = "Contribuyente.findByNumeroDocumento", query = "SELECT c FROM Contribuyente c WHERE c.numeroDocumento = :numeroDocumento"),
    @NamedQuery(name = "Contribuyente.findByApellidoPaterno", query = "SELECT c FROM Contribuyente c WHERE c.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Contribuyente.findByApellidoMaterno", query = "SELECT c FROM Contribuyente c WHERE c.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Contribuyente.findByNombres", query = "SELECT c FROM Contribuyente c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Contribuyente.findByRegimenId", query = "SELECT c FROM Contribuyente c WHERE c.regimenId = :regimenId")})
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
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "APELLIDO_PATERNO")
    private String apellidoPaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "APELLIDO_MATERNO")
    private String apellidoMaterno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "NOMBRES")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "REGIMEN_ID")
    private String regimenId;
    @JoinColumn(name = "TIPO_DOCUMENTO_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoDocumento tipoDocumentoId;

    public Contribuyente() {
    }

    public Contribuyente(Long id) {
        this.id = id;
    }

    public Contribuyente(Long id, String numeroDocumento, String apellidoPaterno, String apellidoMaterno, String nombres, String regimenId) {
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.nombres = nombres;
        this.regimenId = regimenId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(String regimenId) {
        this.regimenId = regimenId;
    }

    public TipoDocumento getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(TipoDocumento tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
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
