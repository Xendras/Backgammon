/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;
import PelinKayttajat.Pelaaja;

public class Pelilauta {

    Pelinappula[][] pelilaudanAlaosa;
    Pelinappula[][] pelilaudanYlaosa;

    public Pelilauta() {
        this.pelilaudanAlaosa = new Pelinappula[5][12];
        this.pelilaudanYlaosa = new Pelinappula[5][12];
    }
    

    public Pelinappula[][] haeYlaLauta() {
        return this.pelilaudanYlaosa;
    }

    public Pelinappula[][] haeAlaLauta() {
        return this.pelilaudanAlaosa;
    }

    public void lisaaPelinappula(Pelinappula nappula) {
        if (nappula.haePelinappulanSijainti() <= 0 || nappula.haePelinappulanSijainti() > 24) {
            return;
        }
        if (nappula.haePelinappulanSijainti() >= 13) {
            this.pelilaudanYlaosa[0][nappula.haePelinappulanSijainti() - 13] = nappula;
        } else {
            this.pelilaudanAlaosa[4][12 - nappula.haePelinappulanSijainti()] = nappula;
        }
    }

    public void siirraPelinappulaaYlalaudalla(Pelinappula nappula, int siirtoja) {
        if (nappula.haePelinappulanSijainti() + siirtoja > 24 || nappula.haePelinappulanSijainti() + siirtoja < 0 ||  this.paikkaVarattu(2, nappula.haePelinappulanSijainti() + siirtoja)) {
            return;
        }
        
        if(nappula.haePelinappulanSijainti() < 13){
            this.pelilaudanAlaosa[4][12-nappula.haePelinappulanSijainti()] = null;
        } else {
            this.pelilaudanYlaosa[0][nappula.haePelinappulanSijainti() - 13] = null;
        }
        
        nappula.sijainti += siirtoja;
        this.pelilaudanYlaosa[0][nappula.sijainti-13] = nappula;
    }
    
    public void siirraPelinappulaaAlalaudalla(Pelinappula nappula, int siirtoja) {
        if (nappula.haePelinappulanSijainti() + siirtoja > 24 || nappula.haePelinappulanSijainti() + siirtoja < 1 || this.paikkaVarattu(1, nappula.haePelinappulanSijainti() + siirtoja)) {
            return;
        }    
        if(nappula.haePelinappulanSijainti() < 13){
            this.pelilaudanAlaosa[4][12-nappula.haePelinappulanSijainti()] = null;
        } else {
            this.pelilaudanYlaosa[0][nappula.haePelinappulanSijainti() - 13] = null;
        }
        
        nappula.sijainti += siirtoja;
        this.pelilaudanAlaosa[4][12-nappula.sijainti] = nappula;
    }
    
    public void siirraPelinappulaa(Pelinappula nappula, int siirtoja){
        if(nappula.haePelinappulanSijainti() + siirtoja > 12){
            this.siirraPelinappulaaYlalaudalla(nappula, siirtoja);
        } else {
            this.siirraPelinappulaaAlalaudalla(nappula, siirtoja);
        }
    }

    public boolean paikkaVarattu(int pelilaudanOsa, int paikka) { // pelilaudanOsa 1=ala 2=ylä
        if (pelilaudanOsa == 1) {
            return this.pelilaudanAlaosa[4][12-paikka] != null;
        } else {
            return this.pelilaudanYlaosa[0][paikka - 13] != null;
        }
    }
}
