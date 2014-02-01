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
        lauta = new Pelilauta();
        Jonas = new Pelaaja("testi",'x');
        nappula = new Pelinappula(5,Jonas,lauta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaSijainninOikein(){
        assertEquals(5,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void konstruktoriAsettaaOmistajanOikein(){
        assertEquals(Jonas,nappula.haePelinappulanOmistaja());
    }
    
    @Test
    public void konstruktoriAsettaaPelilaudanOikein(){
        assertEquals(lauta,nappula.haePelinappulanPelilauta());
    }
    
    
}
