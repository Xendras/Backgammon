/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

import java.util.Random;

/**
 *
 * @author jonas
 */
public class Noppa {

    Random arpoja;
    int arvo;

    public Noppa() {
        this.arpoja = new Random();
        this.arvo = 1;
    }

    public int heitaNoppaa() {
        return arpoja.nextInt(6) + 1;
    }

    public void asetaNopanArvo(int uusiArvo) {
        this.arvo = uusiArvo;
    }

    public int haeNopanArvo() {
        return this.arvo;
    }
}
