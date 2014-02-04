package PelinOsat;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelilauta;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelinappula {

    int sijainti;
    Pelikokonaisuus peli;
    Pelaaja omistaja;

    public Pelinappula(Pelaaja omistaja, Pelikokonaisuus peli) {
        this.sijainti = -1;
        this.omistaja = omistaja;
        this.peli = peli;
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
    
    public HashMap<Integer,ArrayList<Pelinappula>> haePelinappulanPelilauta(){
        return this.peli.haePelilaudanNappulat();
    }
}
