package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.Rubro;
import com.municipalidad.callao.entity.Vehiculo;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(CtaCte.class)
public class CtaCte_ { 

    public static volatile SingularAttribute<CtaCte, Rubro> rubroId;
    public static volatile SingularAttribute<CtaCte, String> estado;
    public static volatile SingularAttribute<CtaCte, BigDecimal> montoInsoluto;
    public static volatile SingularAttribute<CtaCte, Date> periodo;
    public static volatile SingularAttribute<CtaCte, Vehiculo> vehiculoId;
    public static volatile SingularAttribute<CtaCte, Long> id;
    public static volatile SingularAttribute<CtaCte, String> factor;
    public static volatile SingularAttribute<CtaCte, BigDecimal> gastoEmision;
    public static volatile SingularAttribute<CtaCte, BigDecimal> intereses;
    public static volatile SingularAttribute<CtaCte, Date> anio;

}