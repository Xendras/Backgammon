/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen; 

import PelinOsat.Pelikokonaisuus;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

/**
 * Luokka joka sisältää pelipaneelin jossa itse peli tapahtuu.
 * @author Jonas Westerlund
 */
public class PeliPaneeli extends JPanel { 
    
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    JLabel noppa1;
    JLabel noppa2;
    JTextField ilmoitusKentta;
    JButton heitaNoppaa;
    PelilaudanPiirtoPaneeli pelilauta;

    /**
     * Luo paneelin joka koostuu piirrettävästä paneelista sekä paneelin alaosasta jossa on toimintoja.
     * @param peli Pelikokonaisuus jota paneeli ohjaa.
     * @param graafinen Käyttöliittymä jossa paneeli on.
     */
    public PeliPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen){
        this.peli = peli;
        this.graafinen = graafinen;
        
        pelilauta = new PelilaudanPiirtoPaneeli(peli,graafinen,this);
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(520, 635));
        
        JPanel alaOsio = new JPanel();
        alaOsio.setLayout(new BoxLayout(alaOsio,BoxLayout.X_AXIS));
        
        ilmoitusKentta = new JTextField("Pelaaja " + peli.haePelaaja1().haePelaajanNimi() + " aloittaa!");
        ilmoitusKentta.setEditable(false);
        ilmoitusKentta.setPreferredSize(new Dimension(70,75));
        noppa1 = new JLabel("", SwingConstants.CENTER);
        noppa1.setPreferredSize(new Dimension(50,75));
        noppa2 = new JLabel("", SwingConstants.CENTER);
        noppa2.setPreferredSize(new Dimension(50,75));
        heitaNoppaa = new JButton("Heitä noppia!");
        heitaNoppaa.setPreferredSize(new Dimension(120,75));
        
        NopanHeittoKuuntelija kuuntelija = new NopanHeittoKuuntelija();
        heitaNoppaa.addActionListener(kuuntelija);
        
        alaOsio.setPreferredSize(new Dimension(520,75));
        
        alaOsio.add(ilmoitusKentta);
        alaOsio.add(noppa1);
        alaOsio.add(heitaNoppaa);
        alaOsio.add(noppa2);
        
        
        add(pelilauta);
        add(alaOsio);
        
    }
    
    public JTextField haeIlmoitusKentta(){
        return this.ilmoitusKentta;
    }
    
    public JButton haeHeitaNoppaaNappi(){
        return this.heitaNoppaa;
    }
    
    public PelilaudanPiirtoPaneeli haePelilaudanPiirtoPaneeli(){
        return this.pelilauta;
    }
    
    /**
     * Kuuntelee Heitä noppaa-napin painalluksia ja päivittää noppien arvot.
     */
    public class NopanHeittoKuuntelija implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            noppa1.setText(""+peli.heitaNoppaa1());
            noppa2.setText(""+peli.heitaNoppaa2());
            heitaNoppaa.setEnabled(false);
            
        }
        
        
    }
} 