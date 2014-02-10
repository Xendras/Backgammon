/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Teksti; 

import PelinOsat.Pelikokonaisuus;
import java.util.Scanner;

/**
 * Vastaa laudan tulostamisesta tekstikäyttöliittymässä.
 * @author Jonas Westerlund
 */
public class LaudanTulostaja { 

    Pelikokonaisuus peli;
    Scanner lukija;
    
    /**
     * Luo tulostajan joka saa syötteekseen pelikokonaisuuden.
     * @param peli Pelikokonaisuus joka annetaan tulostajalle.
     */
    public LaudanTulostaja(Pelikokonaisuus peli){
        this.peli = peli;
        this.lukija = new Scanner(System.in);
    }
    
    /**
     * Tulostaa ylälaudan pelilaudasta
     * @return Palauttaa String:inä pelilaudan yläosan (sen missä ensimmäinen nappula sijaitsee)
     */
    public String tulostaYlalauta() {
        String tulostus = "";
        for(int i = 0; i<42;i++){
            tulostus += " ";
        } 
        tulostus += "Pelaaja 2 jäähynappulat: ";
        for(int i = 0; i < peli.haePelaaja2().haePelaajanJaahy().size();i++){
            tulostus += "O ";
        }
        tulostus += '\n';
        for (int i = 0; i < 12; i++) {
            tulostus += "| ";
            if (!this.peli.haePelilaudanNappulat().get(i+13).isEmpty()) {
                tulostus += this.peli.haePelilaudanNappulat().get(13+i).get(0).haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " | ";
        }
        
        return tulostus;
    }
    
    /**
     * Tulostaa alalaudan pelilaudasta
     * @return Palauttaa String:inä pelilaudan alaosan (sen missä ensimmäinen nappula sijaitsee)
     */
    public String tulostaAlalauta(){
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "| ";
            if (!this.peli.haePelilaudanNappulat().get(12-i).isEmpty()) {
                tulostus += this.peli.haePelilaudanNappulat().get(12-i).get(0).haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " | ";
        }
        tulostus += '\n';
        for(int i = 0; i<42;i++){
            tulostus += " ";
        } 
        tulostus += "Pelaajan 1 jäähynappulat: ";
        for(int i = 0; i < peli.haePelaaja1().haePelaajanJaahy().size();i++){
            tulostus += "X ";
        }
        
        return tulostus;
    }
    
    /**
     * Tulostaa yhden rivin ylälaudasta.
     * @param rivi Kuinka mones rivi on kyseessä (1-4)
     * @return Palauttaa yhden rivin ylälaudalta.
     */
    public String tulostaYksiRiviYlaLaudalla(int rivi){
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "  ";
            if (this.peli.haePelilaudanNappulat().get(i+13).size() > rivi) {
                tulostus += this.peli.haePelilaudanNappulat().get(13+i).get(rivi).haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += "   ";
        }
        
        return tulostus;
    }
    
    /**
     * Tulostaa yhden rivin alalaudasta.
     * @param rivi Kuinka mones rivi on kyseessä (1-4)
     * @return Palauttaa yhden rivin alalaudalta.
     */
    public String tulostaYksiRiviAlaLaudalla(int rivi){
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "  ";
            if (this.peli.haePelilaudanNappulat().get(12-i).size() > rivi) {
                tulostus += this.peli.haePelilaudanNappulat().get(12-i).get(rivi).haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += "   ";
        }
        
        return tulostus;
    }
    
    /**
     * Tulostaa koko pelilaudan.
     * @return Palauttaa koko pelilaudan ulkonäön.
     */
    public String tulostaPelilauta(){
        String tulostus = "";
        for(int i = 0; i<12;i++){
            tulostus += "  " + String.valueOf(i+13) + "  ";
        }   
        tulostus += '\n';
        for(int i = 0; i<72;i++){
            tulostus += "-";
        }  
        tulostus += '\n';
        tulostus += this.tulostaYlalauta() + '\n';
        for(int i = 1; i<5;i++){
            tulostus += tulostaYksiRiviYlaLaudalla(i) +'\n';
        }
        for(int i = 0; i<72;i++){
            tulostus += "-";
        } 
        tulostus += '\n';
        for(int i = 4; i>0;i--){
            tulostus += tulostaYksiRiviAlaLaudalla(i)+'\n';
        }
        tulostus += this.tulostaAlalauta();
        tulostus += '\n';
        for(int i = 0; i<72;i++){
            tulostus += "-";
        } 
        tulostus += '\n';
        for(int i = 0; i<3;i++){
            tulostus += "  " + String.valueOf(12-i) + "  ";
        }   
        for(int i = 3; i<12;i++){
            tulostus += "  " + String.valueOf(12-i) + "   ";
        }  
        return tulostus;
    }
} 