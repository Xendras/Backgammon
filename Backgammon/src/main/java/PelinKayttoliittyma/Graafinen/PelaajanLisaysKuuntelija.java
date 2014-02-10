/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen; 

import PelinKayttajat.Pelaaja;
import PelinKayttoliittyma.Teksti.TekstiUI;
import PelinOsat.Pelikokonaisuus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class PelaajanLisaysKuuntelija implements ActionListener { 

    public Pelikokonaisuus peli;
    public JTextField nimi1Kentta;
    public JTextField nimi2Kentta;
    
    
    public PelaajanLisaysKuuntelija(Pelikokonaisuus peli, JTextField nimi1Kentta, JTextField nimi2Kentta){
        this.peli = peli;
        this.nimi1Kentta = nimi1Kentta;
        this.nimi2Kentta = nimi2Kentta;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        peli.asetaPelaaja1(new Pelaaja(nimi1Kentta.getText(), 'X', peli, peli.haePelaaja1Nappulat(), peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti()));
        peli.asetaPelaaja2(new Pelaaja(nimi2Kentta.getText(), 'O', peli, peli.haePelaaja2Nappulat(), peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()));
        peli.haePelaaja1().asetaVastustaja(peli.haePelaaja2());
        peli.haePelaaja2().asetaVastustaja(peli.haePelaaja1());
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        pelinAlustus();
    }
    
    public void pelinAlustus(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
    }

} 