/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class Kuroko extends Personaggio {
    
    private Nemico n;
    private boolean phantomShootAttivo;
    
    public Kuroko (int fozaFisica, int sete, int stanchezza, String nome, int dannoPersonaggio,boolean phantomShootAttivo, Nemico n){
        
        super(fozaFisica,sete,stanchezza,nome,dannoPersonaggio);
        
        this.forzaFisica = forzaFisica;
        this.sete = sete;
        this.stanchezza = stanchezza;
        this.nome = nome;
        this.dannoPersonaggio = dannoPersonaggio;
        this.phantomShootAttivo = phantomShootAttivo;
        this.n = n;
    }
    
    @Override
    public void setBibita(int Numerobibite){ //In base a chi ha e non ha bibite/snack le settiamo su questi metodi 
        
        bibita = Numerobibite;
    }
    
    @Override
    public void setSnack (int NumeroSnack){ //In base a chi ha e non ha bibite/snack le settiamo su questi metodi 
        
        snack = NumeroSnack;
    }
    
    @Override
    public boolean abilitàSpeciale (Nemico n){ //Devo collegarci la vita del nemico???
    
        System.out.println("Vanishing Drive!");
        //Togli la vita del nemico usando il dannoPersonaggio
        return n.setVita(20);
        
    }
    
    public void nonMollare(){ //Al click del tasto non mollare puoi usare il tiro PhantomShot (quello in basse)
        
    }
    
    public void phantomShoot(Nemico n, int dannoPersonaggio){ //Devo collegarci la vita del nemico???
        
        
    }
  }

