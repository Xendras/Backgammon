/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma; 

import PelinOsat.Pelikokonaisuus;
import java.util.Scanner;


public class LaudanTulostaja { 

    Pelikokonaisuus peli;
    Scanner lukija;
    
    public LaudanTulostaja(Pelikokonaisuus peli){
        this.peli = peli;
        this.lukija = new Scanner(System.in);
    }
    
    public String tulostaYlalauta() {
        String tulostus = "";
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
        
        return tulostus;
    }
    
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