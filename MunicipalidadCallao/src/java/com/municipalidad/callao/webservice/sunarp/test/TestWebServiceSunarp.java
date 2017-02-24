package com.municipalidad.callao.webservice.sunarp.test;

public class TestWebServiceSunarp {

    public static void main(String[] args) {
    
        String datosSunarp = consultarSunarp("46320656", "F9G-363");
        System.out.println("datosSunarp: " + datosSunarp);
    }

    private static String consultarSunarp(java.lang.String numeroDocumento, java.lang.String placa) {
        com.municipalidad.callao.webservice.sunarp.test.SunarpWebService_Service service = new com.municipalidad.callao.webservice.sunarp.test.SunarpWebService_Service();
        com.municipalidad.callao.webservice.sunarp.test.SunarpWebService port = service.getSunarpWebServicePort();
        return port.consultarSunarp(numeroDocumento, placa);
    }
    
}
