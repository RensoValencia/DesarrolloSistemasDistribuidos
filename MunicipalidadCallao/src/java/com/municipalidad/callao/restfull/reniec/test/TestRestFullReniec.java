package com.municipalidad.callao.restfull.reniec.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestRestFullReniec {

    public static void main(String[] args) {
        
        try {
        
            DefaultHttpClient clientehttp = new DefaultHttpClient();
            
            HttpGet get = new HttpGet("http://localhost:8080/ReniecJson/webresources/consultarPorDniRest/08850218");
            
            HttpResponse response = clientehttp.execute(get);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Error en la llamada al servicio");
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            
            String salida = "";
            while((salida = br.readLine()) != null) {
                System.out.println("salida -> " + salida);
            }
            clientehttp.getConnectionManager().shutdown();
        }catch(Exception ex) {
            
        }
    }
    
}
