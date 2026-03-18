/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class EventoRigenera extends Evento {
    
    private int puntiVitaRecuperati;
    
    public EventoRigenera(int puntiV, int puntiVitaRecuperati){
        
        super(puntiV);
        
        this.puntiV = puntiV;
        this.puntiVitaRecuperati = puntiVitaRecuperati;
    }
    
    public void eseguiEvento(int puntiVita){ //Devo aggiungere o vita o bibite o snack al personaggio, quindi vediamo
        
        
    }
}
