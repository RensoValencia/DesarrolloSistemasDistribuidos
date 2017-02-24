/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mef.pe;

import lombok.Data;

/**
 * Consultar: marca, modelo
 * Devuelve 
 * @author RENSO
 */
public @Data class MefBean {

    private String t_ano;
    private String t_codmar;
    private String marca;
    private String t_tipmod;
    private String m_model;
    private String t_tegori;
    private String m_cctrac;
    private String t_ano1;
    private String t_ano2;
    private String t_ano3;
    
    @Override
    public String toString() {
         return t_ano+ "|" + t_codmar + "|" + marca + "|" + m_model + 
                 "|" + t_tegori + "|" + m_cctrac + "|" + t_ano1;
    }
    
}
