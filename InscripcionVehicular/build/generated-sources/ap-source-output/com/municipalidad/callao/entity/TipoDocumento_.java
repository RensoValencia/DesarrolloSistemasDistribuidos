package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.Contribuyente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(TipoDocumento.class)
public class TipoDocumento_ { 

    public static volatile SingularAttribute<TipoDocumento, String> descripcion;
    public static volatile ListAttribute<TipoDocumento, Contribuyente> contribuyenteList;
    public static volatile SingularAttribute<TipoDocumento, Long> id;

}