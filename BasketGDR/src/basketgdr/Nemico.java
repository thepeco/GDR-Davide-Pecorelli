/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;
 import java.util.ArrayList;
/**
 *
 * @author pecorelli.davide
 */
public class Nemico {
    
    private int vitaNemico;
    ArrayList <String> listaNemici = new ArrayList();
    private int dannoBase;
    
    public Nemico (int vitaNemico,int dannoBase){
        
        this.vitaNemico = vitaNemico;
        this.dannoBase = dannoBase;
    }
    
    public void setVita(int vitaPersa){ //Perde vita
        
        vitaNemico = vitaNemico - vitaPersa;
        
        if(vitaNemico == 0){
            
            System.out.println("Il nemico è morto");
        }
        
        else{
             System.out.println("Ancora vivo");
        }
        
    }
    
    public void reazioneNemico (Personaggio p){
        
    }
}
