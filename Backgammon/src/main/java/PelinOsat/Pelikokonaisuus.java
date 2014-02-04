/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelikokonaisuus { 
    Noppa noppa1;
    Noppa noppa2;
    Pelilauta pelilauta;
    HashMap<Integer, Pelinappula> nappulat1;
    HashMap<Integer, Pelinappula> nappulat2;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    
    public Pelikokonaisuus(){
        this.noppa1 = new Noppa();
        this.noppa2 = new Noppa();
        this.pelilauta = new Pelilauta();
        this.nappulat1 = new HashMap<Integer,Pelinappula>();
        this.nappulat2 = new HashMap<Integer,Pelinappula>();
        this.pelaaja1 = null;
        this.pelaaja2 = null;
    }
    
    public HashMap<Integer, ArrayList<Pelinappula>> haePelilauta(){
        return this.pelilauta.haePelilauta();
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
    
    public void siirraPelinappulaa(int sijainti, int siirtoja){
        this.pelilauta.siirraNappulaaLaudalla(sijainti, siirtoja);
    }
    
    public void lisaaPelinappula(Pelinappula nappula, int sijainti){
        this.pelilauta.lisaaNappulaLaudalle(nappula, sijainti);
    }
    
    public void alustaPelinappulat(){
        for(int i = 1;i <16;i++){
            this.nappulat1.put(i,new Pelinappula(pelaaja1,this));
            this.nappulat2.put(i,new Pelinappula(pelaaja2,this));
        }
    }
    
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