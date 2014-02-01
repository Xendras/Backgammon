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

    public void lisaaPelinappula(Pelinappula nappula, int sijainti) {
        nappula.asetaPelinappulanSijainti(sijainti);
        if (nappula.haePelinappulanSijainti() <= 0 || nappula.haePelinappulanSijainti() > 24) {
            return;
        }
        if (nappula.haePelinappulanSijainti() >= 13) {
            this.pelilaudanYlaosa[0][nappula.haePelinappulanSijainti() - 13] = nappula;
        } else {
            this.pelilaudanAlaosa[4][12 - nappula.haePelinappulanSijainti()] = nappula;
        }
    }

    public Pelinappula haePelinappula(int sijainti) {
        if (sijainti > 12) {
            return this.pelilaudanYlaosa[0][sijainti - 13];
        } else {
            return this.pelilaudanAlaosa[4][12 - sijainti];
        }
    }

    public void siirraPelinappulaaYlalaudalla(int sijainti, int siirtoja) {
        Pelinappula nappula = null;
        if (sijainti + siirtoja > 24 || sijainti + siirtoja < 13 || this.paikkaVarattu(sijainti + siirtoja)) {
            return;
        }
        if (sijainti < 13) {
            nappula = this.pelilaudanAlaosa[4][12 - sijainti];
            this.pelilaudanAlaosa[4][12 - sijainti] = null;
        } else if (sijainti >= 13) {
            nappula = this.pelilaudanYlaosa[0][sijainti - 13];
            this.pelilaudanYlaosa[0][sijainti - 13] = null;
        }

        nappula.asetaPelinappulanSijainti(sijainti + siirtoja);
        this.pelilaudanYlaosa[0][nappula.sijainti - 13] = nappula;
    }

    public void siirraPelinappulaaAlalaudalla(int sijainti, int siirtoja) {
        Pelinappula nappula = null;
        if (sijainti + siirtoja > 12 || sijainti + siirtoja < 1 || this.paikkaVarattu(sijainti + siirtoja)) {
            return;
        }
        if (sijainti < 13 && sijainti > 0) {
            nappula = this.pelilaudanAlaosa[4][12 - sijainti];
            this.pelilaudanAlaosa[4][12 - sijainti] = null;
        } else if (sijainti >= 13 && sijainti <= 24) {
            nappula = this.pelilaudanYlaosa[0][sijainti - 13];
            this.pelilaudanYlaosa[0][sijainti - 13] = null;
        } else {
            return;
        }

        nappula.sijainti += siirtoja;
        this.pelilaudanAlaosa[4][12 - nappula.sijainti] = nappula;
    }

    public void siirraPelinappulaa(int sijainti, int siirtoja) {
        if (sijainti + siirtoja > 12 && sijainti + siirtoja < 15) {
            this.siirraPelinappulaaYlalaudalla(sijainti, siirtoja);
        } else if (sijainti + siirtoja < 13 && sijainti + siirtoja > 0) {
            this.siirraPelinappulaaAlalaudalla(sijainti, siirtoja);
        }
    }

    public boolean paikkaVarattu(int paikka) { // pelilaudanOsa 1=ala 2=ylä
        if (paikka < 13) {
            return this.pelilaudanAlaosa[4][12 - paikka] != null;
        } else {
            return this.pelilaudanYlaosa[0][paikka - 13] != null;
        }

    }
}
