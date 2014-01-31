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
    String nimi;

    public Pelaaja(String nimi, char nappulanTyyppi) {
        this.nappulanTyyppi = nappulanTyyppi;
        this.nimi = nimi;
    }

    public char haePelaajanTyyppi() {
        return this.nappulanTyyppi;
    }
    
    public void asetaPelaajanTyyppi(char x){
        this.nappulanTyyppi = x;
    }
    
    public void asetaPelaajanNimi(String nimi){
        this.nimi = nimi;
    }
    
    public String haePelaajanNimi(){
        return this.nimi;
    }
}
