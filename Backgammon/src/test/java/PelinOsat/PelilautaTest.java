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
import PelinKayttajat.Pelaaja;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Xendra
 */
public class PelilautaTest {
    HashMap<Integer,ArrayList<Pelinappula>> lauta;
    Pelinappula nappula;
    Pelinappula nappula2;
    Pelaaja pelaaja1;
    Pelaaja pelaaja2;
    Pelikokonaisuus peli;
    Pelilauta pelilauta;
    
    public PelilautaTest() {
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
        pelilauta = peli.haePelilauta();
        pelaaja1 = new Pelaaja("testi1",'x',peli, peli.haePelaaja1Nappulat(),peli.haePelaajan1Jaahy(), peli.haePelaajan1Koti());
        pelaaja2 = new Pelaaja("testi2",'o',peli, peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti());
        nappula = new Pelinappula(pelaaja1, peli);
        nappula2 = new Pelinappula(pelaaja2, peli);
        peli.asetaPelaaja1(pelaaja1);
        peli.asetaPelaaja2(pelaaja2);
        peli.asetaPelaajaVuorossa(peli.haePelaaja1());
        
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriLuoTyhjanLaudan(){
        boolean tyhja = true;
        for(int i = 1; i<25;i++){
            if(!lauta.get(i).isEmpty()){
                tyhja = false;
            }
        }       
        assertEquals(true,tyhja);
    }
    
    @Test
    public void konstruktoriLuoOikeanMaaranListoja(){
        assertEquals(24,lauta.keySet().size());
    }
      
    @Test
    public void pelinappulaLisataanOikeallePaikalle(){
        peli.lisaaPelinappula(nappula,3);
        assertEquals(nappula,lauta.get(3).get(0));
    }
    
    @Test
    public void pelinappulaLisataanOikeinJaahylle(){
        peli.lisaaPelinappula(nappula,3);
        peli.haePelilauta().lisaaNappulaPelaajanJaahylle(nappula,peli.haePelaaja1());
        assertEquals(nappula,peli.haePelaaja1().haePelaajanJaahy().get(0));
    }
    
    @Test
    public void pelinappulaHaetaanOikeinJaahylta(){
        peli.lisaaPelinappula(nappula,3);
        peli.haePelilauta().lisaaNappulaPelaajanJaahylle(nappula,peli.haePelaaja1());
        Pelinappula nappula2 = peli.haePelilauta().haeNappulaPelaajanJaahylta(peli.haePelaaja1());
        assertEquals(nappula,nappula2);
    }
    
    @Test
    public void pelinappulaaEiVoiLisataYlaLaudanUlkopuolelle(){
        assertEquals(false,peli.haePelilauta().voikoLisata(nappula, 25));
    }
    
    @Test
    public void lisaaPelinappulaAsettaaSijainninOikein(){
        peli.lisaaPelinappula(nappula,23);
        assertEquals(23,nappula.haePelinappulanSijainti());
    }
    
    @Test
    public void pelinappulaaEiVoiLisataAlaLaudanUlkopuolelle(){
        assertEquals(false,peli.haePelilauta().voikoLisata(nappula, 0));
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleYlalaudalla(){
        peli.lisaaPelinappula(nappula,14);
        pelilauta.siirraNappulaaLaudalla(14, 4);
        assertEquals(nappula,lauta.get(18).get(0));
    }
    
    @Test
    public void pelinappulaSiirtyyOikeallePaikalleAlalaudalla(){
        peli.lisaaPelinappula(nappula,3);
        pelilauta.siirraNappulaaLaudalla(3, 4);
        assertEquals(nappula,lauta.get(7).get(0));
    }
    
    @Test
    public void pelinappulanSijaintiMuuttuuOikein(){
        peli.lisaaPelinappula(nappula,3);
        peli.haePelaaja1().siirraPelinappulaa(3, 4);
        assertEquals(7,nappula.haePelinappulanSijainti());
    }
    
    
    @Test
    public void pelinappulaaEiVoiSiirtaaToisenPelaajanKahdenNappulanPaalle(){
        Pelinappula nappula2 = new Pelinappula(new Pelaaja("h", 'c', peli,peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()),peli);
        Pelinappula nappula3 = new Pelinappula(new Pelaaja("h", 'c', peli,peli.haePelaaja2Nappulat(),peli.haePelaajan2Jaahy(), peli.haePelaajan2Koti()),peli);
        peli.lisaaPelinappula(nappula, 3);
        peli.lisaaPelinappula(nappula2, 5);
        peli.lisaaPelinappula(nappula3, 5);
        peli.haePelaaja1().siirraPelinappulaa(3, 2);
        assertEquals(nappula,peli.haePelilaudanNappulat().get(3).get(0));
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosYlaLaudalta(){
        peli.lisaaPelinappula(nappula, 3);
        pelilauta.siirraNappulaaLaudalla(3, 23);
        assertEquals(nappula,lauta.get(3).get(0));
    }
    
    @Test
    public void pelinappulaaEiVoiSiirtaaUlosAlaLaudalta(){
        peli.lisaaPelinappula(nappula, 3);
        pelilauta.siirraNappulaaLaudalla(3, -3);
        assertEquals(nappula,lauta.get(3).get(0));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaFalseAlalaudalla(){
        peli.lisaaPelinappula(nappula, 3);
        assertEquals(false,pelilauta.voikoSiirtaa(3,-3));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaFalseYlalaudalla(){
        peli.lisaaPelinappula(nappula, 3);
        assertEquals(false,pelilauta.voikoSiirtaa(3,22));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaTrueYlalaudalla(){
        peli.lisaaPelinappula(nappula, 3);
        assertEquals(true,pelilauta.voikoSiirtaa(3,21));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaTrueAlalaudalla(){
        peli.lisaaPelinappula(nappula, 3);
        assertEquals(true,pelilauta.voikoSiirtaa(3,-2));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaFalseKunVaaraPelaaja(){
        peli.lisaaPelinappula(nappula, 3);
        peli.asetaPelaajaVuorossa(peli.haePelaaja2());
        assertEquals(false,pelilauta.voikoSiirtaa(3,6));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaFalseAlalaudalla(){
        peli.lisaaPelinappula(nappula, 3);
        assertEquals(false,pelilauta.voikoSiirtaaKotiin(pelaaja1,3,-2));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaFalseYlalaudalla(){
        peli.lisaaPelinappula(nappula, 19);
        assertEquals(false,pelilauta.voikoSiirtaaKotiin(pelaaja1,19,2));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaTrueYlalaudalla(){
        peli.lisaaPelinappula(nappula, 19);
        assertEquals(true,pelilauta.voikoSiirtaaKotiin(pelaaja1,19,6));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaTrueAlalaudalla(){
        peli.lisaaPelinappula(nappula2, 3);
        peli.asetaPelaajaVuorossa(peli.haePelaaja2());
        assertEquals(true,pelilauta.voikoSiirtaaKotiin(pelaaja2,3,3));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaFalseKunVaaraPelaaja(){
        peli.lisaaPelinappula(nappula, 19);
        peli.asetaPelaajaVuorossa(peli.haePelaaja2());
        assertEquals(false,pelilauta.voikoSiirtaaKotiin(pelaaja2,19,6));
    }
    
    @Test
    public void voikoSiirtaaKotiinPalauttaaFalseKunTyhjaSijainti(){
        assertEquals(false,pelilauta.voikoSiirtaaKotiin(pelaaja1,19,6));
    }
    
    @Test
    public void siirraKotiinEiTeeMitaanJosSiirrotOvatVaarin(){
        peli.lisaaPelinappula(nappula, 19);
        pelilauta.siirraNappulaKotiin(pelaaja1,19,7);
        assertEquals(nappula,lauta.get(19).get(0));
    }
    
    @Test
    public void siirraKotiinSiirtaaOikein(){
        peli.lisaaPelinappula(nappula, 19);
        pelilauta.siirraNappulaKotiin(pelaaja1,19,6);
        assertEquals(nappula,pelaaja1.haePelaajanKoti().get(0));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaFalseKunSiirretaanToisenPelaajanPaalleJollaEnemmanKuinYksiNappula(){
        Pelinappula nappula2 = new Pelinappula(pelaaja2,peli);
        Pelinappula nappula3 = new Pelinappula(pelaaja2,peli);
        pelilauta.lisaaNappulaLaudalle(nappula2,9);
        pelilauta.lisaaNappulaLaudalle(nappula3,9);
        pelilauta.lisaaNappulaLaudalle(nappula,3);
        assertEquals(false,pelilauta.voikoSiirtaa(3,6));
    }
    
    @Test
    public void voikoSiirtaaPalauttaaTrueKunSiirretaanToisenPelaajanPaalleJollaOnYksiNappula(){
        Pelinappula nappula3 = new Pelinappula(pelaaja2,peli);
        pelilauta.lisaaNappulaLaudalle(nappula3,9);
        pelilauta.lisaaNappulaLaudalle(nappula,3);
        assertEquals(true,pelilauta.voikoSiirtaa(3,6));
    }
    
    @Test
    public void onkoPelaajanJaahyTyhjaToimii(){
        assertEquals(true,pelilauta.onkoPelaajanJaahyTyhja(peli.haePelaaja1()));
    }
    
    @Test
    public void onkoPelaajanKotiTaynna(){
        assertEquals(false,pelilauta.onkoPelaajanKotiTaynna(peli.haePelaaja1()));
    }
    
    @Test
    public void onkoPeliLoppuPalauttaaFalse(){
        assertEquals(false,pelilauta.onkoPeliLoppu(peli.haePelaaja1()));
    }
    
    @Test
    public void onkoPeliLoppuPalauttaaTrue(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        for(int i = 1;i <16;i++){
            pelilauta.lisaaNappulaPelaajanKotiin(peli.haePelaaja1Nappulat().get(i),pelaaja1);
        }
        assertEquals(true,pelilauta.onkoPeliLoppu(peli.haePelaaja1()));
    }
    
    
    @Test
    public void NappulatPelaajan1Alueella(){
        peli.alustaPelinappulat();
        for(int i = 1;i <16;i++){
            peli.haePelaaja1Nappulat().get(i).asetaPelinappulanSijainti(20);
        }
        assertEquals(true,pelilauta.ovatkoNappulatVastustajanAlueella(peli.haePelaaja1()));
    }
    
    @Test
    public void NappulatPelaajan2Alueella(){
        peli.alustaPelinappulat();
        for(int i = 1;i <16;i++){
            peli.haePelaaja2Nappulat().get(i).asetaPelinappulanSijainti(2);
        }
        assertEquals(true,pelilauta.ovatkoNappulatVastustajanAlueella(peli.haePelaaja2()));
    }
    
    @Test
    public void NappulatEivatPelaajan2Alueella(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        assertEquals(false,pelilauta.ovatkoNappulatVastustajanAlueella(peli.haePelaaja2()));
    }
    
    @Test
    public void NappulatEivatPelaajan1Alueella(){
        peli.alustaPelinappulat();
        peli.alustaPelilauta();
        assertEquals(false,pelilauta.ovatkoNappulatVastustajanAlueella(peli.haePelaaja1()));
    }
    
    
    
}
