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
 * @author Jonas Westerlund
 */
public class Pelilauta {

    HashMap<Integer, ArrayList<Pelinappula>> pelilauta;
    Pelikokonaisuus peli;

    /**
     * Luo pelilaudan joka koostuu HashMapista jossa pelilaudan sijainnit ovat yhdistettynä listoihin. 
     * Näissä listoissa voi olla saman pelaajan nappuloita ikään kuin kasassa
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
     * Lisää pelinappulan laudalle tarkistamalla jos lisäys on laillinen.
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
     * @param sijainti Sijainti jossa olevaa nappulaa halutaan siirtää
     * @param siirtoja määrä siirtoja
     */
    public void siirraNappulaaLaudalla(int sijainti, int siirtoja) {
        if (sijainti < 1 || sijainti > 24 || pelilauta.get(sijainti).isEmpty()) {
            return;
        }
        if (voikoSiirtaa(sijainti, siirtoja)) {
            Pelinappula nappula = pelilauta.get(sijainti).get(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti).remove(pelilauta.get(sijainti).size() - 1);
            pelilauta.get(sijainti + siirtoja).add(nappula);
            nappula.asetaPelinappulanSijainti(sijainti+siirtoja);
        }
    }

    /**
     * Tarkistaa jos lisäys on laillinen, eli ei mene ulos laudalta eikä muun pelaajan omistaman nappulan päälle.
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
        } else if (pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() == nappula.haePelinappulanOmistaja()) {
            return true;
        }
        return false;
    }

    /**
     * Tarkistaa jos siirto on laillinen, eli ei mene ulos laudalta eikä muun pelaajan omistaman nappulan päälle.
     * Tarkistaa myöskin että siirtävä pelaaja on vuorossa.
     * @param sijainti Paikka josta nappulaa siirretään
     * @param siirtoja Määrä siirtoja joita nappulaa siirretään
     * @return Palauttaa booleanin joka kertoo jos nappulaa pystyi siirtämään
     */
    public boolean voikoSiirtaa(int sijainti, int siirtoja) {
        boolean voiko = true;
        if (sijainti + siirtoja < 1 || sijainti + siirtoja > 24) {
            return false;
        }
        if(pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() != peli.haePelaajaVuorossa()){
            return false;
        }
        if (!pelilauta.get(sijainti + siirtoja).isEmpty() && pelilauta.get(sijainti + siirtoja).get(0).haePelinappulanOmistaja() != pelilauta.get(sijainti).get(0).haePelinappulanOmistaja() ) {
            return false;
        }
        return voiko;
    }
    
    /**
     * Tarkistaa jos nappulat ovat vastustajan alueella (tämänhetkinen voittovaatimus)
     * @param pelaaja Pelaaja jonka nappuloita tarkastellaan
     * @return Palauttaa booleanin joka kertoo jos pelaajan nappulat ovat vastustajan puolella
     */
    public boolean ovatkoNappulatVastustajanAlueella(Pelaaja pelaaja){
        if(pelaaja == peli.haePelaaja1()){
        for(int i = 1;i < 16;i++){
            if(pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() < 19){
                return false;
            }
        }
        return true;
        } else {
           for(int i = 1;i < 16;i++){
            if(pelaaja.haePelaajanNappulat().get(i).haePelinappulanSijainti() > 6){
                return false;
            }
        } 
           return true;
        }
    }
}
