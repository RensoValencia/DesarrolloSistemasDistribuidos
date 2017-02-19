/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mef.pe;

/**
 * Consultar: marca, modelo
 * Devuelve 
 * @author RENSO
 */
public class MefBean {

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

    /**
     * @return the t_ano
     */
    public String getT_ano() {
        return t_ano;
    }

    /**
     * @param t_ano the t_ano to set
     */
    public void setT_ano(String t_ano) {
        this.t_ano = t_ano;
    }

    /**
     * @return the t_codmar
     */
    public String getT_codmar() {
        return t_codmar;
    }

    /**
     * @param t_codmar the t_codmar to set
     */
    public void setT_codmar(String t_codmar) {
        this.t_codmar = t_codmar;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the t_tipmod
     */
    public String getT_tipmod() {
        return t_tipmod;
    }

    /**
     * @param t_tipmod the t_tipmod to set
     */
    public void setT_tipmod(String t_tipmod) {
        this.t_tipmod = t_tipmod;
    }

    /**
     * @return the m_model
     */
    public String getM_model() {
        return m_model;
    }

    /**
     * @param m_model the m_model to set
     */
    public void setM_model(String m_model) {
        this.m_model = m_model;
    }

    /**
     * @return the t_tegori
     */
    public String getT_tegori() {
        return t_tegori;
    }

    /**
     * @param t_tegori the t_tegori to set
     */
    public void setT_tegori(String t_tegori) {
        this.t_tegori = t_tegori;
    }

    /**
     * @return the m_cctrac
     */
    public String getM_cctrac() {
        return m_cctrac;
    }

    /**
     * @param m_cctrac the m_cctrac to set
     */
    public void setM_cctrac(String m_cctrac) {
        this.m_cctrac = m_cctrac;
    }

    /**
     * @return the t_ano1
     */
    public String getT_ano1() {
        return t_ano1;
    }

    /**
     * @param t_ano1 the t_ano1 to set
     */
    public void setT_ano1(String t_ano1) {
        this.t_ano1 = t_ano1;
    }

    /**
     * @return the t_ano2
     */
    public String getT_ano2() {
        return t_ano2;
    }

    /**
     * @param t_ano2 the t_ano2 to set
     */
    public void setT_ano2(String t_ano2) {
        this.t_ano2 = t_ano2;
    }

    /**
     * @return the t_ano3
     */
    public String getT_ano3() {
        return t_ano3;
    }

    /**
     * @param t_ano3 the t_ano3 to set
     */
    public void setT_ano3(String t_ano3) {
        this.t_ano3 = t_ano3;
    }
    
    @Override
    public String toString() {
         return t_ano+ " - " + t_codmar + " - " + marca + " - " + m_model + 
                 " - " + t_tegori + " - " + m_cctrac + " - " + t_ano1;
    
    
    }
    
}
