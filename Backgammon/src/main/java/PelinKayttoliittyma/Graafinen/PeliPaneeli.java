/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Noppa;
import PelinOsat.Pelikokonaisuus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * Luokka joka sisältää pelipaneelin jossa itse peli tapahtuu.
 *
 * @author Jonas Westerlund
 */
public class PeliPaneeli extends JPanel {

    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    JToggleButton noppa1;
    JToggleButton noppa2;
    JTextArea ilmoitusKentta;
    JTextArea pelaajienKodit;
    JScrollPane ilmoitusKenttaScroll;
    JButton heitaNoppaa;
    JButton luovutaVuoro;
    PelilaudanPaneeli pelilauta;

    /**
     * Luo paneelin joka koostuu piirrettävästä paneelista sekä paneelin
     * alaosasta jossa on toimintoja.
     *
     * @param peli Pelikokonaisuus jota paneeli ohjaa.
     * @param graafinen Käyttöliittymä jossa paneeli on.
     */
    public PeliPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen) {
        this.peli = peli;
        this.graafinen = graafinen;

        pelilauta = new PelilaudanPaneeli(peli, graafinen, this);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(720, 635));
        setMinimumSize(new Dimension(720, 635));
        setBackground(Color.BLACK);

        JPanel alaOsio = new JPanel();
        alaOsio.setLayout(new BoxLayout(alaOsio, BoxLayout.X_AXIS));

        JPanel ylaOsio = new JPanel();
        ylaOsio.setLayout(new BoxLayout(ylaOsio, BoxLayout.X_AXIS));

        pelaajienKodit = new JTextArea(
                "\nPelaajan " + peli.haePelaaja1().haePelaajanNimi() + " koti: \n" + peli.haePelaajan1Koti().size()
                + "/15 nappulaa \n\n\n\n\n\nPelaajan " + peli.haePelaaja2().haePelaajanNimi() + " koti: \n" + peli.haePelaajan2Koti().size() + "/15 nappulaa");
        pelaajienKodit.setFont(pelaajienKodit.getFont().deriveFont(12f));
        pelaajienKodit.setMaximumSize(new Dimension(170, 170));
        pelaajienKodit.setEditable(false);

        ylaOsio.add(pelilauta);
        ylaOsio.add(pelaajienKodit);

        luovutaVuoro = new JButton("Luovuta vuoro!");
        luovutaVuoro.setPreferredSize(new Dimension(140, 30));
        VuoronLuovutusKuuntelija kuuntelija1 = new VuoronLuovutusKuuntelija();
        luovutaVuoro.addActionListener(kuuntelija1);
        luovutaVuoro.setAlignmentX(SwingConstants.LEFT);

        ilmoitusKentta = new JTextArea("Pelaaja " + peli.haePelaaja1().haePelaajanNimi() + " aloittaa!");
        ilmoitusKentta.setEditable(false);
        ilmoitusKentta.setFont(ilmoitusKentta.getFont().deriveFont(11f));
        ilmoitusKenttaScroll = new JScrollPane(ilmoitusKentta);
        ilmoitusKenttaScroll.setPreferredSize(new Dimension(200, 75));

        noppa1 = new JToggleButton("", false);
        NopanValintaKuuntelija nopan1Kuuntelija = new NopanValintaKuuntelija(peli.haeNoppa1());
        noppa1.addItemListener(nopan1Kuuntelija);
        noppa1.setPreferredSize(new Dimension(50, 30));
        noppa2 = new JToggleButton("", false);
        NopanValintaKuuntelija nopan2Kuuntelija = new NopanValintaKuuntelija(peli.haeNoppa2());
        noppa2.addItemListener(nopan2Kuuntelija);
        noppa2.setPreferredSize(new Dimension(50, 30));

        heitaNoppaa = new JButton("Heitä noppia!");
        heitaNoppaa.setPreferredSize(new Dimension(140, 30));
        NopanHeittoKuuntelija kuuntelija2 = new NopanHeittoKuuntelija();
        heitaNoppaa.addActionListener(kuuntelija2);

        alaOsio.setMaximumSize(new Dimension(690, 75));

        alaOsio.add(Box.createRigidArea(new Dimension(20, 0)));
        alaOsio.add(luovutaVuoro);
        alaOsio.add(Box.createRigidArea(new Dimension(20, 0)));
        alaOsio.add(ilmoitusKenttaScroll);
        alaOsio.add(noppa1);
        alaOsio.add(heitaNoppaa);
        alaOsio.add(noppa2);

        add(ylaOsio);
        add(alaOsio);

    }

    public JTextArea haeIlmoitusKentta() {
        return this.ilmoitusKentta;
    }

    public JTextArea haePelaajienKodit() {
        return this.pelaajienKodit;
    }

    public JButton haeHeitaNoppaaNappi() {
        return this.heitaNoppaa;
    }

    public PelilaudanPaneeli haePelilaudanPiirtoPaneeli() {
        return this.pelilauta;
    }

    public void asetaNopan1Valinta(boolean tila) {
        this.noppa1.setSelected(tila);
    }

    public void asetaNopan2Valinta(boolean tila) {
        this.noppa2.setSelected(tila);
    }

    public void asetaNopan1Toiminta(boolean tila) {
        this.noppa1.setEnabled(tila);
    }

    public void asetaNopan2Toiminta(boolean tila) {
        this.noppa2.setEnabled(tila);
    }

    public boolean haeNopan1Tila() {
        return noppa1.isSelected();
    }

    public boolean haeNopan2Tila() {
        return noppa2.isSelected();
    }
    
    

    /**
     * Kuuntelee Heitä noppaa-napin painalluksia ja päivittää noppien arvot.
     */
    public class NopanHeittoKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            noppa1.setText("" + peli.heitaNoppaa1());
            noppa2.setText("" + peli.heitaNoppaa2());
            if (peli.haeNopan1Arvo() == peli.haeNopan2Arvo()) {
                peli.asetaHeittojenMaara(4);
            } else {
                peli.asetaHeittojenMaara(2);
            }
            noppa1.setSelected(false);
            noppa2.setSelected(false);
            noppa1.setEnabled(true);
            noppa2.setEnabled(true);

            peli.alustaVuoroLaskuri();
            heitaNoppaa.setEnabled(false);
            peli.asetaNoppaaHeitetty(true);

        }

    }

    /**
     * Kuuntelija joka kuuntelee noppien valintaan liittyviä komentoja.
     */
    public class NopanValintaKuuntelija implements ItemListener {

        Noppa noppa;

        /**
         * Tallentaa nopan luokalle
         * @param noppa Noppa olio
         */
        public NopanValintaKuuntelija(Noppa noppa) {
            this.noppa = noppa;
        }

        /**
         * Tarkistaa jos noppa oli jo valittu vai ei ja muuttaa pelin tilannetta sen mukaan.
         * @param e Napin painallus
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                if (!peli.onkoNoppaaHeitetty()) {
                    haeIlmoitusKentta().append("\nHeitä noppaa!");
                    ilmoitusKentta.setCaretPosition(ilmoitusKentta.getDocument().getLength());
                    return;
                }
                if (noppa == peli.haeNoppa1()) {
                    noppa1.setSelected(true);
                    peli.asetaValittuNoppa(noppa);
                } else {
                    noppa2.setSelected(true);
                    peli.asetaValittuNoppa(noppa);
                }
            } else {
                if (!peli.onkoNoppaaHeitetty()) {
                    haeIlmoitusKentta().append("\nHeitä noppaa!");
                    ilmoitusKentta.setCaretPosition(ilmoitusKentta.getDocument().getLength());
                    return;
                }
                if (noppa == peli.haeNoppa1()) {
                    noppa1.setSelected(false);
                    peli.asetaValittuNoppa(peli.haeToinenNoppa(peli.haeValittuNoppa()));
                } else {
                    noppa2.setSelected(false);
                    peli.asetaValittuNoppa(peli.haeToinenNoppa(peli.haeValittuNoppa()));
                }
            }
        }

    }

    /**
     * Kuuntelija joka hallitee Luovuta vuoro-nappia ja sen toiminnallisuutta
     */
    public class VuoronLuovutusKuuntelija implements ActionListener {

        /**
         * Tarkistaa jos mahdollisia siirtoja on jäljellä, jos ei niin luovuttaa vuoron
         * @param e Napin painallus
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (peli.voikoLuovuttaaVuoron() == 1) {
                ilmoitusKentta.append("\nHeitä noppia!");
                ilmoitusKentta.setCaretPosition(ilmoitusKentta.getDocument().getLength());
                return;
            }
            if (peli.voikoLuovuttaaVuoron() == 2) {
                ilmoitusKentta.append("\nMahdollisia siirtoja jäljellä!");
                ilmoitusKentta.setCaretPosition(ilmoitusKentta.getDocument().getLength());
                return;
            }
            peli.asetaPelaajaVuorossa(peli.haePelaajaVuorossa().haeVastustaja());
            ilmoitusKentta.append("\nPelaajan " + peli.haePelaajaVuorossa().haePelaajanNimi() + " vuoro!");
            ilmoitusKentta.setCaretPosition(ilmoitusKentta.getDocument().getLength());
            heitaNoppaa.setEnabled(true);
            peli.asetaNoppaaHeitetty(false);
            if (peli.haePelaajaVuorossa() == peli.haePelaaja1()) {
                setBackground(Color.BLACK);
            } else {
                setBackground(Color.WHITE);
            }

        }

    }
}
