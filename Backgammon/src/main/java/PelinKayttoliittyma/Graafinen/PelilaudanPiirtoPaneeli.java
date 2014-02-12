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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PelilaudanPiirtoPaneeli extends JPanel {

    Pelikokonaisuus peli;
    GraafinenUI graafinen;
    Color tausta;
    Color kolmio1;
    Color kolmio2;
    int nappuloidenMaara;
    public static final int KolmionLeveys = 50;
    public static final int KentanKorkeus = 700;
    public static final int KolmionKorkeus = 300;
    public static final int KentanLeveys = 650;

    public PelilaudanPiirtoPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen) {
        this.peli = peli;
        this.graafinen = graafinen;
        this.tausta = new Color(255,228,196);
        this.kolmio1 = new Color(205,133,63);
        this.kolmio2 = new Color(139,69,19);
        
        
        super.setBackground(tausta);
        setPreferredSize(new Dimension(660,710));

        setLayout(new GridLayout(14, 13));

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        piirraPelilauta(graphics);
        piirraNappulat(graphics);
        

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
        
        for(int i = 6; i < 12;i++){
            nappuloidenMaara = peli.haePelilaudanNappulat().get(i+13).size();
            for(int k = 0; k< nappuloidenMaara;k++){
                if(peli.haePelilaudanNappulat().get(i+13).get(k).haePelinappulanOmistaja() == peli.haePelaaja1()){
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval((i+1)*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
                } else {
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(i*KolmionLeveys, k*KolmionLeveys, KolmionLeveys, KolmionLeveys);
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
        
        for (int i = 0; i < (KentanLeveys-50)/2; i += 100) {
            drawLightTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, KolmionLeveys/2 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        for (int i = KolmionLeveys; i < (KentanLeveys-50)/2; i += 100) {
            drawNormalTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, 25 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        graphics.setColor(new Color(105,105,105));
        graphics.fillRect(300, 0, KolmionLeveys, KentanKorkeus);
        for (int i = 350; i < KentanLeveys; i += 100) {
            drawLightTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, 25 + i, KentanKorkeus-KolmionKorkeus, 3);
        }
        for (int i = 400; i < KentanLeveys; i += 100) {
            drawNormalTriangle(graphics, i, KentanKorkeus, KolmionLeveys + i, KentanKorkeus, 25 + i, KentanKorkeus-KolmionKorkeus, 3);
        }

        for (int i = 0; i < (KentanLeveys-50)/2; i += 100) {
            drawNormalTriangle(graphics, i, 0, KolmionLeveys + i, 0, 25 + i, KolmionKorkeus, 3);
        }

        for (int i = KolmionLeveys; i < (KentanLeveys-50)/2; i += 100) {
            drawLightTriangle(graphics, i, 0, KolmionLeveys + i, 0, 25 + i, KolmionKorkeus, 3);
        }

        for (int i = 350; i < KentanLeveys; i += 100) {
            drawNormalTriangle(graphics, i, 0, KolmionLeveys + i, 0, 25 + i, KolmionKorkeus, 3);
        }

        for (int i = 400; i < KentanLeveys; i += 100) {
            drawLightTriangle(graphics, i, 0, KolmionLeveys + i, 0, 25 + i, KolmionKorkeus, 3);
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
