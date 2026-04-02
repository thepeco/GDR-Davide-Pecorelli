/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;
import java.io.Serializable;
/**
 *
 * @author pecorelli.davide
 */
public class Nemico implements Serializable {
    
    private int vitaNemico;
    private boolean risposta;
    private int dannoBase;
    private String nome;
    
    public Nemico (String nome,int vitaNemico,int dannoBase){
        
        this.nome = nome;
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
