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
    
    public Gioco(){
        
    }
    
    public Personaggio selezionaPersonaggio (){ //Seleziona personaggio
        
        return player;
    }
    
    public Nemico selezionaNemico () throws Exception{ //Estrazione casuale nemici
        
        Scanner s = new Scanner(new File("listaNemici.txt"));
        ArrayList<String> nemici = new ArrayList<>();
        
        while (s.hasNext()) {
            
            nemici.add(s.next());
            
        }
        
        Collections.shuffle(nemici);
        System.out.println("Nome: " + nemici.get(0));
        
        nomeEstratto = nemici.get(0);
        
        
            if (nomeEstratto.contains("Kise")){
                    enemie =new Nemico("Ryota Kise",70,17);
            }
            if (nomeEstratto.contains("Midorima")){
                    enemie =new Nemico("Midorima",75,15);
            }
            if(nomeEstratto.contains("Murasakibara")){
                enemie = new Nemico("Murasakibara",85,20);
            }
            if(nomeEstratto.contains("Himuro")){
                enemie = new Nemico("Himuro",65,14);
            }
            if(nomeEstratto.contains("Hanamiya")){
                enemie = new Nemico("Hanamiya",60,13);
            }
            if(nomeEstratto.contains("Hayama")){
                enemie = new Nemico("Hayama",62,13);
            }
        
        return enemie;
    }
    
    public Nemico getEnemie() {
        
       return enemie;
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
