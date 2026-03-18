/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class EventoSfida extends Evento {
    
    private int puntiVitaPersi;
    
    public EventoSfida (int puntiV, int puntiVitaPersi){
        
        super(puntiV);
        
        this.puntiV = puntiV;
        this.puntiVitaPersi = puntiVitaPersi;
    }
    
    public void eseguiEvento(int puntiVita){ //Devo togliere la vita al personaggio, quindi vediamo
        
        
    }
}
