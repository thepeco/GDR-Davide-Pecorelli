/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class Personaggio {
    
    protected int forzaFisica;
    protected int sete;
    protected int stanchezza;
    protected int bibita;
    protected int snack;
    protected int dannoPersonaggio;
    protected String nome;
    protected Nemico n;
    
    public Personaggio (int fozaFisica, int sete, int stanchezza, String nome, int dannoPersonaggio){
        
        this.forzaFisica = forzaFisica;
        this.sete = sete;
        this.stanchezza = stanchezza;
        this.nome = nome;
        this.dannoPersonaggio = dannoPersonaggio;
    }
    
    public int subisciDanno (int dannoPreso){
        
        forzaFisica = forzaFisica -dannoPreso;
        
        return forzaFisica;
    }
    
    public int beviBibita (){
         
        if(bibita > 0){
             
             bibita = bibita - 1;
             //Diminuisce la sete quindi fare dopo dei controlli e scalare la sete
         }
        
        else{
            System.out.println("Hai 0 bibite a disposizione!");  
        }
        
        return bibita;
    }
    
    public int mangiaSnack (){
        
        if(snack > 0){
            
            snack = snack - 1;
            //Diminuisce la stanchezza quindi fare dopo dei controlli e scalare la stanchezza
        }
        
        else{
            System.out.println("Hai 0 snack a disposizione!");
        }
        
        return snack;
    }
    
    public void abilitàSpeciale (Nemico n, int dannoPersonaggio){
        
        this.n = n;
        this.dannoPersonaggio = dannoPersonaggio;
    }
    
    public void ricaricaStatistiche (){ // Viene chiamato quando tra la lista nemici spuntano i due (amici)
        
        
        bibita = bibita + 1;
        /*
        snack = snack + 1;
        forzaFisica = forzaFisica + 30;
        */
        
    }
}
