package PelinKayttoliittyma.Teksti;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import java.util.Scanner;

/**
 * Vastaa pelin tekstikäyttöliittymästä kun peliä pelataan.
 *
 * @author Jonas Westerlund
 */
public class TekstiUI {

    Pelikokonaisuus peli;
    Scanner lukija;
    LaudanTulostaja tulostaja;

    /**
     * Luo tekstikäyttöliittymän joka käyttää tulostajaa.
     *
     * @param peli Pelikokonaisuus johon käyttöliittymää sovelletaan
     * @param tulostaja Tulostaja jota käyttöliittymä hyödyntää
     */
    public TekstiUI(Pelikokonaisuus peli, LaudanTulostaja tulostaja) {
        this.peli = peli;
        this.lukija = new Scanner(System.in);
        this.tulostaja = tulostaja;
    }

    /**
     * Metodi aloittaa pelin ja alustaa pelin pelaajat peliä varten.
     */
    public void aloitaPeli() {
        System.out.println("Backgammon-peli");
        System.out.print("Anna pelaaja 1 nimi: ");
        String pelaaja1Nimi = lukija.nextLine();
        System.out.print("Anna pelaaja 2 nimi: ");
        String pelaaja2Nimi = lukija.nextLine();
        peli.asetaPelaaja1(new Pelaaja(pelaaja1Nimi, 'X', peli, peli.haePelaaja1Nappulat(), peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti()));
        peli.asetaPelaaja2(new Pelaaja(pelaaja2Nimi, 'O', peli, peli.haePelaaja2Nappulat(), peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()));
        peli.haePelaaja1().asetaVastustaja(peli.haePelaaja2());
        peli.haePelaaja2().asetaVastustaja(peli.haePelaaja1());
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        System.out.println(pelaaja1Nimi + " (nappulat X) aloittaa pelin ja liikkuu myötäpäivään. " + pelaaja2Nimi + " (nappulat O) jatkaa ja pelaa vastapäivään.");
    }

    /**
     * Aloittaa seuraavan vuoron ja tarkistaa jos peli on loppu. Pyytää
     * pelaajilta vuoron perään syötteenä nappulan sijainnin jota he haluavat
     * siirtää, ja riippuen nopista paljolla he haluavat siirtää nappuloita. Kun
     * siirrot on tehty vuoro vaihtuu.
     *
     */
    public void seuraavaVuoro() {
        Pelaaja vuorossa = peli.haePelaajaVuorossa();
        if (peli.haePelilauta().onkoPeliLoppu(vuorossa)) {
            return;
        }
        if (!peli.haePelilauta().onkoPelaajanJaahyTyhja(vuorossa)) {
            System.out.println(vuorossa.haePelaajanNimi() + " vuoro, noppien lukemat: " + peli.heitaNoppaa1() + " " + peli.heitaNoppaa2());
            lisaaNappulaTakaisinLaudalle(1);
        } else {
            System.out.println(vuorossa.haePelaajanNimi() + " vuoro, noppien lukemat: " + peli.heitaNoppaa1() + " " + peli.heitaNoppaa2());
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
        }

        peli.asetaPelaajaVuorossa(vuorossa.haeVastustaja());

    }

    /**
     * Metodi avustaa seuraavaVuoro metodia tekemällä siitä selvemmän. Siirtää
     * siis nappulaa nopan lukeman verran. Käytetään kun pelaaja heittää kaksi
     * samaa lukua nopilla.
     *
     * @param kuinkaMonesNappula Syötteenä annettu nappulan sijainti
     * @param noppa Nopan lukema.
     */
    public void siirraNappulaa(String kuinkaMonesNappula, int noppa) {
        System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
        int sijainti = Integer.parseInt(lukija.nextLine());
        if (peli.haePelaajaVuorossa() == peli.haePelaaja2()) {
            while (!peli.haePelilauta().voikoSiirtaa(sijainti, -noppa)) {
                System.out.println("Nappulaa ei voi siirtää.");
                System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
                sijainti = Integer.parseInt(lukija.nextLine());
            }
            peli.siirraPelinappulaa(sijainti, -noppa);
        } else {
            while (!peli.haePelilauta().voikoSiirtaa(sijainti, noppa)) {
                System.out.println("Nappulaa ei voi siirtää.");
                System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
                sijainti = Integer.parseInt(lukija.nextLine());
            }
            peli.siirraPelinappulaa(sijainti, noppa);
        }

    }

