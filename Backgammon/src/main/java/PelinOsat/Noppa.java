/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import java.util.Random;

/**
 * Luokka simuloi nopan toimintoja
 * @author Jonas Westerlund
 */
public class Noppa {

    Random arpoja;
    int arvo;

    /**
     * Luo nopan joka koostuu arpojasta sekä nopan arvosta.
     */
    public Noppa() {
        this.arpoja = new Random();
        this.arvo = 1;
    }

    /**
     * Arpoo nopalle arvon ja palauttaa arvon.
     * @return Nopan arvo
     */
    public int heitaNoppaaJaAnnaArvo() {
        this.asetaNopanArvo(arpoja.nextInt(6)+1);
        return this.arvo;
    }

    public void asetaNopanArvo(int uusiArvo) {
        this.arvo = uusiArvo;
    }

    public int haeNopanArvo() {
        return this.arvo;
    }
}
