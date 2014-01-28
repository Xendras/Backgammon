
package PelinKayttoliittyma;
import PelinOsat.Pelilauta;

public class TekstiUI {
    
    Pelilauta pelilauta;
    
    public TekstiUI(Pelilauta lauta){
        this.pelilauta = lauta;
    }
    
    public String tulostaYlalauta() {
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "[ ";
            if (this.pelilauta.paikkaVarattu(2,i+12) == false) {
                tulostus += this.pelilauta.haeYlaLauta()[0][i].haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " ] ";
        }
        
        return tulostus;
    }
    
    public String tulostaAlalauta(){
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "[ ";
            if (this.pelilauta.paikkaVarattu(1,i+12) == false) {
                tulostus += this.pelilauta.haeAlaLauta()[4][i].haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " ] ";
        }
        
        return tulostus;
    }
    
    public String tulostaPelilauta(){
        String tulostus = this.tulostaYlalauta();
        for(int i = 0; i<8;i++){
            tulostus += '\n';
        }
        tulostus += this.tulostaAlalauta();
        return tulostus;
    }
}
