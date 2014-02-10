/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka kerää kaikki pelin osat yhteen kokonaisuuteen joka hallinnoi eri osia.
 * @author Jonas Westerlund
 */
public class Pelikokonaisuus { 
    Noppa noppa1;
    Noppa noppa2;
    Pelilauta pelilauta;
    HashMap<Integer, Pelinappula> nappulat1;
    HashMap<Integer, Pelinappula> nappulat2;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Pelaaja vuorossa;
    ArrayList<Pelinappula> jaahy1;
    ArrayList<Pelinappula> jaahy2;
    ArrayList<Pelinappula> koti1;
    ArrayList<Pelinappula> koti2;
    
    
    /**
     * Luo pelikokonaisuuden joka sisältää kaksi noppaa, yhden pelilaudan, kaksi rykelmää pelinappuloita, kaksi pelaajaa, sekä vuorossa olevan pelaajan jäähy ja kotilaudat
     */
    public Pelikokonaisuus(){
        this.noppa1 = new Noppa();
        this.noppa2 = new Noppa();
        this.pelilauta = new Pelilauta(this);
        this.nappulat1 = new HashMap<Integer,Pelinappula>();
        this.nappulat2 = new HashMap<Integer,Pelinappula>();
        this.jaahy1 = new ArrayList<Pelinappula>();
        this.jaahy2 = new ArrayList<Pelinappula>();
        this.koti1 = new ArrayList<Pelinappula>();
        this.koti2 = new ArrayList<Pelinappula>();
        this.pelaaja1 = null;
        this.pelaaja2 = null;
        this.vuorossa = pelaaja1;
        
    }
    
    /**
     * Hakee pelilaudan nappulat, eli siis HashMapin
     * @return Palauttaa HashMapin jossa on sijainnit yhidstettynä pelinappulalistoihin
     */
    public HashMap<Integer, ArrayList<Pelinappula>> haePelilaudanNappulat(){
        return this.pelilauta.haePelilauta();
    }
    
    /**
     * Hakee pelilaudan, eli siis luokkaolion joka sisältää pelinappulaHashMapin
     * @return Palauttaa pelilaudan
     */
    public Pelilauta haePelilauta(){
        return this.pelilauta;
    }
    
    public ArrayList<Pelinappula> haePelaajan1Jaahy(){
        return this.jaahy1;
    }
    public ArrayList<Pelinappula> haePelaajan2Jaahy(){
        return this.jaahy2;
    }
    public ArrayList<Pelinappula> haePelaajan1Koti(){
        return this.koti1;
    }
    public ArrayList<Pelinappula> haePelaajan2Koti(){
        return this.koti2;
    }
    
    public Pelaaja haePelaajaVuorossa(){
        return vuorossa;
    }
    
    public void asetaPelaajaVuorossa(Pelaaja pelaaja){
        this.vuorossa = pelaaja;
    }
    
    public HashMap<Integer, Pelinappula> haePelaaja1Nappulat(){
        return this.nappulat1;
    }
    
    public HashMap<Integer, Pelinappula> haePelaaja2Nappulat(){
        return this.nappulat2;
    }
    
    public Pelaaja haePelaaja1(){
        return pelaaja1;
    }
    
    public Pelaaja haePelaaja2(){
        return pelaaja2;
    }
    
    public void asetaPelaaja1(Pelaaja pelaaja1){
        this.pelaaja1 = pelaaja1;
    }
    
    public void asetaPelaaja2(Pelaaja pelaaja2){
        this.pelaaja2 = pelaaja2;
    }
    
    public int heitaNoppaa1(){
        return this.noppa1.heitaNoppaaJaAnnaArvo();
    }
    
    public int heitaNoppaa2(){
        return this.noppa2.heitaNoppaaJaAnnaArvo();
    }
    
    public int haeNopan1Arvo(){
        return noppa1.haeNopanArvo();
    }
    
    public int haeNopan2Arvo(){
        return noppa2.haeNopanArvo();
    }
    
    /**
     * Kutsuu pelilaudan metodia joka siirtaa nappulaa HashMapissa.
     * @param sijainti Siirrettävän nappulan sijainti
     * @param siirtoja Kuinka monta siirtoa
     */
    public void siirraPelinappulaa(int sijainti, int siirtoja){
        this.pelilauta.siirraNappulaaLaudalla(sijainti, siirtoja);
    }
    
    /**
     * Kutsuu pelilaudan metodia joka lisää nappulan HashMapiin.
     * @param nappula Siirrettävän nappulan sijainti
     * @param sijainti Kuinka monta siirtoa
     */
    public void lisaaPelinappula(Pelinappula nappula, int sijainti){
        this.pelilauta.lisaaNappulaLaudalle(nappula, sijainti);
    }
    
    /**
     * Alustaa 16 pelinappulaa per pelaaja ja lisää ne vastaaviin rykelmiin nappuloita
     */
    public void alustaPelinappulat(){
        for(int i = 1;0<= i && i <16;i++){
            this.nappulat1.put(i,new Pelinappula(pelaaja1,this));
            this.nappulat2.put(i,new Pelinappula(pelaaja2,this));
        }
    }
    
    /**
     * Alustaa pelilaudan pelin alkutilanteeseen, eli lisää pelinappulat pelilaudan HashMapiin tietyllä tavalla.
     */
    public void alustaPelilauta(){
        
        for(int i = 1;i<3;i++){
            this.lisaaPelinappula(nappulat1.get(i), 1);
        }
        
        for(int i = 3;i<8;i++){
            this.lisaaPelinappula(nappulat1.get(i), 12);
        }
        
        for(int i = 8;i<11;i++){
            this.lisaaPelinappula(nappulat1.get(i), 17);
        }
        
        for(int i = 11;i<16;i++){
            this.lisaaPelinappula(nappulat1.get(i), 19);
        }
        
        for(int i = 1;i<3;i++){
            this.lisaaPelinappula(nappulat2.get(i), 24);
        }
        
        for(int i = 3;i<8;i++){
            this.lisaaPelinappula(nappulat2.get(i), 13);
        }
        
        for(int i = 8;i<11;i++){
            this.lisaaPelinappula(nappulat2.get(i), 8);
        }
        
        for(int i = 11;i<16;i++){
            this.lisaaPelinappula(nappulat2.get(i), 6);
        }
    }
    
} 