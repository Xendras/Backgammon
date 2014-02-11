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
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AloitusValikkoPaneeli {
    
    JPanel paneeli;
    JLabel tervetuloaTeksti;
    JPanel nappulat;
    JLabel pelaaja1Teksti;
    JLabel pelaaja2Teksti;
    
    public AloitusValikkoPaneeli(Pelikokonaisuus peli,GraafinenUI graafinen){
        paneeli = new JPanel();
        paneeli.setLayout(new GridLayout(2,2));
        
        tervetuloaTeksti = new JLabel("Tervetuloa Backgammon-peliin!");
        tervetuloaTeksti.setAlignmentX(Component.CENTER_ALIGNMENT);

        nappulat = new JPanel();
        nappulat.setLayout(new BoxLayout(nappulat,BoxLayout.Y_AXIS));
        nappulat.add(new JButton("Aloita peli"));  
        nappulat.add(new JButton("Vaihda pelaajat"));
        nappulat.add(new JButton("Lue säännöt"));
        nappulat.add(new JButton("Lopeta peli"));
        nappulat.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        pelaaja1Teksti = new JLabel("Pelaaja 1: " + peli.haePelaaja1().haePelaajanNimi() + " (Nappulan väri musta)");
        pelaaja2Teksti = new JLabel("Pelaaja 2: " + peli.haePelaaja2().haePelaajanNimi() + " (Nappulan väri valkoinen)");
        pelaaja1Teksti.setAlignmentX(Component.LEFT_ALIGNMENT);
        pelaaja2Teksti.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        paneeli.add(tervetuloaTeksti);
        paneeli.add(nappulat);
        paneeli.add(pelaaja1Teksti);
        paneeli.add(pelaaja2Teksti);

        
    }
    
    public JPanel haePaneeli(){
        return this.paneeli;
    }

    
}
