package com.orden.pe.entity;

import com.orden.pe.entity.Pedidos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-16T18:36:53")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile SingularAttribute<Orden, Date> fecha;
    public static volatile SingularAttribute<Orden, Long> id;
    public static volatile ListAttribute<Orden, Pedidos> pedidosList;
    public static volatile SingularAttribute<Orden, String> nombre;

}