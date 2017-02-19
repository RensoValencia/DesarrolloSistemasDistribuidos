package com.orden.pe.entity;

import com.orden.pe.entity.Orden;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-16T18:36:53")
@StaticMetamodel(Pedidos.class)
public class Pedidos_ { 

    public static volatile SingularAttribute<Pedidos, Long> id;
    public static volatile SingularAttribute<Pedidos, Long> cantidad;
    public static volatile SingularAttribute<Pedidos, String> producto;
    public static volatile SingularAttribute<Pedidos, Orden> idOrden;

}