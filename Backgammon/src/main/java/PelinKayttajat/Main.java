/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttajat;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import PelinOsat.Noppa;

/**
 *
 * @author jonas
 */
public class Main {
    
    public static void main(String[] args) {
        
        
        
        Pelaaja Jonas = new Pelaaja('X');                   //Testailen erilaisia toimintoja
        Pelilauta lauta = new Pelilauta(10);
        Pelinappula nappula1 = new Pelinappula(0,Jonas,lauta);
        Pelinappula nappula2 = new Pelinappula(6,Jonas,lauta);
        lauta.lisaaPelinappula(nappula1);
        lauta.lisaaPelinappula(nappula2);
        lauta.tulostaPelilauta();
        System.out.println("");
        
        lauta.siirraPelinappulaa(nappula1,1);
        //lauta.siirraPelinappulaa(nappula2,2);
        
        System.out.println(lauta.tulostaPelilauta());
        
        lauta.siirraPelinappulaa(nappula1,6);
        
        System.out.println(lauta.tulostaPelilauta());
    }
}
