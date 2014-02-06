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
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Xendra
 */
public class PelilautaTest {
    HashMap<Integer,ArrayList<Pelinappula>> lauta;
    Pelinappula nappula;
    Pelaaja pelaaja1;
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
        lauta = peli.haePelilaudanNappulat();
        pelaaja1 = new Pelaaja("testi",'x',peli, peli.haePelaaja1Nappulat(),peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti());
        nappula = new Pelinappula(pelaaja1, peli);
        peli.asetaPelaaja1(pelaaja1);
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriLuoTyhjanLaudan(){
        boolean tyhja = true;
        for(int i = 1; i<25;i++){
            if(!lauta.get(i).isEmpty()){
                tyhja = false;
            }
        }       
        assertEquals(true,tyhja);
    }
      
    @Test
    public void pelinappulaLisataanOikeallePaikalle(){
        peli.lisaaPelinappula(nappula,3);
        assertEquals(nappula,lauta.get(3).get(0));
    }
    
    @Test
    public void pelinappulanSijaintiAsetetaanOikein(){
        assertEquals(-1,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataYlaLaudanUlkopuolelle(){
        assertEquals(false,peli.haePelilauta().voikoLisata(nappula, 25));
    }
    
    @Test
    public void lisaaPelinappulaAsettaaSijainninOikein(){
        peli.lisaaPelinappula(nappula,23);
        assertEquals(23,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataAlaLaudanUlkopuolelle(){
        assertEquals(false,peli.haePelilauta().voikoLisata(nappula, 0));
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleYlalaudalla(){
        peli.lisaaPelinappula(nappula,14);
        peli.haePelaaja1().siirraPelinappulaa(14, 4);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(18).get(0));
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleAlalaudalla(){
        peli.lisaaPelinappula(nappula,3);
        peli.haePelaaja1().siirraPelinappulaa(3, 4);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(7).get(0));
    }
    
    @Test
    public void pelinappulanSijaintiMuuttuuOikein(){
        peli.lisaaPelinappula(nappula,3);
        peli.haePelaaja1().siirraPelinappulaa(3, 4);
        assertEquals(7,nappula.haePelinappulanSijainti());
    }
    
    
    @Test
    public void pelinappulaaEiVoiSiirtaaToisenPelaajanKahdenNappulanPaalle(){
        Pelinappula nappula2 = new Pelinappula(new Pelaaja("h", 'c', peli,peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()),peli);
        Pelinappula nappula3 = new Pelinappula(new Pelaaja("h", 'c', peli,peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()),peli);
        peli.lisaaPelinappula(nappula, 3);
        peli.lisaaPelinappula(nappula2, 5);
        peli.lisaaPelinappula(nappula3, 5);
        peli.haePelaaja1().siirraPelinappulaa(3, 2);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(3).get(0));
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosYlaLaudalta(){
        peli.lisaaPelinappula(nappula, 3);
        peli.haePelaaja1().siirraPelinappulaa(3, 23);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(3).get(0));
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosAlaLaudalta(){
        peli.lisaaPelinappula(nappula, 3);
        peli.haePelaaja1().siirraPelinappulaa(3, -3);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(3).get(0));
    }
    
}
