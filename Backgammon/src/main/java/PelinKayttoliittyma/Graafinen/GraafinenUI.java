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
        frame.setPreferredSize(new Dimension(300, 150));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        PelaajienLisaysPaneeli nimiPaneeli = new PelaajienLisaysPaneeli(peli,this);
        frame.getContentPane().add(nimiPaneeli.haePaneeli());

        frame.pack();
        frame.setVisible(true);
    }
    
    
    public void poistaLisaaJaPaivitaContentPane(JPanel paneeli){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(paneeli);
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
    
    public JFrame haeFrame(){
        return this.frame;
    }

    
    

}
