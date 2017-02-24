package com.municipalidad.callao.restfull.sunat.test;

import com.google.gson.Gson;
import com.municipalidad.callao.restfull.reniec.test.Reniec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author RENSO
 */
public class TestRestFullSunatGson {

    public static void main(String[] args) {
    
        try {
            DefaultHttpClient clientehttp = new DefaultHttpClient();
            String numeroRuc = "20502437021";
            String url = "http://localhost:8080/SunatJson/webresources/consultarPorRucRest/" + numeroRuc;
            
            HttpGet get = new HttpGet(url);
            
            HttpResponse response = clientehttp.execute(get);
            if(response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Error en la llamada al servicio de Sunat");
            }
            
            BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            
            String salida = "";
            StringBuilder builder = new StringBuilder();
            while((salida = br.readLine()) != null) {
                builder.append(salida);
            }
            clientehttp.getConnectionManager().shutdown();
            
            Gson json = new Gson();
            Sunat sunat = json.fromJson(builder.toString(), Sunat.class);
            
            System.out.println("Obtener el json y devolverlo en objeto java");
            System.out.println("RUC: " + sunat.getRuc());
            System.out.println("nombre: " + sunat.getNombres());
            System.out.println("distrito: " + sunat.getDesdistri());
            System.out.println("Direccion: " + sunat.getDomfis());
            
            System.out.println("*************************************");
            System.out.println("*************************************");
            
            Sunat sunat2 = new Sunat();
            sunat2.setRuc("2012345678");
            sunat2.setNombres("Avatar s.a.c");
            sunat2.setUbigeo("102030");
            sunat2.setDesdistri("San Isidro");
            sunat2.setDomfis("Av javier prado");
            
            System.out.println("Obtener el objeto java y devolver en formato json");
            System.out.println("json: " + json.toJson(sunat2));
 
            
        }catch(Exception ex) {
            
        }
    }
    
}
