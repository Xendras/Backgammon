/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import PelinKayttajat.Pelaaja;

/**
 *
 * @author Xendra
 */
public class PelilautaTest {
    Pelilauta lauta;
    Pelinappula nappula;
    Pelaaja pelaaja;
    
    public PelilautaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pelaaja = new Pelaaja('x');
        lauta = new Pelilauta(10);
        nappula = new Pelinappula(3,pelaaja,lauta);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaLaudanKoonOikein(){
        int koko = this.lauta.haeLauta().length;
        assertEquals(10,koko);
    }
    
    @Test
    public void pelinappulaLisataanOikeallePaikalle(){
        lauta.lisaaPelinappula(nappula);
        assertEquals(nappula,lauta.haeLauta()[3]);
    }
    
    @Test
    public void pelinappulanSijaintiAsetetaanOikein(){
        assertEquals(3,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataLaudanUlkopuolelle(){
        nappula = new Pelinappula(10,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        boolean toimiko = true;
        for(int i = 0;i < 10;i++){
            if(lauta.haeLauta()[i] != null){
                toimiko = false;
            }
        }
        assertEquals(true,toimiko);
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalle(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaa(nappula, 4);
        assertEquals(nappula,lauta.haeLauta()[7]);
    }
    
    @Test
    public void pelinappulanSijaintiMuuttuuOikein(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaa(nappula, 4);
        assertEquals(7,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaNegatiivistaMaaraa(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaa(nappula, -1);
        assertEquals(nappula,lauta.haeLauta()[3]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaToisenNappulanPaalle(){
        Pelinappula nappula2 = new Pelinappula(5,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        lauta.lisaaPelinappula(nappula2);
        lauta.siirraPelinappulaa(nappula, 2);
        assertEquals(nappula,lauta.haeLauta()[3]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosLaudalta(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaa(nappula, 8);
        assertEquals(nappula,lauta.haeLauta()[3]);
    }
    
    @Test
    public void pelilautaTulostuuOikein(){
        Pelilauta lauta2 = new Pelilauta(4);
        nappula = new Pelinappula(3,pelaaja,lauta2);
        lauta2.lisaaPelinappula(nappula);
        String lautaTulostus = lauta2.tulostaPelilauta();
        assertEquals("[] [] [] [x] ",lautaTulostus);
    }
}
