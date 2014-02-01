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

/**
 *
 * @author Xendra
 */
public class NoppaTest {

    Noppa noppa;

    public NoppaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.noppa = new Noppa();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaNopanArvonOikein() {
        int arvo = noppa.haeNopanArvo();
        assertEquals(1, arvo);
    }

    @Test
    public void nopanHeittoEiVieArvoaVaaraksi() {
        boolean toimiko = false;
        int arvo = noppa.heitaNoppaaJaAnnaArvo();
        if(arvo>0 && arvo < 7){
            toimiko = true;
        }        
        assertEquals(toimiko,true);
        
    }
}
