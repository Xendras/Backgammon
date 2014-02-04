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
        TekstiUI kayttoliittyma = new TekstiUI(peli);
        LaudanTulostaja tulostaja = new LaudanTulostaja(peli);
        kayttoliittyma.aloitaPeli();
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        System.out.println(tulostaja.tulostaPelilauta());
        
        boolean loppu = false;
        while(!loppu){
            loppu = peli.haePelilauta().ovatkoNappulatVastustajanAlueella(peli.haePelaajaVuorossa().haeVastustaja());
            System.out.println(tulostaja.tulostaPelilauta());
            kayttoliittyma.seuraavaVuoro();
        }
       
    }
}
