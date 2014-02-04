/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import java.util.HashMap;

/**
 *
 * @author jonas
 */
public class Pelaaja {

    char nappulanTyyppi;
    String nimi;
    Pelikokonaisuus peli;
    HashMap<Integer, Pelinappula> nappulat;
    Pelaaja vastustaja;

    public Pelaaja(String nimi, char nappulanTyyppi, Pelikokonaisuus peli, HashMap<Integer, Pelinappula> nappulat) {
        this.nappulanTyyppi = nappulanTyyppi;
        this.nimi = nimi;
        this.peli = peli;
        this.nappulat = nappulat;
        this.vastustaja = null;
    }

    public char haePelaajanTyyppi() {
        return this.nappulanTyyppi;
    }
    
    public void asetaVastustaja(Pelaaja pelaaja){
        this.vastustaja = pelaaja;
    }
    
    public Pelaaja haeVastustaja(){
        return this.vastustaja;
    }
    
    public HashMap<Integer, Pelinappula> haePelaajanNappulat(){
        return this.nappulat;
    }
    
    public void asetaPelaajanTyyppi(char x){
        this.nappulanTyyppi = x;
    }
    
    public void asetaPelaajanNimi(String nimi){
        this.nimi = nimi;
    }
    
    public String haePelaajanNimi(){
        return this.nimi;
    }
    
    public void siirraPelinappulaa(int sijainti, int siirtoja){
        this.peli.siirraPelinappulaa(sijainti, siirtoja);
    }
}
