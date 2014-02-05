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
 * @author Xendra
 */
public class LaudanTulostajaTest {

    Pelilauta lauta;
    Pelinappula nappula;
    Pelikokonaisuus peli;
    Pelaaja pelaaja;
    TekstiUI kayttoliittyma;
    LaudanTulostaja tulostaja;

    public LaudanTulostajaTest() {
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
        pelaaja = new Pelaaja("testi", 'x', peli, peli.haePelaaja1Nappulat());
        nappula = new Pelinappula(pelaaja, peli);
        tulostaja = new LaudanTulostaja(peli);
        kayttoliittyma = new TekstiUI(peli, tulostaja);
        peli.asetaPelaaja1(new Pelaaja("Jonas", 'X', peli, peli.haePelaaja1Nappulat()));
        peli.asetaPelaaja2(new Pelaaja("Sandra", 'O', peli, peli.haePelaaja2Nappulat()));
        peli.alustaPelinappulat();
        peli.alustaPelilauta();

    }

    @After
    public void tearDown() {
    }

    @Test
    public void kokoLautaTulostuuOikein() {
        assertEquals("  13    14    15    16    17    18    19    20    21    22    23    24  \n"
                + "------------------------------------------------------------------------\n"
                + "| O | |   | |   | |   | | X | |   | | X | |   | |   | |   | |   | | O | \n"
                + "  O                       X           X                             O   \n"
                + "  O                       X           X                                 \n"
                + "  O                                   X                                 \n"
                + "  O                                   X                                 \n"
                + "------------------------------------------------------------------------\n"
                + "  X                                   O                                 \n"
                + "  X                                   O                                 \n"
                + "  X                       O           O                                 \n"
                + "  X                       O           O                             X   \n"
                + "| X | |   | |   | |   | | O | |   | | O | |   | |   | |   | |   | | X | \n"
                + "------------------------------------------------------------------------\n"
                + "  12    11    10    9     8     7     6     5     4     3     2     1   ", tulostaja.tulostaPelilauta());
    }
}
