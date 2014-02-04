/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

public class Pelilauta {

    HashMap<Integer, ArrayList<Pelinappula>> pelilauta;

    public Pelilauta() {
        this.pelilauta = new HashMap<Integer, ArrayList<Pelinappula>>();

        for (int i = 1; i < 25; i++) {
            pelilauta.put(i, new ArrayList<Pelinappula>());
        }

    }

    public HashMap<Integer, ArrayList<Pelinappula>> haePelilauta() {
        return this.pelilauta;
    }

    public void lisaaNappulaLaudalle(Pelinappula nappula, int sijainti) {
        if (voikoLisata(nappula, sijainti)) {
            pelilauta.get(sijainti).add(nappula);
            nappula.asetaPelinappulanSijainti(sijainti);
        }
    }

    public void siirraNappulaaLaudalla(int sijainti, int siirtoja) {
        if (sijainti < 1 || sijainti > 24 || pelilauta.get(sijainti).isEmpty()) {
            return;
        }
        if (voikoSiirtaa(sijainti, siirtoja)) {
            Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti + siirtoja).add(nappula);
        }
    }

    public boolean voikoLisata(Pelinappula nappula, int sijainti) {
        if (sijainti < 1 || sijainti > 24) {
            return false;
        }
        if (pelilauta.get(sijainti).isEmpty()) {
            return true;
        } else if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() == nappula.haePelinappulanOmistaja()) {
            return true;
        }
        return false;
    }

    public boolean voikoSiirtaa(int sijainti, int siirtoja) {
        if (sijainti + siirtoja < 1 || sijainti + siirtoja > 24) {
            return false;
        }
        if (pelilauta.get(sijainti + siirtoja).isEmpty()) {
            return true;
        } else if (pelilauta.get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() == pelilauta.get(sijainti).get(0).haePelinappulanOmistaja()) {
            return true;
        }
        return false;
    }
}
