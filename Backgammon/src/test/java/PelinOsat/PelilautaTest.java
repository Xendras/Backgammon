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
    Pelikokonaisuus peli;
    
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
        peli = new Pelikokonaisuus();
        lauta = peli.haePelilauta();
        pelaaja = new Pelaaja("testi",'x',peli);
        nappula = new Pelinappula(pelaaja, peli);
        
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
        lauta.lisaaPelinappula(nappula,3);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulanSijaintiAsetetaanOikein(){
        assertEquals(-1,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataYlaLaudanUlkopuolelle(){
        lauta.lisaaPelinappula(nappula,25);
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
        lauta.lisaaPelinappula(nappula,23);
        assertEquals(23,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataAlaLaudanUlkopuolelle(){
        lauta.lisaaPelinappula(nappula,0);
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
        lauta.lisaaPelinappula(nappula,14);
        lauta.siirraPelinappulaaYlalaudalla(14, 4);
        assertEquals(nappula,lauta.haeYlaLauta()[0][5]);
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleAlalaudalla(){
        lauta.lisaaPelinappula(nappula, 3);
        lauta.siirraPelinappulaaAlalaudalla(3, 4);
        assertEquals(nappula,lauta.haeAlaLauta()[4][5]);
    }
    
    @Test
    public void pelinappulanSijaintiMuuttuuOikein(){
        lauta.lisaaPelinappula(nappula,3);
        lauta.siirraPelinappulaaAlalaudalla(3, 4);
        assertEquals(7,nappula.haePelinappulanSijainti());
    }
    
    
    @Test
    public void pelinappulaaEiVoiSiirtaaToisenNappulanPaalle(){
        Pelinappula nappula2 = new Pelinappula(pelaaja,peli);
        lauta.lisaaPelinappula(nappula, 3);
        lauta.lisaaPelinappula(nappula2, 5);
        lauta.siirraPelinappulaaAlalaudalla(5, 2);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosYlaLaudalta(){
        lauta.lisaaPelinappula(nappula, 3);
        lauta.siirraPelinappulaaYlalaudalla(3, 23);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosAlaLaudalta(){
        lauta.lisaaPelinappula(nappula, 3);
        lauta.siirraPelinappulaaAlalaudalla(3, -3);
        assertEquals(nappula,lauta.haeAlaLauta()[4][9]);
    }
    
}
