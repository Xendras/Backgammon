/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Polygon;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Luokka jossa pelin sisältö piirretään. Sisältää myös paneelin joka vastaa nappuloiden toiminnallisuudesta.
 * @author Jonas Westerlund
 */
public class PelilaudanPaneeli extends JPanel {

    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    Color tausta;
    Color kolmio1;
    Color kolmio2;
    int nappuloidenMaara;
    ArrayList<JButton> nappuloidenNappulat;
    PeliPaneeli peliPaneeli;
    
    /**
     * Pelikentän korkeus
     */
    public static final int KentanKorkeus = 560;

    /**
     * Kolmion korkeus
     */
    public static final int KolmionKorkeus = 230;

    /**
     * Pelikentän leveys
     */
    public static final int KentanLeveys = 520;

    /**
     * Kolmion (ja myös pelinappulan) leveys
     */
    public static final int KolmionLeveys = KentanLeveys/13;

    /**
     * Luo paneelin joka koostuu piirrettävästä osuudesta (pelilauta sekä pelinappulat) sekä JButton-gridistä joka ohjaa pelinappuloita.
     * @param peli Pelikokonaisuus jota paneeli ohjaa.
     * @param graafinen Käyttöliittymä johon paneeli kuuluu.
     * @param peliPaneeli Paneeli johon tämä paneeli kuuluu.
     */
    public PelilaudanPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen, PeliPaneeli peliPaneeli) {
        this.peli = peli;
        this.graafinen = graafinen;
        this.peliPaneeli = peliPaneeli;
        this.tausta = new Color(255,228,196);
        this.kolmio1 = new Color(205,133,63);
        this.kolmio2 = new Color(139,69,19);
               
        super.setBackground(tausta);
        setMaximumSize(new Dimension(KentanLeveys,KentanKorkeus));
        setMinimumSize(new Dimension(KentanLeveys,KentanKorkeus));

        setLayout(new GridLayout(14, 13));
        
        alustaNappulat();
        
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraPelilauta(graphics);
        piirraNumerot(graphics);
        piirraNappulat(graphics);
    }
    
    /**
     * Muuttaa pelinappuloita ohjaavien JButton-nappien toiminnallisuutta.
     * @param tila
     */
    public void muutaNappuloidenTilaa(boolean tila){
        for(JButton nappi:nappuloidenNappulat){
            nappi.setEnabled(tila);
        }
    }
    
    /**
     * Alustaa JButton-gridin pelilaudan päälle.
     */
    public void alustaNappulat(){
        nappuloidenNappulat = new ArrayList<JButton>();
        
        for(int i = 0 ; i<7;i++){
            for(int k = 13; k<19;k++){
                NappulaNappi nappi = new NappulaNappi(peli,graafinen,peliPaneeli,k);
                nappuloidenNappulat.add(nappi);
                add(nappi);
            }
            
            add(new NappulaNappi(peli,graafinen,peliPaneeli,0));
        
            for(int k = 19; k<25;k++){
                NappulaNappi nappi = new NappulaNappi(peli,graafinen,peliPaneeli,k);
                nappuloidenNappulat.add(nappi);
                add(nappi);
            }

        }
        
        for(int i = 0 ; i<7;i++){
            for(int k = 12; k>6;k--){
                NappulaNappi nappi = new NappulaNappi(peli,graafinen,peliPaneeli,k);
                nappuloidenNappulat.add(nappi);
                add(nappi);
            }
            
            add(new NappulaNappi(peli,graafinen,peliPaneeli,0));
        
            for(int k = 6; k>0;k--){
                NappulaNappi nappi = new NappulaNappi(peli,graafinen,peliPaneeli,k);
                nappuloidenNappulat.add(nappi);
                add(nappi);
            }
        }
    }
    
    public void piirraNumerot(Graphics graphics){
        graphics.setColor(Color.BLACK);
        for(int i = 1; i < 7;i++){
            graphics.drawString(String.valueOf(i),(13-i)*KolmionLeveys + 3*KolmionLeveys/7,KentanKorkeus-6*KolmionLeveys);
        }
        
        for(int i = 7; i < 13;i++){
            graphics.drawString(String.valueOf(i),(12-i)*KolmionLeveys + 3*KolmionLeveys/7,KentanKorkeus-6*KolmionLeveys);
        }
        
        for(int i = 13; i < 19;i++){
            graphics.drawString(String.valueOf(i),(i-13)*KolmionLeveys + 3*KolmionLeveys/7,6*KolmionLeveys+KolmionLeveys/4);
        }
        
        for(int i = 19; i < 25;i++){
            graphics.drawString(String.valueOf(i),(i-12)*KolmionLeveys + 3*KolmionLeveys/7,6*KolmionLeveys+KolmionLeveys/4);
        }
    }
    public void piirraNappulat(Graphics graphics){
        for(int i = 0; i < 6;i++){
            nappuloidenMaara = peli.haePelilaudanNappulat().get(i+13).size();
            for(int k = 0; k< nappuloidenMaara;k++){
                if(peli.haePelilaudanNappulat().get(i+13).get(k).haePelinappulanOmistaja() == peli.haePelaaja1()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(i*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(i*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                }
            }
        }
        
            nappuloidenMaara = peli.haePelaajan2Jaahy().size();
            for(int k = 0; k< nappuloidenMaara;k++){
                
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(6*KolmionLeveys, (6-k)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                
            }
            
            nappuloidenMaara = peli.haePelaajan1Jaahy().size();
            for(int k = 0; k< nappuloidenMaara;k++){
                
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(6*KolmionLeveys, KentanKorkeus- (7-k)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                
            }
        
        
        for(int i = 6; i < 12;i++){
            nappuloidenMaara = peli.haePelilaudanNappulat().get(i+13).size();
            for(int k = 0; k< nappuloidenMaara;k++){
                if(peli.haePelilaudanNappulat().get(i+13).get(k).haePelinappulanOmistaja() == peli.haePelaaja1()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval((i+1)*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval((i+1)*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                }
            }
        }
        
        for(int i = 0; i < 6 ;i++){
            nappuloidenMaara = peli.haePelilaudanNappulat().get(12-i).size();
            for(int k = 0; k< nappuloidenMaara;k++){
                if(peli.haePelilaudanNappulat().get(12-i).get(k).haePelinappulanOmistaja() == peli.haePelaaja1()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(i*KolmionLeveys, KentanKorkeus-(k+1)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(i*KolmionLeveys, KentanKorkeus-(k+1)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                }
            }
        }
        
        for(int i = 6; i < 12 ;i++){
            nappuloidenMaara = peli.haePelilaudanNappulat().get(12-i).size();
            for(int k = 0; k< nappuloidenMaara;k++){
                if(peli.haePelilaudanNappulat().get(12-i).get(k).haePelinappulanOmistaja() == peli.haePelaaja1()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval((i+1)*KolmionLeveys, KentanKorkeus-(k+1)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval((i+1)*KolmionLeveys, KentanKorkeus-(k+1)*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                }
            }
        }

    }
    
    public void piirraPelilauta(Graphics graphics){
        
        for (int i = 0; i < (KentanLeveys-KolmionLeveys)/2; i += KolmionLeveys*2) {
            drawLightTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, KolmionLeveys/2 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        for (int i = KolmionLeveys; i < (KentanLeveys-KolmionLeveys)/2; i += KolmionLeveys*2) {
            drawNormalTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, KolmionLeveys/2 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        graphics.setColor(new Color(105,105,105));
        graphics.fillRect((KentanLeveys-KolmionLeveys)/2, 0, KolmionLeveys, KentanKorkeus);
        for (int i = (KentanLeveys-KolmionLeveys)/2+KolmionLeveys ; i < KentanLeveys; i += KolmionLeveys*2) {
            drawLightTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, KolmionLeveys/2 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        for (int i = (KentanLeveys-KolmionLeveys)/2+2*KolmionLeveys; i < KentanLeveys; i += KolmionLeveys*2) {
            drawNormalTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, KolmionLeveys/2 + i, KentanKorkeus-KolmionKorkeus, 3);
        }

        for (int i = 0; i < (KentanLeveys-KolmionLeveys)/2; i += KolmionLeveys*2) {
            drawNormalTriangle(graphics, i, 0, KolmionLeveys + i, 0, KolmionLeveys/2 + i, KolmionKorkeus, 3);
        }

        for (int i = KolmionLeveys; i < (KentanLeveys-KolmionLeveys)/2; i += KolmionLeveys*2) {
            drawLightTriangle(graphics, i, 0, KolmionLeveys + i, 0, KolmionLeveys/2 + i, KolmionKorkeus, 3);
        }

        for (int i = (KentanLeveys-KolmionLeveys)/2+KolmionLeveys; i < KentanLeveys; i += KolmionLeveys*2) {
            drawNormalTriangle(graphics, i, 0, KolmionLeveys + i, 0, KolmionLeveys/2 + i, KolmionKorkeus, 3);
        }

        for (int i = (KentanLeveys-KolmionLeveys)/2+2*KolmionLeveys; i < KentanLeveys; i += KolmionLeveys*2) {
            drawLightTriangle(graphics, i, 0, KolmionLeveys + i, 0, KolmionLeveys/2 + i, KolmionKorkeus, 3);
        }
    }
    

    public void drawLightTriangle(Graphics graphics, int x1, int y1, int x2, int y2, int x3, int y3, int i) {
        graphics.setColor(kolmio1);
        int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
        graphics.fillPolygon(x, y, i);
    }

    public void drawNormalTriangle(Graphics graphics, int x1, int y1, int x2, int y2, int x3, int y3, int i) {
        graphics.setColor(kolmio2);
        int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
        graphics.fillPolygon(x, y, i);
    }
}
