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
import PelinOsat.Pelikokonaisuus;

/**
 *
 * @author jonas
 */
public class Main {
    
    public static void main(String[] args) {
        Pelikokonaisuus peli = new Pelikokonaisuus();
        Pelaaja jonas = new Pelaaja("Jonas",'j',peli);
        Pelaaja sandra = new Pelaaja("Sandra",'s',peli);
        peli.asetaPelaaja1(jonas);
        peli.asetaPelaaja2(sandra);
        TekstiUI kayttoliittyma = new TekstiUI(peli);
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        System.out.println(kayttoliittyma.tulostaPelilauta());
        peli.siirraPelinappulaa(17,-1);
        peli.siirraPelinappulaa(16,8);
        System.out.println(kayttoliittyma.tulostaPelilauta());
    }
}
