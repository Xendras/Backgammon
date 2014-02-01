
package PelinKayttoliittyma;
import PelinOsat.Pelikokonaisuus;
import PelinOsat.Pelilauta;
import java.util.Scanner;

public class TekstiUI {
    
    Pelikokonaisuus peli;
    Scanner lukija;
    
    public TekstiUI(Pelikokonaisuus peli){
        this.peli = peli;
        this.lukija = new Scanner(System.in);
    }
    
    public String tulostaYlalauta() {
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "| ";
            if (this.peli.haePelilauta().paikkaVarattu(i+13) == true) {
                tulostus += this.peli.haePelilauta().haeYlaLauta()[0][i].haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " | ";
        }
        
        return tulostus;
    }
    
    public String tulostaAlalauta(){
        String tulostus = "";
        for (int i = 0; i < 12; i++) {
            tulostus += "| ";
            if (this.peli.haePelilauta().paikkaVarattu(12-i) == true) {
                tulostus += this.peli.haePelilauta().haeAlaLauta()[4][i].haePelinappulanOmistaja().haePelaajanTyyppi();
            } else {
                tulostus += " ";
            }
            tulostus += " | ";
        }
        
        return tulostus;
    }
    
    public String tulostaPelilauta(){
        String tulostus = "";
        for(int i = 0; i<12;i++){
            tulostus += "  " + String.valueOf(i+13) + "  ";
        }   
        tulostus += '\n';
        for(int i = 0; i<72;i++){
            tulostus += "-";
        }  
        tulostus += '\n';
        tulostus += this.tulostaYlalauta();
        for(int i = 0; i<8;i++){
            tulostus += '\n';
        }
        tulostus += this.tulostaAlalauta();
        tulostus += '\n';
        for(int i = 0; i<72;i++){
            tulostus += "-";
        } 
        tulostus += '\n';
        for(int i = 0; i<3;i++){
            tulostus += "  " + String.valueOf(12-i) + "  ";
        }   
        for(int i = 3; i<12;i++){
            tulostus += "  " + String.valueOf(12-i) + "   ";
        }  
        return tulostus;
    }
    
    public void alustaPelilauta(){
        
    }
}
        
        
    
    
