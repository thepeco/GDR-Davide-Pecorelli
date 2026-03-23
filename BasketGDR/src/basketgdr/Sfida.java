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
    
    public Sfida (Personaggio p, Nemico n){
        
        this.p = p;
        this.n = n;
    }
    
    public void generaNemico(int sceltaN){ // capire se serve veramente
        
    }
    
    public void attacco(){ //Attacco del personaggio
        
        if("Kuroko".equals(p.getNome())){
            
        es.eseguiEvento(85);
        
      }
        
        if("Akashi".equals(p.getNome())){
            
            es.eseguiEvento(85);
        }
        
        if("Aomine".equals(p.getNome())){
            
            es.eseguiEvento(95);
            
        }
        
        if("Kagami".equals(p.getNome())){
            
            es.eseguiEvento(95);
            
        }
    }
}
