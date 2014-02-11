package PelinKayttoliittyma.Graafinen;

import PelinKayttoliittyma.Kuuntelijat.PelaajanLisaysKuuntelija;
import PelinKayttoliittyma.Teksti.TekstiUI;
import PelinOsat.Pelikokonaisuus;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraafinenUI implements Runnable {

    private JFrame frame;
    private Pelikokonaisuus peli;

    public GraafinenUI(Pelikokonaisuus peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("Backgammon");
        frame.setPreferredSize(new Dimension(700, 550));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        haeContentPane().add(new PelilaudanPiirtoPaneeli());
//        alustaPelaajienNimetPaneeli();
        frame.setResizable(false);

        frame.pack();
        frame.setVisible(true);
    }
    
    public void siirryAloitusPaneeliin(){
        haeFrame().setSize(new Dimension(400, 175));
        frame.getContentPane().removeAll();
        AloitusValikkoPaneeli aloitusValikko = new AloitusValikkoPaneeli(peli,this);
        haeContentPane().add(aloitusValikko.haePaneeli(), BorderLayout.CENTER);
        haeContentPane().repaint();
        
    }
    
    public void siirryPeliPaneeliin(){
        haeFrame().setSize(new Dimension(700, 300));
        frame.getContentPane().removeAll();
        PeliPaneeli peliNakyma = new PeliPaneeli(this.peli,this);
        haeContentPane().add(peliNakyma.haePaneeli(), BorderLayout.CENTER);
        haeContentPane().repaint();
        
    }
    
    public void alustaPelaajienNimetPaneeli(){
        PelaajienLisaysPaneeli nimiPaneeli = new PelaajienLisaysPaneeli(peli,this);
        frame.getContentPane().add(nimiPaneeli.haePaneeli());
    }

    public JFrame haeFrame(){
        return this.frame;
    }
    
    public Container haeContentPane(){
        return this.frame.getContentPane();
    }

    
    

}
