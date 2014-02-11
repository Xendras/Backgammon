/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen; 

import PelinOsat.Pelikokonaisuus;
import javax.swing.JPanel;


public class PeliPaneeli { 

    JPanel peliPaneeli;
    
    public PeliPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen){
        peliPaneeli = new JPanel();
        
        JPanel pelilauta = new JPanel();
    }
    
    public JPanel haePaneeli(){
        return this.peliPaneeli;
    }
} 