package com.example.progettoinvernale;

public class Biglietto {
    protected double costo;
    protected String codice;
    public Biglietto(){
        costo=30;
    }
    public Biglietto(double c, int code){
        costo=c;
        codice=createCodice(code);
    }
    private String createCodice(int comprato){
        return "J"+comprato;
    }
}
