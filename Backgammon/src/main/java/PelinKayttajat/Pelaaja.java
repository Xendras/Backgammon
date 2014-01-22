/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinKayttajat;

/**
 *
 * @author jonas
 */
public class Pelaaja {

    char nappulanTyyppi;

    public Pelaaja(char nappulanTyyppi) {
        this.nappulanTyyppi = nappulanTyyppi;
    }

    public char haePelaajanTyyppi() {
        return this.nappulanTyyppi;
    }
}
