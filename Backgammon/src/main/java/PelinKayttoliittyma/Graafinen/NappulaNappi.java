/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author jonas
 */
public class NappulaNappi extends JButton {
    
    int sijaintiLaudalla;
    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    
    public NappulaNappi(Pelikokonaisuus peli,GraafinenUI graafinen,int sijaintiLaudalla){
        this.sijaintiLaudalla = sijaintiLaudalla;
        this.peli = peli;
        NappulanKuuntelija kuuntelija = new NappulanKuuntelija();
        addActionListener(kuuntelija);
        this.graafinen = graafinen;
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
    
    public class NappulanKuuntelija implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            peli.siirraPelinappulaa(sijaintiLaudalla, peli.haeNopan1Arvo());
            graafinen.haeContentPane().repaint();
        }
        
    }
}
