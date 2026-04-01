/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;
import java.io.File;
import java.util.*;
/**
 *
 * @author pecorelli.davide
 */
public class Gioco {
    
    private Personaggio player;
    private Nemico enemie;
    ArrayList <String> listaNemici = new ArrayList();
    String nomeEstratto;
    private Sfida s;
    public static int turniVinti;
    public static int turniPersi;
    
    public void Gioco (Personaggio playerCorrente){
        
        player = playerCorrente;
        
    }
    
    public Personaggio selezionaPersonaggio (){ //Seleziona personaggio
        
        return player;
    }
    
    public void selezionaNemico () throws Exception{ //Estrazione casuale nemici
        
        Scanner s = new Scanner(new File("listaNemici.txt"));
        ArrayList<String> nemici = new ArrayList<>();
        
        Collections.shuffle(nemici);
        System.out.println("Nome: " + nemici.get(0)); 
        nomeEstratto = nemici.get(0);
        
        if(nomeEstratto == "Satsuki_Momoi" || nomeEstratto == "Riko_Aida"){ //gestisco qua gli amici e dico questo!
            
            player.ricaricaStatistiche();
            enemie = null;
        }
        
        else{
            if (nomeEstratto == "Ryota Kise"){
                    enemie =new Nemico("Ryota Kise",1,1);
            }
            if (nomeEstratto == "Shintaro Midorima"){
                    enemie =new Nemico("Shintaro Midorima",1,1);
            }
            if(nomeEstratto=="Atsushi Murasakibara"){
                enemie = new Nemico("Atsushi Murasakibara",1,1);
            }
            if(nomeEstratto=="Tatsuya Himuro"){
                enemie = new Nemico("Ttsuya Himuno",1,1);
            }
            if(nomeEstratto=="Makoto Hanamiya"){
                enemie = new Nemico("Makoto Hanamiya",1,1);
            }
            if(nomeEstratto=="Papa Mbaye Siki"){
                enemie = new Nemico("Papa Mbaye Siki",1,1);
            }
        }
        
    }
    
    public void creaSfida(){
        
       s = new Sfida(player,enemie);
       
        
    }
    
    public void checkVittoria(){
        
        if(turniVinti == 4){
            
            System.out.println("Vittoria");
    }
        if(turniPersi != 0){
            System.out.println("Game Over");
        }
}
}
