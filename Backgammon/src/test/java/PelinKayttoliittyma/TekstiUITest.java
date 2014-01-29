/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinKayttoliittyma;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelilauta;
import PelinOsat.Pelinappula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jonas
 */
public class TekstiUITest {
    Pelilauta lauta;
    Pelinappula nappula;
    Pelaaja pelaaja;
    TekstiUI kayttoliittyma;
    public TekstiUITest() {
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
        lauta = new Pelilauta();
        nappula = new Pelinappula(3,pelaaja,lauta);
        kayttoliittyma = new TekstiUI(lauta);
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void pelilautaTulostuuOikein(){
//        Pelilauta lauta2 = new Pelilauta();
//        kayttoliittyma = new TekstiUI(lauta2);
//        nappula = new Pelinappula(3,pelaaja,lauta2);
//        lauta2.lisaaPelinappula(nappula);
//        assertEquals("[   ] [   ] [   ] [ x ] ",kayttoliittyma.tulostaPelilauta());
//    }
}
