/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reniec.pe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarPorDni")
    public String consultarPorDni(@WebParam(name = "dni") String dni) {
        
        String persona = "No existe la persona";
        try {
            for(Persona bean: muestraContenido("E:\\RENI17.CSV")) {
                if(bean.getDni().equals(dni)) {
                    persona = bean.getNombres() + " - " + bean.getApaterno() + " - " + bean.getAmaterno();
                }
            }            
        }catch(Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return persona;
    }
    
    private static List<Persona> muestraContenido(String archivo )throws FileNotFoundException, IOException {
        String cadena;
        List<Persona> listaPersona = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            Persona persona = new Persona();
            String dividir[] = cadena.split(",");
            persona.setDni(dividir[0]);
            persona.setIdubigeo(dividir[1]);
            persona.setApaterno(dividir[2]);
            persona.setAmaterno(dividir[3]);
            persona.setNombres(dividir[4]);
            persona.setFecnac(dividir[5]);
            persona.setSexo(dividir[6]);
            persona.setDepartamen(dividir[7]);
            persona.setProvincia(dividir[8]);
            persona.setDistrito(dividir[9]);
            listaPersona.add(persona);
            
        }
        b.close();
        return listaPersona;
    }
}
