package com.example.progettoinvernale;
import java.util.Random;
public class Biglietti {
    private Random r = new Random(1-12-4-9-2-11-6-7-3-10-5-8);
    protected Biglietto[] b;
    protected int capacitaStadium;
    protected int bigliettiComprati;
    public Biglietti(int l){
        b = new Biglietto[l];
        capacitaStadium=l;
        bigliettiComprati =r.nextInt(30000);
        for(int i = 0; i< bigliettiComprati; i++){
            b[i] = new Biglietto(29, i);
        }
    }
    public Biglietti(){
        b = new Biglietto[41507];
        capacitaStadium=41507;
        bigliettiComprati =r.nextInt(30000);
        for(int i = 0; i<capacitaStadium; i++){
            b[i] = new Biglietto(29, i);
        }
    }
    public Biglietto getBiglietto(int i){
        return b[i];
    }
    public String compraBiglietto(){
        b[bigliettiComprati] = new Biglietto(30, bigliettiComprati-1);
        String c=b[bigliettiComprati].codice;
        bigliettiComprati++;
        return c;
    }
    public int getBigliettiDisponibili(){
        return capacitaStadium-bigliettiComprati;
    }
    public int getBigliettiComprati(){
        return bigliettiComprati;
    }
}
