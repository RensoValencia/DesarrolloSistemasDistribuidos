package com.mef.pe;

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
@WebService(serviceName = "Mef")
public class Mef {

    @WebMethod(operationName = "consultarDatosMeef")
    public String consultarDatosMeef(@WebParam(name = "marca") String marca, 
            @WebParam(name = "modelo") String modelo, @WebParam(name = "anio") String anio, 
            @WebParam(name = "fabricacion") String fabricacion) {
        
        String monto = "No existe la informacion";
        try {
            for(MefBean bean: muestraContenido("E:\\auto17.CSV")) {
                if(bean.getMarca().equals(marca) && bean.getM_model().equals(modelo)
                       && bean.getT_ano().equals(anio)) {
                    if(fabricacion.equals("1")) {
                        monto = bean.getT_ano1();
                    } else if(fabricacion.equals("2")) {
                        monto = bean.getT_ano2();
                    } else {
                        monto = bean.getT_ano3();
                    }
                    break;
                }
            }            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return monto;
    }
    
    private static List<MefBean> muestraContenido(String archivo )throws FileNotFoundException, IOException {
        String cadena;
        List<MefBean> listaMef = new ArrayList<>();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            MefBean mefBean = new MefBean();
            String dividir[] = cadena.split(",");
            mefBean.setT_ano(dividir[0]);
            mefBean.setT_codmar(dividir[1]);
            mefBean.setMarca(dividir[2]);
            mefBean.setT_tipmod(dividir[3]);
            mefBean.setM_model(dividir[4]);
            mefBean.setT_tegori(dividir[5]);
            mefBean.setM_cctrac(dividir[6]);
            mefBean.setT_ano1(dividir[7]);
            mefBean.setT_ano2(dividir[8]);
            mefBean.setT_ano3(dividir[9]);
            listaMef.add(mefBean);
            
        }
        b.close();
        return listaMef;
    }
}
