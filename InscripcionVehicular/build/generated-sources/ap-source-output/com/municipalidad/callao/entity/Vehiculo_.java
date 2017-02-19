package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.CtaCte;
import com.municipalidad.callao.entity.Declaracion;
import com.municipalidad.callao.entity.Multas;
import com.municipalidad.callao.entity.TipoTransporte;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> descripcion;
    public static volatile ListAttribute<Vehiculo, CtaCte> ctaCteList;
    public static volatile SingularAttribute<Vehiculo, Date> anioFabricacion;
    public static volatile SingularAttribute<Vehiculo, BigDecimal> valorAdquisicion;
    public static volatile SingularAttribute<Vehiculo, String> categoria;
    public static volatile SingularAttribute<Vehiculo, Date> primeraFechaRegistroPublico;
    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile ListAttribute<Vehiculo, Declaracion> declaracionList;
    public static volatile SingularAttribute<Vehiculo, Long> id;
    public static volatile SingularAttribute<Vehiculo, Date> anioAdquisicion;
    public static volatile ListAttribute<Vehiculo, Multas> multasList;
    public static volatile SingularAttribute<Vehiculo, String> placa;
    public static volatile SingularAttribute<Vehiculo, TipoTransporte> tipoTransporteId;

}