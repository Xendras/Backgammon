package PelinKayttoliittyma.Graafinen;

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
        frame.setPreferredSize(new Dimension(830, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());

        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {

//        GridLayout layout = new GridLayout(3, 2);
//        container.setLayout(layout);
//
//        JLabel pelaaja1 = new JLabel("Pelaaja 1: ");
//        JTextField nimi1Kentta = new JTextField();
//        JLabel pelaaja2 = new JLabel("Pelaaja 2: ");
//        JTextField nimi2Kentta = new JTextField();
//
//        JButton lisaaPelaajat = new JButton("Lisää pelaajat!");
//        PelaajanLisaysKuuntelija kuuntelija = new PelaajanLisaysKuuntelija(peli, nimi1Kentta, nimi2Kentta);
//        lisaaPelaajat.addActionListener(kuuntelija);
//
//        container.add(pelaaja1);
//        container.add(nimi1Kentta);
//        container.add(pelaaja2);
//        container.add(nimi2Kentta);
//        container.add(new JLabel(""));
//        container.add(lisaaPelaajat);
        try {
            BufferedImage backgammon = ImageIO.read(new File("src/images/backgammonLautaResize.gif"));
            JLabel backgammonLabel = new JLabel(new ImageIcon(backgammon));
            container.add(backgammonLabel, BorderLayout.WEST);
        } catch (IOException e) {

        }
        container.add(luoTietoalue(), BorderLayout.EAST);
    }

    public JPanel luoValikko() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        JButton aloita = new JButton("Aloita peli");
        aloita.setBounds(415,250,50,100);
        panel.add(aloita);
        
        panel.add(new JButton("Siirrä nappulaa"));
        panel.add(new JButton("Lopeta Peli"));
        return panel;
    }

    public JPanel luoTietoalue() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Pelaajan 1 vuoro!"));
        panel.add(luoValikko());
        return panel;
    }

}
