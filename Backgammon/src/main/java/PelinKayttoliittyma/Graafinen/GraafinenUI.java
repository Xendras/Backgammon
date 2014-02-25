package PelinKayttoliittyma.Graafinen;

import PelinKayttoliittyma.Teksti.TekstiUI;
import PelinOsat.Pelikokonaisuus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 * Graafinen käyttöliittymä joka hallitsee kaikkia käyttöliittymän paneeleja.
 * @author Jonas Westerlund
 */
public class GraafinenUI implements Runnable {

    private JFrame frame;
    private Pelikokonaisuus peli;


    @Override
    public void run() {
        frame = new JFrame("Backgammon");

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        try {
            siirryAloitusPaneeliin();
        } catch (FileNotFoundException ex) {
            return;
        }
        frame.setResizable(false);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Metodi joka siirtyy aloituspaneeliin käyttöliittymässä. Muuttaa ikkunan suuruudeen ja piirtää käyttöliittymän uudestaan
     */
    public void siirryAloitusPaneeliin() throws FileNotFoundException{
        frame.getContentPane().removeAll();
        frame.setSize(new Dimension(450, 100));
        frame.setLocationRelativeTo(null);
        AloitusValikkoPaneeli aloitusValikko = new AloitusValikkoPaneeli(peli,this);
        haeContentPane().add(aloitusValikko, BorderLayout.CENTER);
        haeContentPane().revalidate();
        haeContentPane().repaint();
        
    }
    
    /**
     * Metodi joka siirtyy itse pelipaneeliin käyttöliittymässä. Muuttaa ikkunan suuruudeen ja piirtää käyttöliittymän uudestaan
     */
    public void siirryPeliPaneeliin(){ 
        frame.setSize(new Dimension(770, 675)); // 527x655 oletus
        frame.getContentPane().removeAll();
        frame.setLocationRelativeTo(null);
        PeliPaneeli peliNakyma = new PeliPaneeli(this.peli,this);
        haeContentPane().add(peliNakyma, BorderLayout.CENTER);
        haeContentPane().revalidate();
        haeContentPane().repaint();
        
    }
    
    /**
     * Metodi joka siirtyy pelaajien nimeämis paneeliin käyttöliittymässä.
     */
    public void siirryPelaajienNimetPaneeliin(){
        this.peli = new Pelikokonaisuus();
        frame.getContentPane().removeAll();
        frame.setPreferredSize(new Dimension(300, 100));
        frame.setLocationRelativeTo(null);
        PelaajienLisaysPaneeli nimiPaneeli = new PelaajienLisaysPaneeli(peli,this);
        frame.getContentPane().add(nimiPaneeli);
        haeContentPane().revalidate();
        haeContentPane().repaint();
    }

    public JFrame haeFrame(){
        return this.frame;
    }
    
    public Container haeContentPane(){
        return this.frame.getContentPane();
    }

    
    

}
