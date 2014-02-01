/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

import PelinOsat.Pelikokonaisuus;
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
public class PelaajaTest {
    
    Pelikokonaisuus peli;

    public PelaajaTest() {
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
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void konstruktoriAsettaaNappulanTyypinOikein(){
        Pelaaja pelaaja = new Pelaaja("testi",'P', peli);
        
        char tyyppi = pelaaja.haePelaajanTyyppi();
        
        assertEquals('P', tyyppi);
    }
    

}
