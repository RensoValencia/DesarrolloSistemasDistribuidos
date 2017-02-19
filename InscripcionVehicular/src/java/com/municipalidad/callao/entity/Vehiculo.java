package com.municipalidad.callao.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RENSO
 */
@Entity
@Table(name = "VEHICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findById", query = "SELECT v FROM Vehiculo v WHERE v.id = :id"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByMarca", query = "SELECT v FROM Vehiculo v WHERE v.marca = :marca"),
    @NamedQuery(name = "Vehiculo.findByAnioFabricacion", query = "SELECT v FROM Vehiculo v WHERE v.anioFabricacion = :anioFabricacion"),
    @NamedQuery(name = "Vehiculo.findByCategoria", query = "SELECT v FROM Vehiculo v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "Vehiculo.findByValorAdquisicion", query = "SELECT v FROM Vehiculo v WHERE v.valorAdquisicion = :valorAdquisicion"),
    @NamedQuery(name = "Vehiculo.findByAnioAdquisicion", query = "SELECT v FROM Vehiculo v WHERE v.anioAdquisicion = :anioAdquisicion"),
    @NamedQuery(name = "Vehiculo.findByPrimeraFechaRegistroPublico", query = "SELECT v FROM Vehiculo v WHERE v.primeraFechaRegistroPublico = :primeraFechaRegistroPublico"),
    @NamedQuery(name = "Vehiculo.findByDescripcion", query = "SELECT v FROM Vehiculo v WHERE v.descripcion = :descripcion")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PLACA")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "MARCA")
    private String marca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO_FABRICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anioFabricacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CATEGORIA")
    private String categoria;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR_ADQUISICION")
    private BigDecimal valorAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANIO_ADQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date anioAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIMERA_FECHA_REGISTRO_PUBLICO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date primeraFechaRegistroPublico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "TIPO_TRANSPORTE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoTransporte tipoTransporteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId", fetch = FetchType.LAZY)
    private List<Multas> multasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId", fetch = FetchType.LAZY)
    private List<Declaracion> declaracionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculoId", fetch = FetchType.LAZY)
    private List<CtaCte> ctaCteList;

    public Vehiculo() {
    }

    public Vehiculo(Long id) {
        this.id = id;
    }

    public Vehiculo(Long id, String placa, String marca, Date anioFabricacion, String categoria, BigDecimal valorAdquisicion, Date anioAdquisicion, Date primeraFechaRegistroPublico, String descripcion) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
        this.categoria = categoria;
        this.valorAdquisicion = valorAdquisicion;
        this.anioAdquisicion = anioAdquisicion;
        this.primeraFechaRegistroPublico = primeraFechaRegistroPublico;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Date anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorAdquisicion() {
        return valorAdquisicion;
    }

    public void setValorAdquisicion(BigDecimal valorAdquisicion) {
        this.valorAdquisicion = valorAdquisicion;
    }

    public Date getAnioAdquisicion() {
        return anioAdquisicion;
    }

    public void setAnioAdquisicion(Date anioAdquisicion) {
        this.anioAdquisicion = anioAdquisicion;
    }

    public Date getPrimeraFechaRegistroPublico() {
        return primeraFechaRegistroPublico;
    }

    public void setPrimeraFechaRegistroPublico(Date primeraFechaRegistroPublico) {
        this.primeraFechaRegistroPublico = primeraFechaRegistroPublico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoTransporte getTipoTransporteId() {
        return tipoTransporteId;
    }

    public void setTipoTransporteId(TipoTransporte tipoTransporteId) {
        this.tipoTransporteId = tipoTransporteId;
    }

    @XmlTransient
    public List<Multas> getMultasList() {
        return multasList;
    }

    public void setMultasList(List<Multas> multasList) {
        this.multasList = multasList;
    }

    @XmlTransient
    public List<Declaracion> getDeclaracionList() {
        return declaracionList;
    }

    public void setDeclaracionList(List<Declaracion> declaracionList) {
        this.declaracionList = declaracionList;
    }

    @XmlTransient
    public List<CtaCte> getCtaCteList() {
        return ctaCteList;
    }

    public void setCtaCteList(List<CtaCte> ctaCteList) {
        this.ctaCteList = ctaCteList;
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
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.municipalidad.callao.entity.Vehiculo[ id=" + id + " ]";
    }
    
}
