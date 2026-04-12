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

    public static void salvaSer(Personaggio p, Nemico n) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("partita.ser"))) {
            oos.writeObject(p); // Java salva l'oggetto intero (Kuroko, Kagami, ecc.)
            oos.writeObject(n);
            System.out.println("Salvataggio SER riuscito!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[] caricaSer() {
        File f = new File("partita.ser");
        if (!f.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            // 1. Carichiamo gli oggetti salvati
            Personaggio p = (Personaggio) ois.readObject();
            Nemico n = (Nemico) ois.readObject();

            // 2. Ricolleghiamo il nemico (ora includiamo anche Kuroko!)
            if (p instanceof Kagami) {
                ((Kagami) p).setNemico(n);
            } else if (p instanceof Akashi) {
                ((Akashi) p).setNemico(n);
            } else if (p instanceof Aomine) {
                ((Aomine) p).setNemico(n);
            } else if (p instanceof Kuroko) {
                ((Kuroko) p).setNemico(n); // <--- Aggiunto Kuroko!
            }

            return new Object[]{p, n};
        } catch (Exception e) {
            System.out.println("Errore caricamento SER: " + e.getMessage());
            return null;
        }
    }

    public static void salvaCSV(Personaggio p, Nemico n) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("partita.csv"))) {
            // Salviamo i dati separati da virgola
            pw.println(p.getNome() + "," + p.getForzaFisica() + "," + p.getStanchezza() + ","
                    + p.getSete() + "," + p.getSnack() + "," + p.getBibita() + "," + p.getDannoPersonaggio());
            pw.println(n.getNome() + "," + n.getVita() + "," + n.getDanno());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[] caricaCSV() {
        File f = new File("partita.csv");
        if (!f.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String[] dP = br.readLine().split(",");

            String nome = dP[0].trim();
            int vita = Integer.parseInt(dP[1].trim());
            int stanc = Integer.parseInt(dP[2].trim());
            int sete = Integer.parseInt(dP[3].trim());
            int snack = Integer.parseInt(dP[4].trim());
            int bibite = Integer.parseInt(dP[5].trim());
            int danno = Integer.parseInt(dP[6].trim());

            Personaggio p;
            // CONTROLLO PER KUROKO (7 PARAMETRI)
            if (nome.equalsIgnoreCase("Kuroko")) {
                // Se Kuroko ha un costruttore diverso, lo chiamiamo con i suoi parametri
                // Nota: ho rimosso 'n' perché nel tuo file Kuroko non sembra accettare Nemico nel costruttore
                p = new Kuroko(vita, sete, stanc, nome, danno, snack, bibite);
            } else if (nome.equalsIgnoreCase("Kagami")) {
                p = new Kagami(vita, sete, stanc, nome, danno, false, bibite, snack);
            } else if (nome.equalsIgnoreCase("Akashi")) {
                p = new Akashi(vita, sete, stanc, nome, danno, false, bibite, snack);
            } else {
                p = new Personaggio(vita, sete, stanc, nome, danno, bibite, snack);
            }

            String[] dN = br.readLine().split(",");
            Nemico n = new Nemico(dN[0].trim(), Integer.parseInt(dN[1].trim()), Integer.parseInt(dN[2].trim()));

            // Colleghiamo il nemico se il personaggio lo supporta
            if (p instanceof Kagami) {
                ((Kagami) p).setNemico(n);
            }
            if (p instanceof Akashi) {
                ((Akashi) p).setNemico(n);
            }

            return new Object[]{p, n};
        } catch (Exception e) {
            return null;
        }
    }
}
