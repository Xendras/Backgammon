/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Pelaaja-olio joka simuloi oikean pelaajan toimintoja.
 * @author Jonas Westerlund
 */
public class Pelaaja {

    char nappulanTyyppi;
    String nimi;
    Pelikokonaisuus peli;
    HashMap<Integer, Pelinappula> nappulat;
    Pelaaja vastustaja;
    boolean jaahylla;
    ArrayList<Pelinappula> jaahy;
    ArrayList<Pelinappula> koti;

    /**
     * Luo Pelaaja-olion jolla on nimi, nappulan tyyppi, peli johon pelaaja kuuluu, sekä nappulakokoelma joka kuuluu pelaajalle.
     * @param nimi Käyttäjän antama nimi.
     * @param nappulanTyyppi Käyttäjän antama nappulatyyppi.
     * @param peli Peli johon pelaaja kuuluu.
     * @param nappulat Nappulat jotka kuuluvat pelaajalle
     * @param jaahy Pelaajalle kuuluva jäähylauta.
     * @param koti Pelaajalle kuuluva kotilauta.
     */
    public Pelaaja(String nimi, char nappulanTyyppi, Pelikokonaisuus peli, HashMap<Integer, Pelinappula> nappulat, ArrayList<Pelinappula> jaahy, ArrayList<Pelinappula> koti) {
        this.nappulanTyyppi = nappulanTyyppi;
        this.nimi = nimi;
        this.peli = peli;
        this.nappulat = nappulat;
        this.vastustaja = null;
        this.jaahy = jaahy;
        this.koti = koti;
        this.jaahylla = false;
    }

    public ArrayList<Pelinappula> haePelaajanJaahy(){
        return this.jaahy;
    }
    public ArrayList<Pelinappula> haePelaajanKoti(){
        return this.koti;
    }
    
    /**
     * Tarkistaa onko pelaajalla nappuloita jäähyllä (siis keskellä lautaa)
     * @return Kertoo onko pelaajan jaahy tyhjä vai ei.
     */
    public boolean onkoPelaajaJaahylla(){
        return !peli.haePelilauta().onkoPelaajanJaahyTyhja(this);
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
    
    /**
     * Kutsuu pelikokonaisuuden pelinappulan siirtoa.
     * @param sijainti Missä siirrettävä nappula on.
     * @param siirtoja Montako siirtoa nappulaa siirretään.
     */
    public void siirraPelinappulaa(int sijainti, int siirtoja){
        this.peli.siirraPelinappulaa(sijainti, siirtoja);
    }
}
