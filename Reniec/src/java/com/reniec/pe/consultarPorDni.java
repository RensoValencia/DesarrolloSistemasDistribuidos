package com.reniec.pe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 *
 * @author RENSO
 */
@WebService(serviceName = "consultarPorDni")
public class consultarPorDni {

    @WebMethod(operationName = "consultarPorDni")
    public String consultarPorDni(@WebParam(name = "dni") String dni) {
        
        String respuesta = "No éxiste el dni";
        
        try {
            for(Persona persona: muestraContenido("E:\\reniec.csv")) {
                if(persona.getDni().equals(dni)) {
                    respuesta = persona.getNombres()+"|" + persona.getDistrito() + "|" + persona.getDomfis();
                    break;
                }
            }            
        }catch(Exception ex) {
            System.out.println("Error en la consulta: " + ex.getMessage());
        }
        return respuesta;
    }
    
    private static List<Persona> muestraContenido(String archivo)throws Exception {
        String cadena;
        List<Persona> listaPersona = new ArrayList<>();
        
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        try {
            while((cadena = b.readLine())!=null) {
                Persona persona = new Persona();
                String dividir[] = cadena.split("\\|");
                persona.setDni(dividir[0]);
                persona.setNombres(dividir[1]);
                persona.setUbigeo(dividir[2]);
                persona.setDistrito(dividir[3]);
                
                try {
                    persona.setDomfis(dividir[4]);
                }catch(ArrayIndexOutOfBoundsException a) {
                    persona.setDomfis("Sin Direccion");
                }
                
                listaPersona.add(persona);   
            }
        }catch(Exception ex) {
            System.out.println("Error al leer datos: " + ex.getMessage());
        }
        b.close();
        System.out.println("listaPersona: " + listaPersona.size());
        return listaPersona;
    }
}