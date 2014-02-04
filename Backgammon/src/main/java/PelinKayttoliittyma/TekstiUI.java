package PelinKayttoliittyma;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import java.util.Scanner;

public class TekstiUI {

    Pelikokonaisuus peli;
    Scanner lukija;

    public TekstiUI(Pelikokonaisuus peli) {
        this.peli = peli;
        this.lukija = new Scanner(System.in);
    }

    public void aloitaPeli() {
        System.out.println("Backgammon-peli");
        System.out.print("Anna pelaaja 1 nimi: ");
        String pelaaja1Nimi = lukija.nextLine();
        System.out.print("Anna pelaaja 2 nimi: ");
        String pelaaja2Nimi = lukija.nextLine();
        peli.asetaPelaaja1(new Pelaaja(pelaaja1Nimi, 'X', peli, peli.haePelaaja1Nappulat()));
        peli.asetaPelaaja2(new Pelaaja(pelaaja2Nimi, 'O', peli, peli.haePelaaja2Nappulat()));
        peli.haePelaaja1().asetaVastustaja(peli.haePelaaja2());
        peli.haePelaaja2().asetaVastustaja(peli.haePelaaja1());
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        System.out.println(pelaaja1Nimi + " (nappulat X) aloittaa pelin ja liikkuu myötäpäivään. " + pelaaja2Nimi + " (nappulat O) jatkaa ja pelaa vastapäivään.");
    }

    public void seuraavaVuoro() {
        if (peli.haePelilauta().ovatkoNappulatVastustajanAlueella(peli.haePelaaja1())) {
            System.out.println(peli.haePelaaja1().haePelaajanNimi() + " voitti!");
            return;
        }
        if (peli.haePelilauta().ovatkoNappulatVastustajanAlueella(peli.haePelaaja2())) {
            System.out.println(peli.haePelaaja2().haePelaajanNimi() + " voitti!");
            return;
        }

        System.out.println(peli.haePelaajaVuorossa().haePelaajanNimi() + " vuoro, nopan lukema: " + peli.heitaNoppaa1());
        System.out.print("Anna nappulan sijainti jota haluat siirtää: ");
        int sijainti = Integer.parseInt(lukija.nextLine());
        if (peli.haePelaajaVuorossa() == peli.haePelaaja2()) {
            peli.siirraPelinappulaa(sijainti, -4);
        } else {
            peli.siirraPelinappulaa(sijainti, 3);
        }
        peli.asetaPelaajaVuorossa(peli.haePelaajaVuorossa().haeVastustaja());

    }
}
