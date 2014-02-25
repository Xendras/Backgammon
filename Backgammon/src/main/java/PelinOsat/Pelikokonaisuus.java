/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka kerää kaikki pelin osat yhteen kokonaisuuteen joka hallinnoi eri osia.
 *
 * @author Jonas Westerlund
 */
public class Pelikokonaisuus {

    Noppa noppa1;
    Noppa noppa2;
    Pelilauta pelilauta;
    HashMap<Integer, Pelinappula> nappulat1;
    HashMap<Integer, Pelinappula> nappulat2;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Pelaaja vuorossa;
    ArrayList<Pelinappula> jaahy1;
    ArrayList<Pelinappula> jaahy2;
    ArrayList<Pelinappula> koti1;
    ArrayList<Pelinappula> koti2;
    boolean noppaaHeitetty;
    Noppa valittuNoppa;
    int heittojenMaara;
    int vuoroLaskuri;

    /**
     * Luo pelikokonaisuuden joka sisältää kaksi noppaa, yhden pelilaudan, kaksi
     * rykelmää pelinappuloita, kaksi pelaajaa, sekä vuorossa olevan pelaajan
     * jäähy ja kotilaudat
     */
    public Pelikokonaisuus() {
        this.noppa1 = new Noppa();
        this.noppa2 = new Noppa();
        this.pelilauta = new Pelilauta(this);
        this.nappulat1 = new HashMap<Integer, Pelinappula>();
        this.nappulat2 = new HashMap<Integer, Pelinappula>();
        this.jaahy1 = new ArrayList<Pelinappula>();
        this.jaahy2 = new ArrayList<Pelinappula>();
        this.koti1 = new ArrayList<Pelinappula>();
        this.koti2 = new ArrayList<Pelinappula>();
        this.pelaaja1 = null;
        this.pelaaja2 = null;
        this.vuorossa = pelaaja1;
        this.noppaaHeitetty = false;
        this.heittojenMaara = 2;
        this.vuoroLaskuri = 2;
        this.valittuNoppa = noppa1;

    }

    /**
     * Hakee pelilaudan nappulat, eli siis HashMapin
     *
     * @return Palauttaa HashMapin jossa on sijainnit yhidstettynä
     * pelinappulalistoihin
     */
    public HashMap<Integer, ArrayList<Pelinappula>> haePelilaudanNappulat() {
        return this.pelilauta.haePelilauta();
    }

    /**
     * Hakee pelilaudan, eli siis luokkaolion joka sisältää pelinappulaHashMapin
     *
     * @return Palauttaa pelilaudan
     */
    public Pelilauta haePelilauta() {
        return this.pelilauta;
    }

    public ArrayList<Pelinappula> haePelaajan1Jaahy() {
        return this.jaahy1;
    }

    public ArrayList<Pelinappula> haePelaajan2Jaahy() {
        return this.jaahy2;
    }

    public ArrayList<Pelinappula> haePelaajan1Koti() {
        return this.koti1;
    }

    public ArrayList<Pelinappula> haePelaajan2Koti() {
        return this.koti2;
    }

    public Pelaaja haePelaajaVuorossa() {
        return vuorossa;
    }

    public void asetaPelaajaVuorossa(Pelaaja pelaaja) {
        this.vuorossa = pelaaja;
    }

    public HashMap<Integer, Pelinappula> haePelaaja1Nappulat() {
        return this.nappulat1;
    }

    public HashMap<Integer, Pelinappula> haePelaaja2Nappulat() {
        return this.nappulat2;
    }

    public Pelaaja haePelaaja1() {
        return pelaaja1;
    }

    public Pelaaja haePelaaja2() {
        return pelaaja2;
    }

    public void asetaPelaaja1(Pelaaja pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public void asetaPelaaja2(Pelaaja pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public Noppa haeNoppa1() {
        return this.noppa1;
    }

    public Noppa haeNoppa2() {
        return this.noppa2;
    }

    public int heitaNoppaa1() {
        return this.noppa1.heitaNoppaaJaAnnaArvo();
    }

    public int heitaNoppaa2() {
        return this.noppa2.heitaNoppaaJaAnnaArvo();
    }

    public int haeNopan1Arvo() {
        return noppa1.haeNopanArvo();
    }

    public int haeNopan2Arvo() {
        return noppa2.haeNopanArvo();
    }

    public boolean onkoNoppaaHeitetty() {
        return this.noppaaHeitetty;
    }

    public void asetaNoppaaHeitetty(boolean onko) {
        this.noppaaHeitetty = onko;
    }

    public Noppa haeToinenNoppa(Noppa noppa) {
        if (noppa == noppa1) {
            return noppa2;
        } else {
            return noppa1;
        }
    }

    public void asetaValittuNoppa(Noppa noppa) {
        this.valittuNoppa = noppa;
    }

    public Noppa haeValittuNoppa() {
        return this.valittuNoppa;
    }

    public int haeValitunNopanArvo() {
        return this.valittuNoppa.haeNopanArvo();
    }

    public int haeHeittojenMaara() {
        return this.heittojenMaara;
    }

    public void asetaHeittojenMaara(int maara) {
        this.heittojenMaara = maara;
    }

    public void vahennaVuoroLaskuria() {
        this.vuoroLaskuri--;
    }

    public int haeVuoroLaskuri() {
        return this.vuoroLaskuri;
    }

    public void alustaVuoroLaskuri() {
        this.vuoroLaskuri = heittojenMaara;
    }

    /**
     * Kutsuu pelilaudan metodia joka siirtaa nappulaa HashMapissa.
     *
     * @param sijainti Siirrettävän nappulan sijainti
     * @param siirtoja Kuinka monta siirtoa
     * @return Palauttaa booleanin joka kertoo josko siirto onnistui
     */
    public boolean siirraPelinappulaa(int sijainti, int siirtoja) {
        return this.pelilauta.siirraNappulaaLaudalla(sijainti, siirtoja);
    }

    /**
     * Kutsuu pelilaudan metodia joka lisää nappulan HashMapiin.
     *
     * @param nappula Siirrettävän nappulan sijainti
     * @param sijainti Kuinka monta siirtoa
     * @return Palauttaa booleanin joka kertoo josko lisäys onnistui
     */
    public boolean lisaaPelinappula(Pelinappula nappula, int sijainti) {
        return this.pelilauta.lisaaNappulaLaudalle(nappula, sijainti);
    }

    /**
     *
     * @param sijainti
     * @return Palauttaa booleanin joka kertoo josko lisäys onnistui
     */
    public boolean lisaaPelinappulaTakaisinLaudalle(int sijainti) {
        return this.pelilauta.lisaaNappulaTakaisinLaudalle(sijainti);
    }

    /**
     * Alustaa 16 pelinappulaa per pelaaja ja lisää ne vastaaviin rykelmiin
     * nappuloita
     */
    public void alustaPelinappulat() {
        for (int i = 1; 0 <= i && i < 16; i++) {
            this.nappulat1.put(i, new Pelinappula(pelaaja1, this));
            this.nappulat2.put(i, new Pelinappula(pelaaja2, this));
        }
    }

    /**
     * Alustaa pelilaudan pelin alkutilanteeseen, eli lisää pelinappulat
     * pelilaudan HashMapiin tietyllä tavalla.
     */
    public void alustaPelilauta() {

        for (int i = 1; i < 3; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 1);
        }

        for (int i = 3; i < 8; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 12);
        }

        for (int i = 8; i < 11; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 17);
        }

