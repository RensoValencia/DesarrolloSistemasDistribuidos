/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistema.reniec.pe;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author RENSO
 */
@WebService(serviceName = "consultarDatosPorDni")
public class consultarDatosPorDni {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "consultarDatosPorDni")
    public String hello(@WebParam(name = "dni") String txt) {
        return "Hello " + txt + " !";
    }
}
