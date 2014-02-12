/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelikokonaisuus;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jonas
 */
public class PelaajienLisaysPaneeli extends JPanel {
    
    JLabel pelaaja1;
    JTextField nimi1Kentta;
    JLabel pelaaja2;
    JTextField nimi2Kentta;
    JButton lisaaPelaajat;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    
    public PelaajienLisaysPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen){
        this.peli = peli;
        this.graafinen = graafinen;
        
        setLayout(new GridLayout(3,2));

        pelaaja1 = new JLabel("Pelaaja 1: ");
        nimi1Kentta = new JTextField();
        pelaaja2 = new JLabel("Pelaaja 2: ");
        nimi2Kentta = new JTextField();

        lisaaPelaajat = new JButton("Lisää pelaajat!");
        lisaaPelaajat.addActionListener(new PelaajanLisaysKuuntelija());

        add(pelaaja1);
        add(nimi1Kentta);
        add(pelaaja2);
        add(nimi2Kentta);
        add(new JLabel(""));
        add(lisaaPelaajat);
    }
    
    public class PelaajanLisaysKuuntelija implements ActionListener { 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.asetaPelaaja1(new Pelaaja(nimi1Kentta.getText(), 'X', peli, peli.haePelaaja1Nappulat(), peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti()));
        peli.asetaPelaaja2(new Pelaaja(nimi2Kentta.getText(), 'O', peli, peli.haePelaaja2Nappulat(), peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()));
        peli.haePelaaja1().asetaVastustaja(peli.haePelaaja2());
        peli.haePelaaja2().asetaVastustaja(peli.haePelaaja1());
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        
        graafinen.siirryAloitusPaneeliin();
             
    }
 
}
}
