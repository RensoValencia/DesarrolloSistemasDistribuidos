package com.sunarp.pe;

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
 * @author RENSO
 */
@WebService(serviceName = "SunarpWebService")
public class SunarpWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarSunarp")
    public String consultarSunarp(@WebParam(name = "numeroDocumento") String numeroDocumento,
            @WebParam(name = "placa")String placa) {
        
        String informacion = "No existe la informacion";
        try {
            for(Sunarp sunarp: muestraContenido("E:\\sunarp.csv")) {
                System.out.println("sunarp: " + sunarp);
                if(sunarp.getPlaca().equals(placa) && sunarp.getNrodoc().equals(numeroDocumento)) {
                    informacion = sunarp.toString();
                    break;
                }
            }            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return informacion;
    }
    
    private static List<Sunarp> muestraContenido(String archivo )throws FileNotFoundException, IOException {
        String cadena;
        List<Sunarp> listaSunarp = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        try {
            int numero = 0;
        while((cadena = b.readLine())!=null) {
            Sunarp sunarp = new Sunarp();
            String dividir[] = cadena.split("\\|");
            sunarp.setNrodoc(dividir[0]);
            sunarp.setPlaca(dividir[1]);
            sunarp.setPorcent(dividir[2]);
            sunarp.setMarca(dividir[3]);
            sunarp.setModelo(dividir[4]);
            sunarp.setCategoria(dividir[5]);
            sunarp.setClaseveh(dividir[6]);
            sunarp.setAnifabri(dividir[7]);
            sunarp.setAniadqui(dividir[8]);
            sunarp.setFecregpub(dividir[9]);
            sunarp.setMoneda(dividir[10]);
            sunarp.setValadquis(dividir[11]);
            sunarp.setTipocambio(dividir[12]);
            sunarp.setValrealveh(dividir[13]);
            sunarp.setProvincia(dividir[14]);
            listaSunarp.add(sunarp);
        }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        b.close();
        return listaSunarp;
    }
}
