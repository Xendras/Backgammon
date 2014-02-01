/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;

/**
 *
 * @author jonas
 */
public class Pelaaja {

    char nappulanTyyppi;
    String nimi;
    Pelikokonaisuus peli;

    public Pelaaja(String nimi, char nappulanTyyppi, Pelikokonaisuus peli) {
        this.nappulanTyyppi = nappulanTyyppi;
        this.nimi = nimi;
        this.peli = peli;
    }

    public char haePelaajanTyyppi() {
        return this.nappulanTyyppi;
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
