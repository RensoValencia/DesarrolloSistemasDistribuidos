package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.Vehiculo;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(TipoTransporte.class)
public class TipoTransporte_ { 

    public static volatile SingularAttribute<TipoTransporte, String> descripcion;
    public static volatile SingularAttribute<TipoTransporte, Long> id;
    public static volatile ListAttribute<TipoTransporte, Vehiculo> vehiculoList;

}