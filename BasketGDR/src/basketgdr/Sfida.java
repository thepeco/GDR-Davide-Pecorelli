/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class Sfida {
    
    private Personaggio p;
    private Nemico n;
    private EventoSfida es;
    private boolean vivoN;
    private boolean vivoP;
    
    public Sfida (Personaggio p, Nemico n){
        
        this.p = p;
        this.n = n;
    }
    
    public void generaNemico(int sceltaN){ // capire se serve veramente
        
    }
    
    public void combattimentoBase(){ //Attacco del personaggio
        
        /*
        vivoN = p.abilitàSpeciale(n);
        vivoP = n.reazioneNemico(p);
        
        if(vivoN == true){
         System.out.println("Morto");
        }
        
        else{
        System.out.println("Vivo");
        }
         */
        
        
        
    }
    
    public void combattimentoSpeciale(){
        
        
    }
}
