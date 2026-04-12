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
public class Personaggio implements Serializable {

    protected int forzaFisica;
    protected int sete;
    protected int stanchezza;
    protected int bibita;
    protected int snack;
    protected int dannoPersonaggio;
    protected String nome;
    protected Nemico n;
    private boolean rispostaPersonaggio;

    public Personaggio(int forzaFisica, int sete, int stanchezza, String nome, int dannoPersonaggio, int bibita, int snack) {

        this.forzaFisica = forzaFisica;
        this.sete = sete;
        this.stanchezza = stanchezza;
        this.nome = nome;
        this.dannoPersonaggio = dannoPersonaggio;
        this.bibita = bibita;
        this.snack = snack;
    }

    public int getDannoPersonaggio() {

        return dannoPersonaggio;
    }

    public int getForzaFisica() {

        return forzaFisica;
    }

    public int getStanchezza() {

        return stanchezza;
    }

    public void setStanchezza(int stanchezza) {

        this.stanchezza += 5;
    }

    public void setSete(int sete) {

        this.sete += 5;
    }

    public int getSete() {

        return sete;
    }

    public String getNome() {

        return nome;
    }

    public void setBibita(int Numerobibite) { 

        bibita = Numerobibite;
    }

    public int getBibita() {

        return bibita;
    }

    public void setSnack(int NumeroSnack) { 

        snack = NumeroSnack;
    }

    public int getSnack() {

        return snack;
    }

    public boolean subisciDanno(int dannoPreso) {

        forzaFisica = forzaFisica - dannoPreso;

        if (forzaFisica <= 0) {

            rispostaPersonaggio = true;
        } else {

            rispostaPersonaggio = false;
        }

        return rispostaPersonaggio;
    }

    public int beviBibita() {

        if (sete >= 10) {

            bibita = bibita - 1;
            

            sete = sete - 10;

        } else {

            System.out.println("Ancora non puoi bere la tua bibita, devi avere più di 10 di sete!");

        }

        return bibita; 
    }

    public int mangiaSnack() {

        if (stanchezza >= 10) {

            snack = snack - 1;
            
            stanchezza = stanchezza - 10;

        } else {

            System.out.println("Ancora non puoi mangiare il tuo snack, devi avere più di 10 di stanchezza");

        }
        return snack; 
    }

    public boolean abilitàSpeciale(Nemico n) { 

        return n.setVita(dannoPersonaggio);

    }

}
