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
public class Kagami extends Personaggio implements Serializable{
    
    private Nemico n;
    private boolean zoneAttiva;
    
    public Kagami (int forzaFisica, int sete, int stanchezza, String nome, int dannoPersonaggio,boolean zoneAttiva, int bibita,int snack){
        
        super(forzaFisica,sete,stanchezza,nome,dannoPersonaggio,bibita,snack);
        
        this.forzaFisica = forzaFisica;
        this.sete = sete;
        this.stanchezza = stanchezza;
        this.nome = nome;
        this.dannoPersonaggio = dannoPersonaggio;
        this.zoneAttiva = zoneAttiva;
        this.bibita=bibita;
        this.snack=snack;
        
    }
    
    public void setNemico(Nemico n){
        
        this.n = n;
    }
    @Override
    public void setBibita(int Numerobibite){
        
        bibita = Numerobibite;
    }
    
    @Override
    public void setSnack (int NumeroSnack){
        
        snack = NumeroSnack;
    }
    
    @Override
    public boolean abilitàSpeciale(Nemico n){
        
        System.out.println("Meteor Jam!");
        return n.setVita(30);
    }
    
    public void attivaZone(){
        
        forzaFisica = forzaFisica + 55;
        sete = 0;
        stanchezza = 0;
        dannoPersonaggio = 45;
    }
}
