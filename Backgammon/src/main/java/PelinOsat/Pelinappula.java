package PelinOsat;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelilauta;

public class Pelinappula {

    int sijainti;
    Pelilauta pelilauta;
    Pelaaja omistaja;

    public Pelinappula(int sijainti, Pelaaja omistaja, Pelilauta pelilauta) {
        this.sijainti = sijainti;
        this.omistaja = omistaja;
        this.pelilauta = pelilauta;
    }

    
    public void asetaPelinappulanSijainti(int sijainti){
        this.sijainti = sijainti;
    }
    
    public int haePelinappulanSijainti(){
        return this.sijainti;
    }
    
    public Pelaaja haePelinappulanOmistaja(){
        return this.omistaja;
    }
    
    public void asetaPelinappulanOmistaja(Pelaaja omistaja){
        this.omistaja = omistaja;
    }
    
    public Pelilauta haePelinappulanPelilauta(){
        return this.pelilauta;
    }
}