    /**
     * Käytetään kun pelaaja heittää eri arvot nopilla. Kysyy monella sitä
     * siirretään ja kysyy mitä siirretään lopuilla siirroilla.
     *
     * @param kuinkaMonesNappula
     * @return Palauttaa kuinka monta askelta nappulaa siirrettiin
     */
    public int siirraNappulaaEriArvoilla(String kuinkaMonesNappula) {
        System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
        int sijainti = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna siirtojen määrä (" + peli.haeNopan1Arvo() + " tai " + peli.haeNopan2Arvo() + "): ");
        int siirtoja = Integer.parseInt(lukija.nextLine());

        if (siirtoja == peli.haeNopan1Arvo() || siirtoja == peli.haeNopan2Arvo()) {
            if (peli.haePelaajaVuorossa() == peli.haePelaaja2()) {
                while (!peli.haePelilauta().voikoSiirtaa(sijainti, -siirtoja)) {
                    System.out.println("Nappulaa ei voi siirtää.");
                    System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
                    sijainti = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna siirtojen määrä (" + peli.haeNopan1Arvo() + " tai " + peli.haeNopan2Arvo() + "): ");
                    siirtoja = Integer.parseInt(lukija.nextLine());
                }
                peli.siirraPelinappulaa(sijainti, -siirtoja);
            } else {
                while (!peli.haePelilauta().voikoSiirtaa(sijainti, siirtoja)) {
                    System.out.println("Nappulaa ei voi siirtää.");
                    System.out.print("Anna " + kuinkaMonesNappula + " nappulan sijainti jota haluat siirtää: ");
                    sijainti = Integer.parseInt(lukija.nextLine());
                    System.out.print("Anna siirtojen määrä (" + peli.haeNopan1Arvo() + " tai " + peli.haeNopan2Arvo() + "): ");
                    siirtoja = Integer.parseInt(lukija.nextLine());
                }
                peli.siirraPelinappulaa(sijainti, siirtoja);
            }
        }

        return siirtoja;
    }

    /**
     * Lisää nappulan takaisin laudalle jäähylaudalta.
     *
     * @param noppa
     */
    
    public void lisaaNappulaTakaisinLaudalle(int noppa) {
        System.out.print("Anna sijainti mihin nappula siirretään jäähyltä: ");
        int sijainti = Integer.parseInt(lukija.nextLine());

        if (peli.haePelilauta().voikoLisata(peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1), sijainti)) {
            if (peli.haePelaajaVuorossa() == peli.haePelaaja1() && sijainti < 7 && sijainti > 0) {
                if (peli.haePelilaudanNappulat().get(sijainti).size() == 1 && peli.haePelilaudanNappulat().get(sijainti).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
                    Pelinappula vastustaja = peli.haePelilaudanNappulat().get(sijainti).get(0);
                    peli.haePelilauta().lisaaNappulaPelaajanJaahylle(vastustaja, peli.haePelaajaVuorossa().haeVastustaja());
                    peli.haePelilaudanNappulat().get(sijainti).remove(0);
                    peli.lisaaPelinappula(peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1), sijainti);
                    peli.haePelaajaVuorossa().haePelaajanJaahy().remove(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);

                } else {
                    peli.lisaaPelinappula(peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1), sijainti);
                    peli.haePelaajaVuorossa().haePelaajanJaahy().remove(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);
                }
            } else if (peli.haePelaajaVuorossa() == peli.haePelaaja2() && sijainti > 18 && sijainti < 25) {
                if (peli.haePelilaudanNappulat().get(sijainti).isEmpty() || peli.haePelilaudanNappulat().get(sijainti).get(0).haePelinappulanOmistaja() == peli.haePelaajaVuorossa() ) {
                    peli.lisaaPelinappula(peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1), sijainti);
                    peli.haePelaajaVuorossa().haePelaajanJaahy().remove(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);
                } else if (peli.haePelilaudanNappulat().get(sijainti).size() == 1) {
                    Pelinappula vastustaja = peli.haePelilaudanNappulat().get(sijainti).get(0);
                    peli.haePelilauta().lisaaNappulaPelaajanJaahylle(vastustaja, peli.haePelaajaVuorossa().haeVastustaja());
                    peli.haePelilaudanNappulat().get(sijainti).remove(0);
                    peli.lisaaPelinappula(peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1), sijainti);
                    peli.haePelaajaVuorossa().haePelaajanJaahy().remove(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);

                }
            }
        }
    }

}
