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
        pelaaja = new Pelaaja("testi",'x');
        lauta = new Pelilauta();
        nappula = new Pelinappula(3, pelaaja, lauta);
        kayttoliittyma = new TekstiUI(lauta);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alaLautaTulostuuOikein() {
        Pelilauta lauta2 = new Pelilauta();
        kayttoliittyma = new TekstiUI(lauta2);
        nappula = new Pelinappula(3, pelaaja, lauta2);
        lauta2.lisaaPelinappula(nappula);
        assertEquals("|   | |   | |   | |   | |   | |   | |   | |   | |   | | x | |   | |   | ", kayttoliittyma.tulostaAlalauta());
    }

    @Test
    public void ylaLautaTulostuuOikein() {
        Pelilauta lauta2 = new Pelilauta();
        kayttoliittyma = new TekstiUI(lauta2);
        nappula = new Pelinappula(16, pelaaja, lauta2);
        lauta2.lisaaPelinappula(nappula);
        assertEquals("|   | |   | |   | | x | |   | |   | |   | |   | |   | |   | |   | |   | ", kayttoliittyma.tulostaYlalauta());
    }

    @Test
    public void kokoLautaTulostuuOikein() {
        Pelilauta lauta2 = new Pelilauta();
        kayttoliittyma = new TekstiUI(lauta2);
        nappula = new Pelinappula(16, pelaaja, lauta2);
        lauta2.lisaaPelinappula(nappula);
        assertEquals("  13    14    15    16    17    18    19    20    21    22    23    24  \n"
                + "------------------------------------------------------------------------\n"
                + "|   | |   | |   | | x | |   | |   | |   | |   | |   | |   | |   | |   | \n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "|   | |   | |   | |   | |   | |   | |   | |   | |   | |   | |   | |   | \n"
                + "------------------------------------------------------------------------\n"
                + "  12    11    10    9     8     7     6     5     4     3     2     1   ", kayttoliittyma.tulostaPelilauta());
    }
}
