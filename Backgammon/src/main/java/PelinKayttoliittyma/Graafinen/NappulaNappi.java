/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Noppa;
import PelinOsat.Pelikokonaisuus;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Luokka joka toimii pelinappuloiden vastaavina JButtoneina.
 *
 * @author Jonas Westerlund
 */
public class NappulaNappi extends JButton {

    int sijaintiLaudalla;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    PeliPaneeli peliPaneeli;

    /**
     * Luo JButton nappulan jota painamalla hallitaan pelinappuloita
     * pelilaudalla.
     *
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
     * Kuuntelija joka suorittaa pelinappulan siirtoja ja lisäyksiä
     * pelitilanteen mukaan. Toiminnot siirretään tulevaisuudessa omalle
     * luokalle/metodille. Päivittää myös pelipaneelia.
     */
    public class NappulanKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (peli.onkoNoppaaHeitetty()) {

                boolean seuraavaVuoro = peli.uusiVuoro(sijaintiLaudalla, peli.haeValitunNopanArvo());

                peliPaneeli.haePelaajienKodit().setText(
                        "Pelaajan " + peli.haePelaaja1().haePelaajanNimi() + " koti: \n" + peli.haePelaajan1Koti().size()
                        + "/15 nappulaa \n\nPelaajan " + peli.haePelaaja2().haePelaajanNimi() + " koti: \n" + peli.haePelaajan2Koti().size() + "/15 nappulaa");

                if (seuraavaVuoro) {
                    if (peli.onkoPeliLoppu(peli.haePelaajaVuorossa())) {
                        JOptionPane.showMessageDialog(graafinen.haeFrame(), "Onneksi olkoon! Pelaaja " + peli.haePelaajaVuorossa().haePelaajanNimi() + " voitti!", "Peli loppui!", 1);
                        peliPaneeli.haeIlmoitusKentta().append("\nPeli loppui!");
                        graafinen.siirryAloitusPaneeliin();
                    }
                    
                    peli.vahennaVuoroLaskuria();
                    Noppa uusiValittuNoppa = peli.haeToinenNoppa(peli.haeValittuNoppa());
                    peli.asetaValittuNoppa(uusiValittuNoppa);

                    if (peli.haeVuoroLaskuri() == 0) {
                        peli.asetaPelaajaVuorossa(peli.haePelaajaVuorossa().haeVastustaja());
                        peliPaneeli.haeIlmoitusKentta().append("\nPelaajan " + peli.haePelaajaVuorossa().haePelaajanNimi() + " vuoro!");
                        peliPaneeli.haeHeitaNoppaaNappi().setEnabled(true);
                        peliPaneeli.asetaNoppaNappienTila(true);
                        peli.asetaNoppaaHeitetty(false);
                        if (peli.haePelaajaVuorossa() == peli.haePelaaja1()) {
                            peliPaneeli.setBackground(Color.BLACK);
                        } else {
                            peliPaneeli.setBackground(Color.WHITE);
                        }
                    }
                } else {
                    peliPaneeli.haeIlmoitusKentta().append("\nEi voi suorittaa siirtoa! Kokeile uudestaan.");
                }
            } else {
                peliPaneeli.haeIlmoitusKentta().append("\nHeitä noppaa!");
            }

            peliPaneeli.haeIlmoitusKentta().setCaretPosition(peliPaneeli.haeIlmoitusKentta().getDocument().getLength());
            graafinen.haeContentPane().repaint();

        }

    }
}
