package com.example.progettoinvernale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Stadio extends Thread{
    public static Random r = new Random(1-6-5-10-2-7-3-8-4-9);
    public static Biglietti biglietti = new Biglietti();
    public static PostiASedere[] posti;
    public boolean cassa;
    public String name;
    public void set(boolean c, String n){
        cassa=c;
        name=n;
    }
    public static void main(String[]args){
        for(int i=0;i<biglietti.capacitaStadium;i++){
            posti[i] = new PostiASedere(biglietti.getBiglietto(i).codice);
        }
        Stadio ingressoNord = new Stadio();
        Stadio ingressoSud = new Stadio();
        Stadio ingressoEst = new Stadio();
        Stadio ingressoOvest = new Stadio();
        ingressoNord.set(true, "nord");
        ingressoSud.set(true, "sud");
        ingressoOvest.set(false, "ovest");
        ingressoEst.set(false, "est");
        ingressoNord.start();
        ingressoSud.start();
        ingressoEst.start();
        ingressoOvest.start();
    }
    public void run(){
        do {
            if (cassa)
                compraBiglietto();
            entraNelloStadio();
        }while(biglietti.bigliettiComprati!=biglietti.capacitaStadium);
    }
    public void entraNelloStadio(){
        try{
            TimeUnit.SECONDS.sleep(r.nextDouble(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (posti){
            if(!posti[r.nextInt(biglietti.bigliettiComprati)].occupato){

            }
        }
    }
    public void compraBiglietto(){
        try{
            TimeUnit.SECONDS.sleep(r.nextInt(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        biglietti.compraBiglietto();
        System.out.println("Un tifoso ha appena acquistato un biglietto");
    }
}
