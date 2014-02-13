/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * Luokka joka toimii pelinappuloiden vastaavina JButtoneina.
 * @author Jonas Westerlund
 */
public class NappulaNappi extends JButton {

    int sijaintiLaudalla;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    PeliPaneeli peliPaneeli;

    /**
     * Luo JButton nappulan jota painamalla hallitaan pelinappuloita pelilaudalla.
     * @param peli Pelikokonaisuus jota nappulat ohjaavat.
     * @param graafinen Käyttöliittymä jossa napit ovat.
     * @param peliPaneeli Paneeli jossa napit ovat.
     * @param sijaintiLaudalla Antaa napin sijainnin pelilaudalla.
     */
    public NappulaNappi(Pelikokonaisuus peli, GraafinenUI graafinen, PeliPaneeli peliPaneeli, int sijaintiLaudalla) {
        this.sijaintiLaudalla = sijaintiLaudalla;
        this.peli = peli;
        this.peliPaneeli = peliPaneeli;
        NappulanKuuntelija kuuntelija = new NappulanKuuntelija();
        addActionListener(kuuntelija);
        this.graafinen = graafinen;

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    /**
     * Kuuntelija joka suorittaa pelinappulan siirtoja ja lisäyksiä pelitilanteen mukaan. 
     * Toiminnot siirretään tulevaisuudessa omalle luokalle/metodille. Päivittää myös pelipaneelia.
     */
    public class NappulanKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            boolean seuraavaVuoro = true;

            if (peli.haePelaajaVuorossa() == peli.haePelaaja1()) {
                if (sijaintiLaudalla == 0) {
                    seuraavaVuoro = peli.lisaaPelinappulaTakaisinLaudalle(peli.haeNopan1Arvo());
                } else {
                    seuraavaVuoro = peli.siirraPelinappulaa(sijaintiLaudalla, peli.haeNopan1Arvo());
                }
            } else {
                if (sijaintiLaudalla == 0) {
                    seuraavaVuoro = peli.lisaaPelinappulaTakaisinLaudalle(25 - peli.haeNopan1Arvo());
                } else {
                    seuraavaVuoro = peli.siirraPelinappulaa(sijaintiLaudalla, -peli.haeNopan1Arvo());
                }
            }

            if (seuraavaVuoro) {
                peli.asetaPelaajaVuorossa(peli.haePelaajaVuorossa().haeVastustaja());
                peliPaneeli.haeIlmoitusKentta().setText("Pelaajan " + peli.haePelaajaVuorossa().haePelaajanNimi() + " vuoro!");
                peliPaneeli.haeHeitaNoppaaNappi().setEnabled(true);
            } else {
                peliPaneeli.haeIlmoitusKentta().setText("Ei voi suorittaa siirtoa! Kokeile uudestaan.");
            }

            graafinen.haeContentPane().repaint();
        }

    }
}
