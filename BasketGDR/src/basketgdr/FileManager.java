/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basketgdr;
import java.io.*;
/**
 *
 * @author pecorelli.davide
 */
public class FileManager {
    
    public static void salvaPartita(Gioco statoGioco) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("salvataggio.dat"))) {
            
            out.writeObject(statoGioco);
            
            System.out.println("Partita salvata con successo!");
            
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }
    
    public static Gioco caricaPartita() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("salvataggio.dat"))) {
            
            return (Gioco) in.readObject();
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Errore durante il caricamento: " + e.getMessage());
            
            return null;
        }
    }
}
