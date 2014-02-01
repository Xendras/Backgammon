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
        pelaaja = new Pelaaja("testi",'x');
        lauta = new Pelilauta();
        nappula = new Pelinappula(3,pelaaja,lauta);
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaYlaLaudanKoonOikein(){
        int kokoYla = this.lauta.haeYlaLauta()[4].length;        
        assertEquals(12,kokoYla);
    }
    
    @Test
    public void konstruktoriAsettaaAlaLaudanKoonOikein(){
        int kokoAla = this.lauta.haeAlaLauta()[4].length;        
        assertEquals(12,kokoAla);
    }
    
    @Test
    public void pelinappulaLisataanOikeallePaikalle(){
        lauta.lisaaPelinappula(nappula);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulanSijaintiAsetetaanOikein(){
        assertEquals(3,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataYlaLaudanUlkopuolelle(){
        nappula = new Pelinappula(25,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        boolean toimiko = true;
        for(int i = 0;i < 12;i++){
            if(lauta.haeYlaLauta()[0][i] != null){
                toimiko = false;
            }
        }
        assertEquals(true,toimiko);
    }
    
    @Test
    public void lisaaPelinappulaAsettaaSijainninOikein(){
        nappula = new Pelinappula(23,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        assertEquals(23,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataAlaLaudanUlkopuolelle(){
        nappula = new Pelinappula(0,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        boolean toimiko = true;
        for(int i = 0;i < 12;i++){
            if(lauta.haeAlaLauta()[4][i] != null){
                toimiko = false;
            }
        }
        assertEquals(true,toimiko);
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleYlalaudalla(){
        nappula = new Pelinappula(14,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaaYlalaudalla(nappula, 4);
        assertEquals(nappula,lauta.haeYlaLauta()[0][5]);
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleAlalaudalla(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaaAlalaudalla(nappula, 4);
        assertEquals(nappula,lauta.haeAlaLauta()[4][5]);
    }
    
    @Test
    public void pelinappulanSijaintiMuuttuuOikein(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaaAlalaudalla(nappula, 4);
        assertEquals(7,nappula.haePelinappulanSijainti());
    }
    
    
    @Test
    public void pelinappulaaEiVoiSiirtaaToisenNappulanPaalle(){
        Pelinappula nappula2 = new Pelinappula(5,pelaaja,lauta);
        lauta.lisaaPelinappula(nappula);
        lauta.lisaaPelinappula(nappula2);
        lauta.siirraPelinappulaaAlalaudalla(nappula, 2);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosYlaLaudalta(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaaYlalaudalla(nappula, 23);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosAlaLaudalta(){
        lauta.lisaaPelinappula(nappula);
        lauta.siirraPelinappulaaAlalaudalla(nappula, -3);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
}
