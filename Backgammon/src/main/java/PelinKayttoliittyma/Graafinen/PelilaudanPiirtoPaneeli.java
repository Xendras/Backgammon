/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma.Graafinen; 

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;


public class PelilaudanPiirtoPaneeli extends JPanel { 

    public PelilaudanPiirtoPaneeli(){
        super.setBackground(Color.WHITE);
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for(int i = 0;i<300;i += 50){
            drawTriangle(graphics,10+i,500,60+i,500,35+i,300,3); 
        }
        graphics.drawRect(310, 50, 50, 450);
        for(int i = 350;i<650;i += 50){
            drawTriangle(graphics,10+i,500,60+i,500,35+i,300,3); 
        }
        
        for(int i = 0;i<300;i += 50){
            drawTriangle(graphics,10+i,50,60+i,50,35+i,250,3); 
        }
        
        for(int i = 350;i<650;i += 50){
            drawTriangle(graphics,10+i,50,60+i,50,35+i,250,3); 
        }
        
    }
    
    public void drawTriangle(Graphics graphics,int x1, int y1,int x2, int y2,int x3, int y3, int i){
        int[] x = {x1,x2,x3};
        int[] y = {y1,y2,y3};
        graphics.drawPolygon(x,y,i);
    }
} 