package com.sunarp.pe;
import lombok.Data;
/**
 *
 * @author RENSO
 */
public @Data class Sunarp {

    private String nrodoc;
    private String placa;
    private String porcent;
    private String marca;
    private String modelo;
    private String categoria;
    private String claseveh;
    private String anifabri;
    private String aniadqui;
    private String fecregpub;
    private String moneda;
    private String valadquis;
    private String tipocambio;
    private String valrealveh;
    private String provincia;
    
    @Override
    public String toString() {
        return nrodoc+ "|" + placa+ "|" + porcent+ "|" + marca+ "|" + modelo+ "|" + categoria+ "|" + claseveh+ "|" + anifabri+ "|" + aniadqui+ "|" + fecregpub+ "|" + moneda+ "|" + valadquis+ "|" + tipocambio+ "|" + valrealveh+ "|" + provincia;
    }
}
