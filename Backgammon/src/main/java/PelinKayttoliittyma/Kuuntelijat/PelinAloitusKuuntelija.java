
package PelinKayttoliittyma.Kuuntelijat; 

import PelinKayttoliittyma.Graafinen.GraafinenUI;
import PelinOsat.Pelikokonaisuus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PelinAloitusKuuntelija implements ActionListener { 

    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    
    public PelinAloitusKuuntelija(Pelikokonaisuus peli, GraafinenUI graafinen){
        this.peli = peli;
        this.graafinen = graafinen;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

} 