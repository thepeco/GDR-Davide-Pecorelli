/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class Aomine extends Personaggio{
    
    private Nemico n;
    private boolean zoneAttiva;
    
    public Aomine (int fozaFisica, int sete, int stanchezza, String nome, int dannoPersonaggio,boolean zoneAttiva, Nemico n){
        
        super(fozaFisica,sete,stanchezza,nome,dannoPersonaggio);
        
        this.forzaFisica = forzaFisica;
        this.sete = sete;
        this.stanchezza = stanchezza;
        this.nome = nome;
        this.dannoPersonaggio = dannoPersonaggio;
        this.n = n;
        this.zoneAttiva = zoneAttiva;
        
    }
    
    @Override
    
    public void abilitàSpeciale(Nemico n, int dannoPersonaggio){
        
    }
    
    public void attivaZone(){
        
    }
}
