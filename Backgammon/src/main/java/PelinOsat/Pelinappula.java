package PelinOsat;

import PelinKayttajat.Pelaaja;

public class Pelinappula {

    int sijainti;
    Pelaaja omistaja;
    

    public Pelinappula(int sijainti, Pelaaja omistaja) {
        this.sijainti = sijainti;
        this.omistaja = omistaja;
    }
    
    public void siirraPelinappulaa(int siirtoja){
        if(this.omistaja.haePelaajanVari() == 1){
        this.sijainti += siirtoja;
        } else if(this.omistaja.haePelaajanVari() == 2){
            this.sijainti -= siirtoja;
        }
    }
}
