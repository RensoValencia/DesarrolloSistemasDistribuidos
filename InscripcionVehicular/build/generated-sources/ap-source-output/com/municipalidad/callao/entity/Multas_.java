package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.Vehiculo;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(Multas.class)
public class Multas_ { 

    public static volatile SingularAttribute<Multas, String> motivo;
    public static volatile SingularAttribute<Multas, Vehiculo> vehiculoId;
    public static volatile SingularAttribute<Multas, Long> id;
    public static volatile SingularAttribute<Multas, BigDecimal> importe;

}