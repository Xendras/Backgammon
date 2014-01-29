/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma;
import PelinKayttajat.Pelaaja;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import PelinOsat.Noppa;

/**
 *
 * @author jonas
 */
public class Main {
    
    public static void main(String[] args) {
        Pelilauta lauta = new Pelilauta();
        TekstiUI kayttoliittyma = new TekstiUI(lauta);
        System.out.println(kayttoliittyma.tulostaPelilauta());
    }
}
