package com.municipalidad.callao.entity;

import com.municipalidad.callao.entity.TipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-02-18T18:03:58")
@StaticMetamodel(Contribuyente.class)
public class Contribuyente_ { 

    public static volatile SingularAttribute<Contribuyente, String> apellidoPaterno;
    public static volatile SingularAttribute<Contribuyente, TipoDocumento> tipoDocumentoId;
    public static volatile SingularAttribute<Contribuyente, String> regimenId;
    public static volatile SingularAttribute<Contribuyente, Long> id;
    public static volatile SingularAttribute<Contribuyente, String> numeroDocumento;
    public static volatile SingularAttribute<Contribuyente, String> apellidoMaterno;
    public static volatile SingularAttribute<Contribuyente, String> nombres;

}