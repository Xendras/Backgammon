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
    LaudanTulostaja tulostaja;

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
        pelaaja = new Pelaaja("testi",'x',peli, peli.haePelaaja1Nappulat(),peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti());
        nappula = new Pelinappula(pelaaja, peli);
        tulostaja = new LaudanTulostaja(peli);
        kayttoliittyma = new TekstiUI(peli, tulostaja);

    }

    @After
    public void tearDown() {
    }
}
