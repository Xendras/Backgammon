/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PelinOsat;

public class Pelilauta {

    Pelinappula[] pelilauta;

    public Pelilauta(int laudanKoko) {
        this.pelilauta = new Pelinappula[10];
    }

    public Pelinappula[] haeLauta() {
        return this.pelilauta;
    }

    public void lisaaPelinappula(Pelinappula nappula) {
        if (nappula.haePelinappulanSijainti() >= this.pelilauta.length) {
            return;
        }
        this.pelilauta[nappula.haePelinappulanSijainti()] = nappula;
        nappula.asetaPelinappulanSijainti(nappula.haePelinappulanSijainti());
    }

    public void siirraPelinappulaa(Pelinappula nappula, int siirtoja) {
        if (nappula.sijainti + siirtoja > pelilauta.length) {
            return;
        } else if (siirtoja < 1) {
            return;
        } else if (this.pelilauta[nappula.sijainti + siirtoja] != null) {
            return;
        }
        this.pelilauta[nappula.sijainti] = null;
        nappula.sijainti += siirtoja;
        this.pelilauta[nappula.sijainti] = nappula;
    }

    public void tulostaPelilauta() {
        for (int i = 0; i < this.pelilauta.length; i++) {
            System.out.print("[ ");
            if (this.pelilauta[i] != null) {
                System.out.print(this.pelilauta[i].haePelinappulanOmistaja().haePelaajanTyyppi());
            } else {
                System.out.print(" ");
            }
            System.out.print(" ]");
        }
    }
}
