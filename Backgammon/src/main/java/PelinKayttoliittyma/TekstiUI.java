package PelinKayttoliittyma;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import java.util.Scanner;

public class TekstiUI {

    Pelikokonaisuus peli;
    Scanner lukija;
    LaudanTulostaja tulostaja;

    public TekstiUI(Pelikokonaisuus peli, LaudanTulostaja tulostaja) {
        this.peli = peli;
        this.lukija = new Scanner(System.in);
        this.tulostaja = tulostaja;
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
        if (onkoPeliLoppu()) {
            return;
        }

        System.out.println(peli.haePelaajaVuorossa().haePelaajanNimi() + " vuoro, noppien lukemat: " + peli.heitaNoppaa1() + " " + peli.heitaNoppaa2());

        if (peli.haeNopan1Arvo() == peli.haeNopan2Arvo()) {
            siirraNappulaa("ensimmäisen", peli.haeNopan1Arvo());
            System.out.println(tulostaja.tulostaPelilauta());
            siirraNappulaa("toisen", peli.haeNopan1Arvo());
            System.out.println(tulostaja.tulostaPelilauta());
            siirraNappulaa("kolmannen", peli.haeNopan1Arvo());
            System.out.println(tulostaja.tulostaPelilauta());
            siirraNappulaa("neljännen", peli.haeNopan1Arvo());
            System.out.println(tulostaja.tulostaPelilauta());
        } else {
            int summa = peli.haeNopan1Arvo() + peli.haeNopan2Arvo();
            int siirtoja = siirraNappulaaEriArvoilla("ensimmäinen");
            System.out.println(tulostaja.tulostaPelilauta());
            siirraNappulaa("toisen", summa - siirtoja);

        }

        peli.asetaPelaajaVuorossa(peli.haePelaajaVuorossa().haeVastustaja());

    }

    public void siirraNappulaa(String kuinkaMonesNappula, int noppa1) {
        System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
        int sijainti = Integer.parseInt(lukija.nextLine());
        if (peli.haePelaajaVuorossa() == peli.haePelaaja2()) {
            peli.siirraPelinappulaa(sijainti, -noppa1);
        } else {
            peli.siirraPelinappulaa(sijainti, noppa1);
        }

    }

    public int siirraNappulaaEriArvoilla(String kuinkaMonesNappula) {
        System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
        int sijainti = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna siirtojen määrä (" + peli.haeNopan1Arvo() + " tai " + peli.haeNopan2Arvo() + "): ");
        int siirtoja = Integer.parseInt(lukija.nextLine());
        if (siirtoja == peli.haeNopan1Arvo() || siirtoja == peli.haeNopan2Arvo()) {
            if (peli.haePelaajaVuorossa() == peli.haePelaaja2()) {
                peli.siirraPelinappulaa(sijainti, -siirtoja);
            } else {
                peli.siirraPelinappulaa(sijainti, siirtoja);
            }
        }
        
        return siirtoja;
    }

    public boolean onkoPeliLoppu() {
        if (peli.haePelilauta().ovatkoNappulatVastustajanAlueella(peli.haePelaaja1())) {
            System.out.println(peli.haePelaaja1().haePelaajanNimi() + " voitti!");
            return true;
        } else if (peli.haePelilauta().ovatkoNappulatVastustajanAlueella(peli.haePelaaja2())) {
            System.out.println(peli.haePelaaja2().haePelaajanNimi() + " voitti!");
            return true;
        }

        return false;
    }

}
