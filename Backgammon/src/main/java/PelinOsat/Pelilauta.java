/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka joka simuloi pelilautaa. Pelilaudan struktuurina toimii HashMap.
 *
 * @author Jonas Westerlund
 */
public class Pelilauta {

    HashMap<Integer, ArrayList<Pelinappula>> pelilauta;
    Pelikokonaisuus peli;

    /**
     * Luo pelilaudan joka koostuu HashMapista jossa pelilaudan sijainnit ovat
     * yhdistettynä listoihin. Näissä listoissa voi olla saman pelaajan
     * nappuloita ikään kuin kasassa. Sisältää myös jäähypenkit nappuloille,
     * sekä kotiosion johon nappulat siirretään kun peli on loppumaisillaan.
     *
     * @param peli Saa syötteenä pelikokonaisuuden johon lauta sisältyy
     */
    public Pelilauta(Pelikokonaisuus peli) {
        this.pelilauta = new HashMap<Integer, ArrayList<Pelinappula>>();
        this.peli = peli;
        for (int i = 1; i < 25; i++) {
            pelilauta.put(i, new ArrayList<Pelinappula>());
        }

    }

    public HashMap<Integer, ArrayList<Pelinappula>> haePelilauta() {
        return this.pelilauta;
    }

    public void lisaaNappulaPelaajanJaahylle(Pelinappula nappula, Pelaaja pelaaja) {
        pelaaja.haePelaajanJaahy().add(nappula);
        peli.haePelilaudanNappulat().get(nappula.haePelinappulanSijainti()).remove(0);
    }

    public Pelinappula haeNappulaPelaajanJaahylta(Pelaaja pelaaja) {
        return pelaaja.haePelaajanJaahy().get(pelaaja.haePelaajanJaahy().size() - 1);
    }

    /**
     * Lisää pelinappulan laudalle tarkistamalla jos lisäys on laillinen.
     *
     * @param nappula Lisättävä nappula
     * @param sijainti Mihin nappula siirretään
     */
    public void lisaaNappulaLaudalle(Pelinappula nappula, int sijainti) {
        if (voikoLisata(nappula, sijainti)) {
            pelilauta.get(sijainti).add(nappula);
            nappula.asetaPelinappulanSijainti(sijainti);
        }
    }

    /**
     * Siirtää pelinappulaa laudalla tarkistamalla jos siirto on laillinen.
     *
     * @param sijainti Sijainti jossa olevaa nappulaa halutaan siirtää
     * @param siirtoja määrä siirtoja
     */
    public void siirraNappulaaLaudalla(int sijainti, int siirtoja) {
        if (sijainti < 1 || sijainti > 24 || pelilauta.get(sijainti).isEmpty()) {
            return;
        }
        if (voikoSiirtaa(sijainti, siirtoja)) {
            if (peli.haePelilaudanNappulat().get(sijainti + siirtoja).size() == 1 && peli.haePelilaudanNappulat().get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
                Pelinappula vastustaja = peli.haePelilaudanNappulat().get(sijainti + siirtoja).get(0);
                this.lisaaNappulaPelaajanJaahylle(vastustaja, peli.haePelaajaVuorossa().haeVastustaja());
                Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
                pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
                pelilauta.get(sijainti + siirtoja).add(nappula);
            } else {
                Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
                pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
                pelilauta.get(sijainti + siirtoja).add(nappula);
                nappula.asetaPelinappulanSijainti(sijainti + siirtoja);
            }
        }
    }

    public void siirraNappulaKotiin(Pelaaja vuorossa, int sijainti) {
        Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
        if (vuorossa == nappula.haePelinappulanOmistaja()) {
            pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
            vuorossa.haePelaajanKoti().add(nappula);
            nappula.asetaPelinappulanSijainti(0);
        }

    }

    /**
     * Tarkistaa jos lisäys on laillinen, eli ei mene ulos laudalta eikä muun
     * pelaajan omistaman nappulan päälle.
     *
     * @param nappula Nappula joka lisätään
     * @param sijainti Paikka johon nappula lisätään
     * @return Palauttaa booleanin joka kertoo jos nappulan pystyi lisäämään
     */
    public boolean voikoLisata(Pelinappula nappula, int sijainti) {
        if (sijainti < 1 || sijainti > 24) {
            return false;
        }
        if (pelilauta.get(sijainti).isEmpty()) {
            return true;
        } else if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() == nappula.haePelinappulanOmistaja() || pelilauta.get(sijainti).size() == 1 ) {
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa jos siirto on laillinen, eli ei mene ulos laudalta eikä muun
     * pelaajan omistaman nappulan päälle. Tarkistaa myöskin että siirtävä
     * pelaaja on vuorossa.
     *
     * @param sijainti Paikka josta nappulaa siirretään
     * @param siirtoja Määrä siirtoja joita nappulaa siirretään
     * @return Palauttaa booleanin joka kertoo jos nappulaa pystyi siirtämään
     */
    public boolean voikoSiirtaa(int sijainti, int siirtoja) {
        boolean voiko = true;
        if (sijainti + siirtoja < 1 || sijainti + siirtoja > 24) {
            return false;
        }
        if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
            return false;
        }
        if (!pelilauta.get(sijainti + siirtoja).isEmpty() && pelilauta.get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() != pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() && pelilauta.get(sijainti + siirtoja).size() > 1) {
            return false;
        }
        return voiko;
    }

    /**
     * Tarkistaa jos nappulat ovat vastustajan alueella (tämänhetkinen
     * voittovaatimus)
     *
     * @param pelaaja Pelaaja jonka nappuloita tarkastellaan
     * @return Palauttaa booleanin joka kertoo jos pelaajan nappulat ovat
     * vastustajan puolella
     */
    public boolean ovatkoNappulatVastustajanAlueella(Pelaaja pelaaja) {
        if (pelaaja == peli.haePelaaja1()) {
            for (int i = 1; i < 16; i++) {
                if (pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() < 19) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 1; i < 16; i++) {
                if (pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() > 6) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Tarkistaa onko peli loppu, eli siis jos peli on loppuasetelmassa.
     *
     * @return Palauttaa booleanin joka kertoo onko peli loppu vai ei
     */
    public boolean onkoPeliLoppu(Pelaaja vuorossa) {
        if (this.onkoPelaajanKotiTaynna(vuorossa)) {
            return true;
        } else if (this.onkoPelaajanKotiTaynna(vuorossa)) {
            return true;
        }
        return false;
    }

    public boolean onkoPelaajanJaahyTyhja(Pelaaja pelaaja) {
        return pelaaja.haePelaajanJaahy().isEmpty();
    }

    public boolean onkoPelaajanKotiTaynna(Pelaaja pelaaja) {
        return pelaaja.haePelaajanKoti().size() == 15;
    }

}
