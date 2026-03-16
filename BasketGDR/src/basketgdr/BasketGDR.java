/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package basketgdr;

/**
 *
 * @author pecorelli.davide
 */
public class BasketGDR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // Crea l'istanza della finestra e la rende visibile
            new Interfaccia().setVisible(true);
        }
    });
    }
    
}
