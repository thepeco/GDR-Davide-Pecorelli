/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class Nemico {
    
    private int vitaNemico;
    private boolean risposta;
    private int dannoBase;
    
    public Nemico (int vitaNemico,int dannoBase){
        
        this.vitaNemico = vitaNemico;
        this.dannoBase = dannoBase;
    }
    
    public boolean setVita(int vitaPersa){ //Perde vita
        
          vitaNemico = vitaNemico - vitaPersa;
        
        if(vitaNemico <= 0){
            
            risposta = true;
            System.out.println("Il nemico è morto");
        }
        
        else{
            
             risposta = false;
             System.out.println("Ancora vivo");
        }
        
        return risposta;
    }
    
    public boolean reazioneNemico (Personaggio p){
        
        return p.subisciDanno(dannoBase);
        
    }
}
