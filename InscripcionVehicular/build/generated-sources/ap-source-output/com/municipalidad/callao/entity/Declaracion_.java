package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.Vehiculo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(Declaracion.class)
public class Declaracion_ { 

    public static volatile SingularAttribute<Declaracion, String> motivo;
    public static volatile SingularAttribute<Declaracion, Date> anioDeclaracion;
    public static volatile SingularAttribute<Declaracion, Vehiculo> vehiculoId;
    public static volatile SingularAttribute<Declaracion, BigDecimal> impuestoAnual;
    public static volatile SingularAttribute<Declaracion, Long> id;

}