package com.example.progettoinvernale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class Stadio extends Thread{
    public static Random r = new Random(1-6-5-10-2-7-3-8-4-9);
    public static Biglietti biglietti = new Biglietti();
    public static PostiASedere[] posti = new PostiASedere[41507];
    public boolean cassa;
    public String name;
    public static int bigliettiDisponibili;
    public int tempNum;
    public int coda;
    public int capacitaStadium=41507;
    public static int postiOccupati=0;
    public void set(boolean c, String n){
        Random r = new Random();
        cassa=c;
        name=n;
        coda=r.nextInt(2)+1;
        for(int i=0;i<biglietti.capacitaStadium;i++){
            posti[i] = new PostiASedere(biglietti.getBiglietto(i).codice);
        }
    }
    public static void main(String[]args){
        Stadio ingressoNord = new Stadio();
        Stadio ingressoSud = new Stadio();
        Stadio ingressoEst = new Stadio();
        Stadio ingressoOvest = new Stadio();
        Stadio cassaNord = new Stadio();
        Stadio cassaSud = new Stadio();
        ingressoNord.set(false, "ingresso nord");
        ingressoSud.set(false, "ingresso sud");
        ingressoOvest.set(false, "ingresso ovest" );
        ingressoEst.set(false, "ingresso est" );
        cassaSud.set(true,"cassa sud");
        cassaNord.set(true,"cassa nord");
        ingressoNord.start();
        ingressoSud.start();
        ingressoEst.start();
        ingressoOvest.start();
        cassaSud.start();
        cassaNord.start();
    }
    public void run(){
        do {
            if (cassa)
                compraBiglietto();
            if(!cassa)
                entraNelloStadio();
        }while(biglietti.bigliettiComprati!=capacitaStadium);
    }
    public void entraNelloStadio(){
        try{
            TimeUnit.MILLISECONDS.sleep(r.nextInt(1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (posti){
            tempNum=r.nextInt(biglietti.bigliettiComprati);
            if(!posti[tempNum].occupato){
                System.out.println("Un tifoso è appena entrato dall'ingresso "+name+" con biglietto con codice: "+posti[tempNum].codicePosto);
                postiOccupati++;
            }
            posti[tempNum].setOccupato(true);
        }
        incrementaCoda(r);
    }
    public void compraBiglietto(){
        incrementaCoda(r);
        try{
            TimeUnit.SECONDS.sleep(r.nextInt(5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Un tifoso ha appena acquistato un biglietto alla "+name+" con codice "+biglietti.compraBiglietto());
        coda--;
        System.out.println("I biglietti disponibili per l'acquisto sono: "+biglietti.getBigliettiDisponibili());
        System.out.println("La coda attuale alla "+name+" è di "+coda+" persone");
    }
    public void incrementaCoda(Random r){
        coda=coda+r.nextInt(3)+1;
    }
}
