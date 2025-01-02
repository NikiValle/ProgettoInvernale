package com.example.progettoinvernale;

public class PostiASedere {
    protected boolean occupato;
    protected String codicePosto;
    public PostiASedere(String c){
        codicePosto=c;
        occupato=false;
    }
    public String getCodicePosto(){
        return codicePosto;
    }
    public void setOccupato(boolean b){
        occupato=b;
    }
}
