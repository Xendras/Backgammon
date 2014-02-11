/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen;

import PelinKayttoliittyma.Kuuntelijat.PelaajanLisaysKuuntelija;
import PelinOsat.Pelikokonaisuus;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonas
 */
public class PelaajienLisaysPaneeli extends JPanel {
    
    JPanel pelaajienLisaysPaneeli;
    
    public PelaajienLisaysPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen){
        pelaajienLisaysPaneeli = new JPanel();
        GridLayout layout = new GridLayout(3, 2);
        pelaajienLisaysPaneeli.setLayout(layout);

        JLabel pelaaja1 = new JLabel("Pelaaja 1: ");
        JTextField nimi1Kentta = new JTextField();
        JLabel pelaaja2 = new JLabel("Pelaaja 2: ");
        JTextField nimi2Kentta = new JTextField();

        JButton lisaaPelaajat = new JButton("Lisää pelaajat!");
        PelaajanLisaysKuuntelija kuuntelija = new PelaajanLisaysKuuntelija(peli, nimi1Kentta, nimi2Kentta,graafinen);
        lisaaPelaajat.addActionListener(kuuntelija);

        pelaajienLisaysPaneeli.add(pelaaja1);
        pelaajienLisaysPaneeli.add(nimi1Kentta);
        pelaajienLisaysPaneeli.add(pelaaja2);
        pelaajienLisaysPaneeli.add(nimi2Kentta);
        pelaajienLisaysPaneeli.add(new JLabel(""));
        pelaajienLisaysPaneeli.add(lisaaPelaajat);
    }
    
    public JPanel haePaneeli(){
        return this.pelaajienLisaysPaneeli;
    }
}
