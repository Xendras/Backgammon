package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(new Dimension(400,100));
        frame.setJMenuBar(luoMenuBar());
       
        try {
            siirryAloitusPaneeliin();
        } catch (FileNotFoundException ex) {
            return;
        }

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    /**
     * Metodi joka siirtyy aloituspaneeliin käyttöliittymässä. Muuttaa ikkunan suuruudeen ja piirtää käyttöliittymän uudestaan
     * @throws java.io.FileNotFoundException
     */
    public void siirryAloitusPaneeliin() throws FileNotFoundException{
        AloitusValikkoPaneeli aloitusValikko = new AloitusValikkoPaneeli(peli,this);
        frame.setSize(new Dimension(400, 100));
        frame.setContentPane(aloitusValikko);
        frame.pack();
        frame.setLocationRelativeTo(null);
        
    }
    
    /**
     * Metodi joka siirtyy itse pelipaneeliin käyttöliittymässä. Muuttaa ikkunan suuruudeen ja piirtää käyttöliittymän uudestaan
     */
    public void siirryPeliPaneeliin(){         
        PeliPaneeli peliNakyma = new PeliPaneeli(this.peli,this);
        frame.setSize(new Dimension(740,710));
        frame.setContentPane(peliNakyma);
        frame.pack();
        frame.setLocationRelativeTo(null);
        
    }
    
    /**
     * Metodi joka siirtyy pelaajien nimeämis paneeliin käyttöliittymässä.
     */
    public void siirryPelaajienNimetPaneeliin(){
        this.peli = new Pelikokonaisuus();   
        PelaajienLisaysPaneeli nimiPaneeli = new PelaajienLisaysPaneeli(peli,this);
        frame.setSize(new Dimension(400, 200));
        frame.setContentPane(nimiPaneeli);
       frame.pack();
       frame.setLocationRelativeTo(null);
    }
    
    /**
     * Luo JFrame oliolle valikon framen yläkulmaan.
     * @return Palauttaa valikon
     */
    public JMenuBar luoMenuBar(){
        JMenuBar valikko = new JMenuBar();
        JMenu backgammon = new JMenu("Backgammon");
        
        JMenuItem palaaAlkuvalikkoon = new JMenuItem("Palaa alkuvalikkoon");
        AlkuValikkoKuuntelija aloitusKuuntelija = new AlkuValikkoKuuntelija();
        palaaAlkuvalikkoon.addActionListener(aloitusKuuntelija);
        
        JMenuItem lueSaannot = new JMenuItem("Lue säännöt");
        LueSaannotKuuntelija saannotKuuntelija = new LueSaannotKuuntelija();
        lueSaannot.addActionListener(saannotKuuntelija);
        
        JMenuItem lopeta = new JMenuItem("Lopeta peli");
        LopetaPeliKuuntelija lopetaKuuntelija = new LopetaPeliKuuntelija();
        lopeta.addActionListener(lopetaKuuntelija);
        
        valikko.add(backgammon);
        
        backgammon.add(palaaAlkuvalikkoon);
        backgammon.add(lueSaannot);
        backgammon.add(lopeta);
        
        return valikko;
    }

    public JFrame haeFrame(){
        return this.frame;
    }
    
    public Container haeContentPane(){
        return this.frame.getContentPane();
    }
    
    /**
     * Palaa alkuvalikkoon-napin kuuntelija
     */
    public class AlkuValikkoKuuntelija implements ActionListener {

        /**
         * Palaa aloituspaneeliin nappia painettaessa
         * @param e Napin painallus
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                siirryAloitusPaneeliin();
            } catch (FileNotFoundException ex) {
                
            }
        }

    }

    /**
     * Lue säännöt-napin kuuntelija
     */
    public class LueSaannotKuuntelija implements ActionListener {

        Scanner tiedostonLukija;
        String saannotTeksti;
        JDialog saannotDialog;

        /**
         * Alustaa säännöt kuuntelijalle
         */
        public LueSaannotKuuntelija() {
            alustaSaannot();
        }

        /**
         * Avaa ikkunan johon lisätään käyttöohjeet
         * @param e Napin painallus
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            saannotDialog = new JDialog();
            JTextArea saannotAlue = new JTextArea(saannotTeksti);
            saannotAlue.setEditable(false);
            JScrollPane saannotAlueScroll = new JScrollPane(saannotAlue);
            saannotDialog.add(saannotAlueScroll);
            saannotDialog.setVisible(true);
            saannotDialog.setModal(true);
            saannotDialog.setLocationRelativeTo(null);
            saannotDialog.setSize(new Dimension(600, 500));
            saannotDialog.setResizable(true);
        }

        /**
         * Lukee käyttöohjeista tekstin String olioon
         */
        public void alustaSaannot() {
            File kayttoOhje = new File("Käyttöohje.txt");
            try {
                this.tiedostonLukija = new Scanner(new FileInputStream(kayttoOhje), "UTF8");
            } catch (FileNotFoundException e) {
                return;
            }

            saannotTeksti = "";
            while (tiedostonLukija.hasNextLine()) {
                saannotTeksti += tiedostonLukija.nextLine() + "\n";
            }
        }

    }

    /**
     * Lopeta peli-napin kuuntelija
     */
    public class LopetaPeliKuuntelija implements ActionListener {

        /**
         * Sulkee pelin
         * @param e Napin painallus
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}
