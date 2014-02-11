/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.Component;
import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AloitusValikkoPaneeli {
    
    JPanel paneeli;
    
    public AloitusValikkoPaneeli(Pelikokonaisuus peli,GraafinenUI graafinen){
        paneeli = new JPanel();
        graafinen.haeFrame().getContentPane().setLayout(new BoxLayout(graafinen.haeFrame().getContentPane(),BoxLayout.PAGE_AXIS));
        paneeli.setLayout(new BoxLayout(paneeli,BoxLayout.PAGE_AXIS));
        paneeli.setAlignmentX(Component.CENTER_ALIGNMENT);
        paneeli.add(new JLabel("Tervetuloa Backgammon-peliin!"));
        paneeli.add(new JLabel(""));
        
        JPanel nappulat = new JPanel();
        nappulat.setLayout(new BoxLayout(nappulat,BoxLayout.LINE_AXIS));
        nappulat.setAlignmentX(Component.CENTER_ALIGNMENT);
        nappulat.add(new JButton("Aloita peli"));    
        nappulat.add(new JButton("Lue säännöt"));
        nappulat.add(new JButton("Lopeta peli"));
        
        paneeli.add(nappulat);
        
        paneeli.add(new JLabel(""));
        paneeli.add(new JLabel("Pelaaja 1: " + peli.haePelaaja1().haePelaajanNimi() + " (Nappulan väri musta)"));
        paneeli.add(new JLabel("Pelaaja 2: " + peli.haePelaaja2().haePelaajanNimi() + " (Nappulan väri valkoinen)"));
    }
    
    public JPanel haePaneeli() {
        return paneeli;
    }

    
}
