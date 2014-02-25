/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Luokka joka simuloi pelilautaa. Pelilaudan rakenteena toimii HashMap.
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

    /**
     * Lisää nappulan pelaajan jäähylle.
     *
     * @param nappula Nappula joka siirretään.
     * @param pelaaja Pelaaja jonka jäähylle nappula siirretään.
     */
    public void lisaaNappulaPelaajanJaahylle(Pelinappula nappula, Pelaaja pelaaja) {
        Pelinappula nappula1 = nappula;
        peli.haePelilaudanNappulat().get(nappula1.haePelinappulanSijainti()).remove(0);
        pelaaja.haePelaajanJaahy().add(nappula1);
        nappula1.asetaPelinappulanSijainti(0);

    }

    /**
     * Lisää nappulan pelaajan kotiin.
     *
     * @param nappula Nappula joka siirretään.
     * @param pelaaja Pelaaja jonka kotiin nappula siirretään.
     */
    public void lisaaNappulaPelaajanKotiin(Pelinappula nappula, Pelaaja pelaaja) {
        pelaaja.haePelaajanKoti().add(nappula);
    }

    public Pelinappula haeNappulaPelaajanJaahylta(Pelaaja pelaaja) {
        return pelaaja.haePelaajanJaahy().get(pelaaja.haePelaajanJaahy().size() - 1);
    }

    /**
     * Lisää nappulan takaisin laudalle, tarkistaa jos lisäyksen voi tehdä ja
     * päivittää pelilaudan sen mukaan. Poistaa onnistuessaan nappulan jäähyltä.
     *
     * @param sijainti Sijainti johon nappula halutaan lisätä.
     * @return Palauttaa booleanin joka kertoo jos lisäys onnistui.
     */
    public boolean lisaaNappulaTakaisinLaudalle(int sijainti) {
        Pelinappula jaahyNappula = peli.haePelaajaVuorossa().haePelaajanJaahy().get(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);
        if (voikoLisata(jaahyNappula, sijainti)) {
            if (peli.haePelilaudanNappulat().get(sijainti).size() == 1 && peli.haePelilaudanNappulat().get(sijainti).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
                Pelinappula vastustaja = peli.haePelilaudanNappulat().get(sijainti).get(0);
                this.lisaaNappulaPelaajanJaahylle(vastustaja, peli.haePelaajaVuorossa().haeVastustaja());
            }
            pelilauta.get(sijainti).add(jaahyNappula);
            jaahyNappula.asetaPelinappulanSijainti(sijainti);
            peli.haePelaajaVuorossa().haePelaajanJaahy().remove(peli.haePelaajaVuorossa().haePelaajanJaahy().size() - 1);

            return true;
        }
        return false;
    }

    /**
     * Lisää pelinappulan laudalle tarkistamalla jos lisäys on laillinen.
     *
     * @param nappula Lisättävä nappula
     * @param sijainti Mihin nappula siirretään
     * @return Palauttaa booleanin joka kertoo jos lisäys onnistui.
     */
    public boolean lisaaNappulaLaudalle(Pelinappula nappula, int sijainti) {
        if (voikoLisata(nappula, sijainti)) {
            pelilauta.get(sijainti).add(nappula);
            nappula.asetaPelinappulanSijainti(sijainti);
            return true;
        }

        return false;
    }

    /**
     * Siirtää pelinappulaa laudalla tarkistamalla jos siirto on laillinen.
     *
     * @param sijainti Sijainti jossa olevaa nappulaa halutaan siirtää
     * @param siirtoja määrä siirtoja
     * @return Palauttaa booleanin joka kertoo jos lisäys onnistui.
     */
    public boolean siirraNappulaaLaudalla(int sijainti, int siirtoja) {
        if (peli.haePelaajaVuorossa().onkoPelaajaJaahylla()) {
            return false;
        }

        if (voikoSiirtaa(sijainti, siirtoja)) {
            if (peli.haePelilaudanNappulat().get(sijainti + siirtoja).size() == 1 && peli.haePelilaudanNappulat().get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
                Pelinappula vastustaja = peli.haePelilaudanNappulat().get(sijainti + siirtoja).get(0);
                this.lisaaNappulaPelaajanJaahylle(vastustaja, peli.haePelaajaVuorossa().haeVastustaja());

            }
            Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti + siirtoja).add(nappula);
            nappula.asetaPelinappulanSijainti(sijainti + siirtoja);

            return true;
        }

        return false;
    }

    /**
     * Siirtää nappulan vuorossa olevan pelaajan kotiin.
     *
     * @param vuorossa Vuorossa oleva pelaaja.
     * @param sijainti Sijainti jossa nappula on.
     * @param siirrot Siirrot joita siirretään.
     */
    public boolean siirraNappulaKotiin(Pelaaja vuorossa, int sijainti, int siirrot) {
        if (!voikoSiirtaaKotiin(vuorossa, sijainti, siirrot)) {
            return false;
        }
        Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
        pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
        lisaaNappulaPelaajanKotiin(nappula, vuorossa);
        nappula.asetaPelinappulanSijainti(25);
        return true;

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
        } else if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() == nappula.haePelinappulanOmistaja() || pelilauta.get(sijainti).size() == 1) {
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
        if (sijainti + siirtoja < 1 || sijainti + siirtoja > 24) {
            return false;
        }
        if (pelilauta.get(sijainti).isEmpty()) {
            return false;
        }
        if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()) {
            return false;
        }
        if (pelilauta.get(sijainti + siirtoja).isEmpty()) {
            return true;
        }
        if (pelilauta.get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() != pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() && pelilauta.get(sijainti + siirtoja).size() > 1) {
            return false;
        }
        return true;
    }

    /**
     * Tarkistaa jos nappulan voi siirtää kotiin.
     *
     * @param pelaaja Pelaaja joka haluaa siirtää.
     * @param sijainti Nappulan sijainti joka halutaan siirtää.
     * @param siirtoja Kuinka monta siirtoa halutaan käyttää.
     * @return Palauttaa booleanin joka kertoo jos nappulan voi siirtää.
     */
    public boolean voikoSiirtaaKotiin(Pelaaja pelaaja, int sijainti, int siirtoja) {
        if (pelilauta.get(sijainti).isEmpty()) {
            return false;
        }

        if (pelaaja != pelilauta.get(sijainti).get(0).haePelinappulanOmistaja()) {
            return false;
        }
        if (pelaaja == peli.haePelaaja1()) {
            if (sijainti + siirtoja == 25) {
                return true;
            }
        } else {
            if (sijainti - siirtoja == 0) {
                return true;
            }
        }

        return false;
    }

    public int voikoLuovuttaVuoron(Pelaaja vuorossa) {
        if (!peli.onkoNoppaaHeitetty()) {
            return 1;
        }
        if (peli.haeVuoroLaskuri() >= 2) {
            if (vuorossa == peli.haePelaaja1()) {
                if (vuorossa.onkoPelaajaJaahylla()
                        && (peli.haePelilauta().voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), peli.haeNopan1Arvo())
                        || peli.haePelilauta().voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), peli.haeNopan2Arvo()))) {
                    return 2;
                } else if (peli.voikoPelaajaVuorossaSiirtaa(peli.haeNopan1Arvo()) || peli.voikoPelaajaVuorossaSiirtaa(peli.haeNopan2Arvo())) {
                    return 2;
                }
            } else {
                if (vuorossa.onkoPelaajaJaahylla()
                        && (peli.haePelilauta().voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), 25 - peli.haeNopan1Arvo())
                        || peli.haePelilauta().voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), 25 - peli.haeNopan2Arvo()))) {
                    return 2;
                } else if (peli.voikoPelaajaVuorossaSiirtaa(peli.haeNopan1Arvo()) || peli.voikoPelaajaVuorossaSiirtaa(peli.haeNopan2Arvo())) {
                    return 2;
                }
            }
        } else {
            if (vuorossa == peli.haePelaaja1()) {
                if (vuorossa.onkoPelaajaJaahylla()
                        && voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), peli.haeValitunNopanArvo())) {
                    return 2;
                } else if (peli.voikoPelaajaVuorossaSiirtaa(peli.haeValitunNopanArvo())) {;
                    return 2;
                }
            } else {
                if (vuorossa.onkoPelaajaJaahylla()
                        && voikoLisata(vuorossa.haePelaajanJaahy().get(vuorossa.haePelaajanJaahy().size() - 1), 25 - peli.haeValitunNopanArvo())) {
                    return 2;
                } else if (peli.voikoPelaajaVuorossaSiirtaa(peli.haeValitunNopanArvo())) {;
                    return 2;
                }
            }
        }

        return 0;
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
                if (pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() < 19 ) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 1; i < 16; i++) {
                if (pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() > 6 && pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() != 25 ) {
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
     * @param vuorossa Pelaaja joka on tällä hetkellä vuorossa
     */
    public boolean onkoPeliLoppu(Pelaaja vuorossa) {
        if (this.onkoPelaajanKotiTaynna(vuorossa)) {
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
