/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PelinOsat;

import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;
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
public class PelikokonaisuusTest {
    HashMap<Integer,ArrayList<Pelinappula>> lauta;
    Pelinappula nappula;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Pelikokonaisuus peli;
    
    public PelikokonaisuusTest() {
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
        lauta = peli.haePelilaudanNappulat();
        pelaaja1 = new Pelaaja("testi",'x',peli, peli.haePelaaja1Nappulat(),peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti());
        pelaaja2 = new Pelaaja("testi",'o',peli, peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti());
        peli.asetaPelaaja1(pelaaja1);
        peli.asetaPelaaja2(pelaaja2);
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void pelilaudanAlustusToimii(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        boolean toimiko = true;
        for(int i = 1;i<3;i++){
            if(peli.haePelaaja1Nappulat().get(i) != peli.haePelilaudanNappulat().get(1).get(i-1)){
                toimiko = false;
            }
        }
        
        for(int i = 3;i<8;i++){
            if(peli.haePelaaja1Nappulat().get(i) != peli.haePelilaudanNappulat().get(12).get(i-3)){
                toimiko = false;
            }
        }
        
        for(int i = 8;i<11;i++){
            if(peli.haePelaaja1Nappulat().get(i) != peli.haePelilaudanNappulat().get(17).get(i-8)){
                toimiko = false;
            }
        }
        
        for(int i = 11;i<16;i++){
            if(peli.haePelaaja1Nappulat().get(i) != peli.haePelilaudanNappulat().get(19).get(i-11)){
                toimiko = false;
            }
        }
        
        for(int i = 1;i<3;i++){
            if(peli.haePelaaja2Nappulat().get(i) != peli.haePelilaudanNappulat().get(24).get(i-1)){
                toimiko = false;
            }
        }
        
        for(int i = 3;i<8;i++){
            if(peli.haePelaaja2Nappulat().get(i) != peli.haePelilaudanNappulat().get(13).get(i-3)){
                toimiko = false;
            }
        }
        
        for(int i = 8;i<11;i++){
            if(peli.haePelaaja2Nappulat().get(i) != peli.haePelilaudanNappulat().get(8).get(i-8)){
                toimiko = false;
            }
        }
        
        for(int i = 11;i<16;i++){
            if(peli.haePelaaja2Nappulat().get(i) != peli.haePelilaudanNappulat().get(6).get(i-11)){
                toimiko = false;
            }
        }
        assertEquals(true,toimiko);
    }
    
    @Test
    public void nopanHeittoToimii(){
        boolean toimiko = false;
        int arvo = peli.heitaNoppaa1();
        if(arvo>0 && arvo < 7){
            toimiko = true;
        }        
        assertEquals(true,toimiko);
    }
    
    @Test
    public void nopanArvonHakuToimii(){
        boolean toimiko = false;
        peli.heitaNoppaa1();
        int arvo = peli.haeNopan1Arvo();
        if(arvo>0 && arvo < 7){
            toimiko = true;
        }        
        assertEquals(true,toimiko);
    }
    
    @Test
    public void peliLaudanAlustusToimiiNappuloidenOsalta(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();    
        int nappuloidenMaara = 0;
        for(int i = 1; i< 25;i++){
            nappuloidenMaara += peli.haePelilauta().haePelilauta().get(i).size();
        }
        assertEquals(30,nappuloidenMaara);
    }
    
    @Test
    public void peliLaudanNappuloidenAlustusToimii(){
        peli.alustaPelinappulat();   
        assertEquals(15,peli.haePelaaja1Nappulat().keySet().size());
    }
}
