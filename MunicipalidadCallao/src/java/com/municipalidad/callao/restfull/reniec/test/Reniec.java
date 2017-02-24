/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.municipalidad.callao.restfull.reniec.test;

import lombok.Data;

/**
 *
 * @author RENSO
 */
public @Data class Reniec {
    
    private String dni;
    private String nombres;
    private String ubigeo;
    private String distrito;
    private String domfis;
}
