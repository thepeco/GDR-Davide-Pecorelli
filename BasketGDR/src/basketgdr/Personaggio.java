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
    
    public String getNome(){
        
        return nome;
    }
    
    public void setBibita(int Numerobibite){ //Invece di fare questi metodi non possiamo metterle nel costruttore di personaggio?
        
        bibita = Numerobibite;
    }
    
    
    public void setSnack (int NumeroSnack){ //Invece di fare questi metodi non possiamo metterle nel costruttore di personaggio?
        
        snack = NumeroSnack;
    }
    
    public int subisciDanno (int dannoPreso){
        
        forzaFisica = forzaFisica -dannoPreso;
        
        return forzaFisica;
    }
    
    public int beviBibita (){
        
     if(sete >= 10){
            
          if(bibita > 0){
             
             bibita = bibita - 1;
             //Diminuisce la sete quindi fare dopo dei controlli e scalare la sete
             
             sete = sete - 10;
          }
        
          else{
            System.out.println("Hai 0 bibite a disposizione!");  
          }  
    }
     
     else{
         
         System.out.println("Ancora non puoi bere la tua bibita, devi avere più di 10 di sete!");
         
     }
        
        
        return bibita; //Anche la sete viene aggiornata
    }
    
    public int mangiaSnack (){
     
     if(stanchezza >= 10){
         
        if(snack > 0){
            
            snack = snack - 1;
            //Diminuisce la stanchezza quindi fare dopo dei controlli e scalare la stanchezza
            stanchezza = stanchezza - 10;
        }
        
        else{
            System.out.println("Hai 0 snack a disposizione!");
        }
     }
     
     else{
         
         System.out.println("Ancora non puoi mangiare il tuo snack, devi avere più di 10 di stanchezza");
        
     }
        return snack; //Anche la stanchezza viene aggiornata
  }
    
    public void abilitàSpeciale (Nemico n, int dannoPersonaggio){ //dobbiamo aggiornare la vita del nemico in base al danno provocato dal tipo di personaggio
        
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
