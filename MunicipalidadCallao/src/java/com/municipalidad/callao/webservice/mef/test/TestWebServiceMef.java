package com.municipalidad.callao.webservice.mef.test;

public class TestWebServiceMef {

    public static void main(String[] args) {
    
        String datosMef = consultarDatosMeef("MAZDA", "MAZDA 3 SPORT GS HIGH 2.0 AT", "2016", "1");
        System.out.println("datosMef: " + datosMef);
        
    }

    private static String consultarDatosMeef(java.lang.String marca, java.lang.String modelo, java.lang.String anio, java.lang.String fabricacion) {
        com.municipalidad.callao.webservice.mef.test.Mef_Service service = new com.municipalidad.callao.webservice.mef.test.Mef_Service();
        com.municipalidad.callao.webservice.mef.test.Mef port = service.getMefPort();
        return port.consultarDatosMeef(marca, modelo, anio, fabricacion);
    }
    
}
