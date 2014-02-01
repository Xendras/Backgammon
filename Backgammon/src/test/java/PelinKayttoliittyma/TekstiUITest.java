/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttoliittyma;

import PelinKayttajat.Pelaaja;
import PelinOsat.Pelikokonaisuus;
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
    Pelikokonaisuus peli;
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
        peli = new Pelikokonaisuus();
        pelaaja = new Pelaaja("testi",'x',peli);
        nappula = new Pelinappula(pelaaja, peli);
        kayttoliittyma = new TekstiUI(peli);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void alaLautaTulostuuOikein() {

        nappula = new Pelinappula(pelaaja, peli);
        peli.haePelilauta().lisaaPelinappula(nappula, 3);
        assertEquals("|   | |   | |   | |   | |   | |   | |   | |   | |   | | x | |   | |   | ", kayttoliittyma.tulostaAlalauta());
    }

    @Test
    public void ylaLautaTulostuuOikein() {
        nappula = new Pelinappula(pelaaja, peli);
        peli.haePelilauta().lisaaPelinappula(nappula, 16);
        assertEquals("|   | |   | |   | | x | |   | |   | |   | |   | |   | |   | |   | |   | ", kayttoliittyma.tulostaYlalauta());
    }

    @Test
    public void kokoLautaTulostuuOikein() {
        nappula = new Pelinappula(pelaaja, peli);
        peli.haePelilauta().lisaaPelinappula(nappula, 16);
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
