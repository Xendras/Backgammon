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
        Pelaaja jonas = new Pelaaja("Jonas",'j');
        Pelaaja sandra = new Pelaaja("Sandra",'s');
        Pelinappula nappulaJ = new Pelinappula(5,jonas,lauta);
        Pelinappula nappulaS = new Pelinappula(15,sandra,lauta);
        lauta.lisaaPelinappula(nappulaJ);
        lauta.lisaaPelinappula(nappulaS);
        lauta.siirraPelinappulaa(nappulaS, -11);
        TekstiUI kayttoliittyma = new TekstiUI(lauta);
        System.out.println(kayttoliittyma.tulostaPelilauta());
        lauta.asetaPelaajaVuorossa(jonas);
        kayttoliittyma.peliNappulanSiirto();
        System.out.println(kayttoliittyma.tulostaPelilauta());
    }
}
