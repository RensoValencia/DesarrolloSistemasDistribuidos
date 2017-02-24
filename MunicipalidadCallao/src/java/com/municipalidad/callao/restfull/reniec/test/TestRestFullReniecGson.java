package com.municipalidad.callao.restfull.reniec.test;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestRestFullReniecGson {

    public static void main(String[] args) {
    
        try {
            DefaultHttpClient clientehttp = new DefaultHttpClient();
            String numeroDni = "43641173";
            String url = "http://localhost:8080/ReniecJson/webresources/consultarPorDniRest/" + numeroDni;
            
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = clientehttp.execute(get);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Error en la llamada al servicio de Reniec");
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            
            String salida = "";
            StringBuilder builder = new StringBuilder();
            while((salida = br.readLine()) != null) {
                builder.append(salida);
            }
            clientehttp.getConnectionManager().shutdown();
            
            Gson json = new Gson();
            Reniec reniec = json.fromJson(builder.toString(), Reniec.class);
            
            System.out.println("Obtener el json y devolverlo en objeto java");
            System.out.println("dni: " + reniec.getDni());
            System.out.println("nombre: " + reniec.getNombres());
            System.out.println("distrito: " + reniec.getDistrito());
            System.out.println("Direccion: " + reniec.getDomfis());
            
            System.out.println("*************************************");
            System.out.println("*************************************");
            
            Reniec reniec2 = new Reniec();
            reniec2.setDni("47911488");
            reniec2.setNombres("Renso Valencia");
            reniec2.setUbigeo("202124");
            reniec2.setDistrito("San miguel");
            reniec2.setDomfis("Av la paz");
            
            System.out.println("Obtener el objeto java y devolver en formato json");
            System.out.println("json: " + json.toJson(reniec2));
 
            
        }catch(Exception ex) {
            
        }
    }
    
}
