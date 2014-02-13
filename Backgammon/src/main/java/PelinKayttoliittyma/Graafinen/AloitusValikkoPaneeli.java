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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Paneeli joka tulee sisältämään aloitusvalikon.
 * @author Jonas Westerlund
 */
public class AloitusValikkoPaneeli extends JPanel {
    
    JPanel paneeli;
    JLabel tervetuloaTeksti;
    JPanel nappulat;
    JLabel pelaaja1Teksti;
    JLabel pelaaja2Teksti;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    
    /**
     * Luo paneelin joka tulee sisältämään tervetuloviestin, Aloita peli-napin, Vaihda pelaajaa-napin, Lue säännöt-napin, sekä Lopeta peli-napin.
     * @param peli
     * @param graafinen
     */
    public AloitusValikkoPaneeli(Pelikokonaisuus peli,GraafinenUI graafinen){
        this.peli = peli;
        this.graafinen = graafinen;
        
        setLayout(new GridLayout(2,2));
        
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
        
        add(tervetuloaTeksti);
        add(nappulat);
        add(pelaaja1Teksti);
        add(pelaaja2Teksti);

        
    }
    
    /**
     * Tulee toimimaan Aloita peli-napin kuuntelijana
     */
    public class PelinAloitusKuuntelija implements ActionListener { 

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

    
}
