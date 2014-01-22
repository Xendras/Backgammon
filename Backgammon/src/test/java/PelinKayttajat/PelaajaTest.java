/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

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
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void konstruktoriAsettaaNappulanTyypinOikein(){
        Pelaaja pelaaja = new Pelaaja('P');
        
        char tyyppi = pelaaja.haePelaajanTyyppi();
        
        assertEquals('P', tyyppi);
    }
    

}
