/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma.Graafinen;

import PelinOsat.Pelikokonaisuus;
import java.awt.Color;
import java.awt.Component;
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

    public PelilaudanPiirtoPaneeli(Pelikokonaisuus peli, GraafinenUI graafinen) {
        this.peli = peli;
        this.graafinen = graafinen;
        super.setBackground(Color.WHITE);

        setLayout(new GridLayout(13, 13));

        for (int i = 0; i < 169; i++) {
            add(new JLabel("X", SwingConstants.CENTER));
        }

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i < 300; i += 100) {
            drawLightTriangle(graphics, i, 450, 50 + i, 450, 25 + i, 250, 3);
        }
        for (int i = 50; i < 300; i += 100) {
            drawNormalTriangle(graphics, i, 450, 50 + i, 450, 25 + i, 250, 3);
        }
        graphics.setColor(Color.BLACK);
        graphics.fillRect(300, 0, 50, 450);
        for (int i = 350; i < 650; i += 100) {
            drawLightTriangle(graphics, i, 450, 50 + i, 450, 25 + i, 250, 3);
        }
        for (int i = 400; i < 650; i += 100) {
            drawNormalTriangle(graphics, i, 450, 50 + i, 450, 25 + i, 250, 3);
        }

        for (int i = 0; i < 300; i += 100) {
            drawNormalTriangle(graphics, i, 0, 50 + i, 0, 25 + i, 200, 3);
        }

        for (int i = 50; i < 300; i += 100) {
            drawLightTriangle(graphics, i, 0, 50 + i, 0, 25 + i, 200, 3);
        }

        for (int i = 350; i < 650; i += 100) {
            drawNormalTriangle(graphics, i, 0, 50 + i, 0, 25 + i, 200, 3);
        }

        for (int i = 400; i < 650; i += 100) {
            drawLightTriangle(graphics, i, 0, 50 + i, 0, 25 + i, 200, 3);
        }

    }

    public void drawLightTriangle(Graphics graphics, int x1, int y1, int x2, int y2, int x3, int y3, int i) {
        graphics.setColor(Color.LIGHT_GRAY);
        int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
        graphics.fillPolygon(x, y, i);
    }

    public void drawNormalTriangle(Graphics graphics, int x1, int y1, int x2, int y2, int x3, int y3, int i) {
        graphics.setColor(Color.GRAY);
        int[] x = {x1, x2, x3};
        int[] y = {y1, y2, y3};
        graphics.fillPolygon(x, y, i);
    }
}
