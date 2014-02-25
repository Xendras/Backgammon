/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Paneeli joka tulee sisältämään aloitusvalikon.
 *
 * @author Jonas Westerlund
 */
public class AloitusValikkoPaneeli extends JPanel {

    JPanel paneeli;
    JLabel tervetuloaTeksti;
    JPanel nappulat;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    Scanner tiedostonLukija;
    String saannotTeksti;
    JDialog saannotDialog;

    /**
     * Luo paneelin joka tulee sisältämään tervetuloviestin, Aloita peli-napin,
     * Vaihda pelaajaa-napin, Lue säännöt-napin, sekä Lopeta peli-napin.
     *
     * @param peli
     * @param graafinen
     * @throws java.io.FileNotFoundException
     */
    public AloitusValikkoPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen) throws FileNotFoundException {

        alustaSaannot();
        saannotDialog = new JDialog();
        setPreferredSize(new Dimension(450,100));

        this.peli = peli;
        this.graafinen = graafinen;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        tervetuloaTeksti = new JLabel("Tervetuloa Backgammon-peliin!");
        tervetuloaTeksti.setAlignmentX(Component.CENTER_ALIGNMENT);

        nappulat = new JPanel();
        nappulat.setLayout(new BoxLayout(nappulat, BoxLayout.X_AXIS));

        JButton aloitus = new JButton("Aloita peli");
        nappulat.add(aloitus);
        PelinAloitusKuuntelija aloitusKuuntelija = new PelinAloitusKuuntelija();
        aloitus.addActionListener(aloitusKuuntelija);

        JButton saannot = new JButton("Lue säännöt");
        nappulat.add(saannot);
        LueSaannotKuuntelija saannotKuuntelija = new LueSaannotKuuntelija();
        saannot.addActionListener(saannotKuuntelija);

        JButton lopeta = new JButton("Lopeta peli");
        nappulat.add(lopeta);
        LopetaPeliKuuntelija lopetaKuuntelija = new LopetaPeliKuuntelija();
        lopeta.addActionListener(lopetaKuuntelija);

        nappulat.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(tervetuloaTeksti);
        add(nappulat);

    }

    public void alustaSaannot() {
        File kayttoOhje = new File("Käyttöohje.txt");
        try {
            this.tiedostonLukija = new Scanner(kayttoOhje);
        } catch (FileNotFoundException e) {
            return;
        }

        saannotTeksti = "";
        while (tiedostonLukija.hasNextLine()) {
            saannotTeksti += tiedostonLukija.nextLine() + "\n";
        }
    }

    /**
     * Tulee toimimaan Aloita peli-napin kuuntelijana
     */
    public class PelinAloitusKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            graafinen.siirryPelaajienNimetPaneeliin();
        }

    }

    public class LueSaannotKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JTextArea saannotAlue = new JTextArea(saannotTeksti);
            saannotAlue.setEditable(false);
            JScrollPane saannotAlueScroll = new JScrollPane(saannotAlue);
            saannotDialog.add(saannotAlueScroll);
            saannotDialog.setVisible(true);
            saannotDialog.setModal(true);
            saannotDialog.setLocationRelativeTo(null);
            saannotDialog.setSize(new Dimension(550,500));
            saannotDialog.setResizable(false);
        }

    }

    public class LopetaPeliKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
