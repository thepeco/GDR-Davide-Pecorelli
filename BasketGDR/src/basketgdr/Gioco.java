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
    
    public void Gioco (Personaggio playerCorrente, Nemico enemieCorrente){
        
        player = playerCorrente;
        enemie = enemieCorrente;
    }
    
    public void selezionaPersonaggio (int sceltaP){
        
        //Capire come fare a scegliere il personaggio
    }
    
    public void selezionaNemico (int sceltaN) throws Exception{ //Estrazione casuale nemici
        
        Scanner s = new Scanner(new File("listaNemici.txt"));
        ArrayList<String> nemici = new ArrayList<>();
        
        Collections.shuffle(nemici);
        System.out.println("Nome: " + nemici.get(0)); 
        nomeEstratto = nemici.get(0);
        
        if(nomeEstratto == "Satsuki_Momoi" || nomeEstratto == "Riko_Aida"){ //gestisco qua gli amici e dico questo!
            
            player.ricaricaStatistiche();
        }
        
    }
    
    public void creaSfida(){
        
       // s.Sfida(player,enemie);
        
    }
    
    public void checkVittoria(){
        
    }
}
