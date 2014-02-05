/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import PelinKayttajat.Pelaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Xendra
 */
public class PelinappulaTest {
    
    Pelilauta lauta;
    Pelaaja Jonas;
    Pelikokonaisuus peli;
    Pelinappula nappula;
    public PelinappulaTest() {
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
        Jonas = new Pelaaja("testi",'x',peli,peli.haePelaaja1Nappulat());
        nappula = new Pelinappula(Jonas,peli);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaSijainninOikein(){
        assertEquals(-1,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void konstruktoriAsettaaOmistajanOikein(){
        assertEquals(Jonas,nappula.haePelinappulanOmistaja());
    }
    
    @Test
    public void konstruktoriAsettaaPelilaudanOikein(){
        assertEquals(peli,nappula.haePelinappulanPeli());
    }
    
    
}