        for (int i = 11; i < 16; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 19);
        }

        for (int i = 1; i < 3; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 24);
        }

        for (int i = 3; i < 8; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 13);
        }

        for (int i = 8; i < 11; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 8);
        }

        for (int i = 11; i < 16; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 6);
        }
    }
    
    public void alustaPelilautaTest() {

        for (int i = 1; i < 3; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 24);
        }

        for (int i = 3; i < 8; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 23);
        }

        for (int i = 8; i < 11; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 21);
        }

        for (int i = 11; i < 16; i++) {
            this.lisaaPelinappula(nappulat1.get(i), 19);
        }

        for (int i = 1; i < 3; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 2);
        }

        for (int i = 3; i < 8; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 3);
        }

        for (int i = 8; i < 11; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 1);
        }

        for (int i = 11; i < 16; i++) {
            this.lisaaPelinappula(nappulat2.get(i), 5);
        }
    }

    public boolean ovatkoNappulatVastustajanAlueella(Pelaaja pelaaja) {
        return haePelilauta().ovatkoNappulatVastustajanAlueella(pelaaja);
    }

    public boolean siirraNappulaKotiin(Pelaaja vuorossa, int sijainti, int siirrot) {
        return haePelilauta().siirraNappulaKotiin(vuorossa, sijainti, siirrot);
    }

    public boolean onkoPeliLoppu(Pelaaja vuorossa) {
        return haePelilauta().onkoPeliLoppu(vuorossa);
    }

    public boolean uusiVuoro(int sijainti, int noppa) {
        boolean seuraavaVuoro = false;

        if (ovatkoNappulatVastustajanAlueella(haePelaajaVuorossa())) {
            if (sijainti + noppa == 25 || sijainti - noppa == 0) {
                seuraavaVuoro = siirraNappulaKotiin(haePelaajaVuorossa(), sijainti, noppa);
            } else {
                if(haePelaajaVuorossa() == haePelaaja1()){
                    seuraavaVuoro = siirraPelinappulaa(sijainti, noppa);
                } else{
                    seuraavaVuoro = siirraPelinappulaa(sijainti, -noppa);
                }
            }
        } else {
            if (haePelaajaVuorossa() == haePelaaja1()) {
                if (sijainti == 0) {
                    if (!haePelaajan1Jaahy().isEmpty()) {
                        seuraavaVuoro = lisaaPelinappulaTakaisinLaudalle(noppa);
                    }
                } else {
                    seuraavaVuoro = siirraPelinappulaa(sijainti, noppa);
                }
            } else {
                if (sijainti == 0) {
                    if (!haePelaajan2Jaahy().isEmpty()) {
                        seuraavaVuoro = lisaaPelinappulaTakaisinLaudalle(25 - noppa);
                    }
                } else {
                    seuraavaVuoro = siirraPelinappulaa(sijainti, -noppa);
                }
            }
        }

        return seuraavaVuoro;

    }

    public boolean voikoPelaajaVuorossaSiirtaa(int siirtoja) {
        for (int i = 1; i < 25; i++) {
            if (!haePelaajaVuorossa().haePelaajanJaahy().isEmpty()) {
                if (haePelilauta().voikoLisata(haePelaajaVuorossa().haePelaajanJaahy().get(haePelaajaVuorossa().haePelaajanJaahy().size()-1), siirtoja)) {
                    return true;
                }
            } else if (haePelilauta().ovatkoNappulatVastustajanAlueella(haePelaajaVuorossa())) {
                if (haePelilauta().voikoSiirtaaKotiin(haePelaajaVuorossa(), i, siirtoja) || haePelilauta().voikoSiirtaa(i,siirtoja) ) {
                    return true;
                }
            } else if (haePelilauta().voikoSiirtaa(i,siirtoja)) {
                return true;
            }
        }

        return false;
    }
    
    public int voikoLuovuttaaVuoron(){
        return haePelilauta().voikoLuovuttaVuoron(haePelaajaVuorossa());
    }

}
