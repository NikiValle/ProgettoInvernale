package com.example.progettoinvernale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Stadio extends Thread{
    public static Random r = new Random(1-6-5-10-2-7-3-8-4-9);
    public static Biglietti biglietti = new Biglietti();
    public static PostiASedere[] posti = new PostiASedere[41507];
    public boolean cassa;
    public String name;
    public String nomeCassa;
    public static int bigliettiDisponibili;
    public int tempNum;
    public static int postiOccupati=0;
    public void set(boolean c, String n, String nC){
        cassa=c;
        name=n;
        nomeCassa=nC;
        for(int i=0;i<biglietti.capacitaStadium;i++){
            posti[i] = new PostiASedere(biglietti.getBiglietto(i).codice);
        }
    }
    public static void main(String[]args){
        Stadio ingressoNord = new Stadio();
        Stadio ingressoSud = new Stadio();
        Stadio ingressoEst = new Stadio();
        Stadio ingressoOvest = new Stadio();
        ingressoNord.set(true, "nord", "cassa nord");
        ingressoSud.set(true, "sud", "cassa sud");
        ingressoOvest.set(false, "ovest", "");
        ingressoEst.set(false, "est", "");
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
            TimeUnit.SECONDS.sleep((long) r.nextDouble(1));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (posti){
            tempNum=r.nextInt(biglietti.bigliettiComprati);
            if(!posti[tempNum].occupato){
                System.out.println("Un tifoso si è appena seduto al suo posto");
                postiOccupati++;
            }
            posti[tempNum].setOccupato(true);
        }
    }
    public void compraBiglietto(){
        try{
            TimeUnit.SECONDS.sleep(r.nextInt(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        biglietti.compraBiglietto();
        System.out.println("Un tifoso ha appena acquistato un biglietto alla "+nomeCassa);
        System.out.println("I biglietti disponibili per l'acquisto sono: "+biglietti.getBigliettiDisponibili());
    }
}
