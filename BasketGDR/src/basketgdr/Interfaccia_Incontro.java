/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package basketgdr;

import javax.swing.JOptionPane;

/**
 *
 * @author Davide
 */
public class Interfaccia_Incontro extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Interfaccia_Incontro.class.getName());
    private Personaggio player;
    private Nemico nemicoCorrente;
    private int nemiciSconfitti = 0;
    private final int MAX_NEMICI = 4;

    /**
     * Creates new form Interfaccia_Incontro
     */
    public Interfaccia_Incontro(Personaggio player, Nemico nemico) {

        initComponents();
        this.player = player;
        this.nemicoCorrente = nemico;

        caricaDatiPartita();
        caricaImmaginiNemici();
    }

    private void caricaDatiPartita() {
        if (player != null) {

            // SETTAGGIO PLAYER
            lblforzaFisica.setText(String.valueOf(player.getForzaFisica()));
            lblStanchezza.setText(String.valueOf(player.getStanchezza()));
            lblSete.setText(String.valueOf(player.getSete()));
            lblSnack.setText(String.valueOf(player.getSnack()));
            lblBibita.setText(String.valueOf(player.getBibita()));

            lblnomePersonaggio.setText(player.getNome());
            jLabel4.setText("GIOCATORE: " + player.getNome()); // Opzionale: cambia anche il titolo
        }

        if (player.getNome().equals("Kuroko")) {
            btnZone.setVisible(false);
            btnPhantom.setVisible(true);

        } else {
            btnZone.setVisible(true);
            btnPhantom.setVisible(false);
        }

        if (nemicoCorrente != null) {
            lblnomeNemico.setText(nemicoCorrente.getNome());

            lblforzaFisicaNemico.setText(String.valueOf(nemicoCorrente.getVita()));
        } else {
            lblnomeNemico.setText("Nessun Nemico");
        }

        if (player.getNome().contains("Kuroko")) {

            lblImmagine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Kuroko.png")));
        }

        if (player.getNome().contains("Kagami")) {

            lblImmagine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Kagami.png")));
        }
        if (player.getNome().contains("Akashi")) {

            lblImmagine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Akashi.png")));
        }
        if (player.getNome().contains("Aomine")) {

            lblImmagine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Aomine.png")));
        }

    }

    public void caricaImmaginiNemici() {

        if (nemicoCorrente.getNome().contains("Kise")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Kise.png")));
        }
        if (nemicoCorrente.getNome().contains("Midorima")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Midorima.png")));
        }
        if (nemicoCorrente.getNome().contains("Murasakibara")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Murasakibara.png")));
        }
        if (nemicoCorrente.getNome().contains("Himuro")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Himuro.png")));
        }
        if (nemicoCorrente.getNome().contains("Hanamiya")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Hanamiya.png")));
        }
        if (nemicoCorrente.getNome().contains("Hayama")) {

            lblImmagineN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Immagini/Hayama.png")));
        }

    }

    private void eseguiTurno(int dannoGiocatore) {

        // Calcolo danno minimo (senza Math.max)
        int dannoSottratto = dannoGiocatore;
        if (dannoSottratto < 10) {
            dannoSottratto = 10;
        }

        // PASSIAMO SOLO IL DANNO (visto che il tuo setVita sottrae già)
        nemicoCorrente.setVita(dannoSottratto);

        // Ora controlliamo se è ancora vivo usando il getter
        if (nemicoCorrente.getVita() > 0) {

            int dannoNemico = nemicoCorrente.getDanno();
            if (dannoNemico < 5) {
                dannoNemico = 5;
            }

            player.subisciDanno(dannoNemico);

        } else {
            // NON CHIAMARE setVita(0) qui! Il tuo metodo ha già fatto il calcolo.
            // Se vuoi essere sicuro che non sia negativo per il prossimo nemico:
            if (nemicoCorrente.getVita() < 0) {
                // Qui servirebbe un metodo che "setta" il valore fisso, 
                // ma se il tuo setVita sottrae sempre, creiamo un loop.
            }
        }

        caricaDatiPartita();
        controllaMorti();
    }

    private void controllaMorti() {
        if (player.getForzaFisica() <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Sei stato sconfitto!");
            this.dispose();
        } else if (nemicoCorrente.getVita() <= 0) {
            nemiciSconfitti++;

            if (nemiciSconfitti < MAX_NEMICI) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nemico abbattuto! Premere OK per il prossimo.");
                generaNuovoNemico();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "CAMPIONE! Hai vinto tutti e 4 gli incontri!");
                this.dispose();
            }
        }
    }

    private void generaNuovoNemico() {
        try {
            Gioco g = new Gioco();
            String nomeVecchio = nemicoCorrente.getNome();

            Nemico nuovoPescato = g.selezionaNemico();

            while (nuovoPescato.getNome().equals(nomeVecchio)) {
                nuovoPescato = g.selezionaNemico();
            }

            this.nemicoCorrente = nuovoPescato;

            caricaDatiPartita();
            caricaImmaginiNemici();

        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblforzaFisica = new javax.swing.JLabel();
        lblStanchezza = new javax.swing.JLabel();
        lblSete = new javax.swing.JLabel();
        btnSnack = new javax.swing.JButton();
        lblSnack = new javax.swing.JLabel();
        btnBibita = new javax.swing.JButton();
        lblBibita = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAbilitàSpeciale = new javax.swing.JButton();
        btnZone = new javax.swing.JButton();
        lblforzaFisicaNemico = new javax.swing.JLabel();
        btnPhantom = new javax.swing.JButton();
        lblnomePersonaggio = new javax.swing.JLabel();
        lblnomeNemico = new javax.swing.JLabel();
        lblImmagine = new javax.swing.JLabel();
        lblImmagineN = new javax.swing.JLabel();
        btnsalvaSer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnsalvaCSV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setText("Forza Fisica:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 500, 120, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel2.setText("Stanchezza:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 540, 110, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel3.setText("Sete:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 580, 60, 25);

        lblforzaFisica.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblforzaFisica.setText("0");
        getContentPane().add(lblforzaFisica);
        lblforzaFisica.setBounds(240, 510, 37, 16);

        lblStanchezza.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblStanchezza.setText("0");
        getContentPane().add(lblStanchezza);
        lblStanchezza.setBounds(240, 550, 30, 16);

        lblSete.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblSete.setText("0");
        getContentPane().add(lblSete);
        lblSete.setBounds(240, 590, 37, 16);

        btnSnack.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        btnSnack.setText("Snack");
        btnSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnackActionPerformed(evt);
            }
        });
        getContentPane().add(btnSnack);
        btnSnack.setBounds(60, 630, 72, 27);

        lblSnack.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblSnack.setText("0");
        getContentPane().add(lblSnack);
        lblSnack.setBounds(240, 640, 37, 16);

        btnBibita.setText("Bibita");
        btnBibita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBibitaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBibita);
        btnBibita.setBounds(60, 670, 72, 23);

        lblBibita.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblBibita.setText("0");
        getContentPane().add(lblBibita);
        lblBibita.setBounds(240, 680, 37, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel4.setText("GIOCATORE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 70, 150, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel5.setText("AVVERSARIO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(780, 70, 160, 32);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel6.setText("Forza Fisica");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(770, 490, 120, 25);

        btnAbilitàSpeciale.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnAbilitàSpeciale.setText("Abilità Speciale");
        btnAbilitàSpeciale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbilitàSpecialeActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbilitàSpeciale);
        btnAbilitàSpeciale.setBounds(300, 500, 150, 32);

        btnZone.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnZone.setText("ZONE");
        btnZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoneActionPerformed(evt);
            }
        });
        getContentPane().add(btnZone);
        btnZone.setBounds(300, 550, 150, 32);

        lblforzaFisicaNemico.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblforzaFisicaNemico.setText("0");
        getContentPane().add(lblforzaFisicaNemico);
        lblforzaFisicaNemico.setBounds(910, 500, 40, 16);

        btnPhantom.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnPhantom.setText("Phantom Shot");
        btnPhantom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhantomActionPerformed(evt);
            }
        });
        getContentPane().add(btnPhantom);
        btnPhantom.setBounds(300, 600, 150, 32);

        lblnomePersonaggio.setText("...");
        getContentPane().add(lblnomePersonaggio);
        lblnomePersonaggio.setBounds(150, 110, 130, 16);

        lblnomeNemico.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        lblnomeNemico.setText("...");
        getContentPane().add(lblnomeNemico);
        lblnomeNemico.setBounds(790, 110, 140, 20);
        getContentPane().add(lblImmagine);
        lblImmagine.setBounds(140, 130, 230, 310);
        getContentPane().add(lblImmagineN);
        lblImmagineN.setBounds(760, 140, 200, 300);

        btnsalvaSer.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnsalvaSer.setText("Ser");
        btnsalvaSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvaSerActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvaSer);
        btnsalvaSer.setBounds(350, 60, 110, 23);

        jLabel7.setText("Salva partita");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(490, 20, 70, 16);

        btnsalvaCSV.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        btnsalvaCSV.setText("CSV");
        btnsalvaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvaCSVActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvaCSV);
        btnsalvaCSV.setBounds(570, 60, 100, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnackActionPerformed
        int nuovaSete = player.getSete() - 5;
        if (player.getSnack() > 0) {
            player.mangiaSnack();

            // Aggiorno solo i numeri che l'utente vede a schermo
            lblSnack.setText(String.valueOf(player.getSnack()));
            lblStanchezza.setText(String.valueOf(player.getStanchezza()));
            lblSete.setText(String.valueOf(player.getSete()));
        } else {

            JOptionPane.showMessageDialog(this, "Non hai snack a disposizione!");
        }
    }//GEN-LAST:event_btnSnackActionPerformed

    private void btnBibitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBibitaActionPerformed
        int nuovaStanchezza = player.getStanchezza() - 5;
        if (player.getBibita() > 0) {
            player.beviBibita();

            // Aggiorno solo i numeri che l'utente vede a schermo
            lblBibita.setText(String.valueOf(player.getBibita()));
            lblSete.setText(String.valueOf(player.getSete()));
            lblStanchezza.setText(String.valueOf(player.getStanchezza()));
        } else {

            JOptionPane.showMessageDialog(this, "Non hai bibite a disposizione!");
        }
    }//GEN-LAST:event_btnBibitaActionPerformed

    private void btnAbilitàSpecialeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbilitàSpecialeActionPerformed
        int dannoBase = player.getDannoPersonaggio();
        player.setStanchezza(player.getStanchezza() + 10);
        player.setSete(player.getSete() + 5);
        eseguiTurno(dannoBase);
    }//GEN-LAST:event_btnAbilitàSpecialeActionPerformed

    private void btnZoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoneActionPerformed

        String nome = player.getNome();
        int damage = 0;

        if (nome.equals("Kagami")) {
            Kagami k = (Kagami) player;
            k.attivaZone();
            damage = k.getDannoPersonaggio();
        } else if (nome.equals("Aomine")) {
            Aomine a = (Aomine) player;
            a.attivaZone();
            damage = a.getDannoPersonaggio();
        } else if (nome.equals("Akashi")) {
            Akashi ak = (Akashi) player;
            ak.attivaZone();
            damage = ak.getDannoPersonaggio();
        }

        if (damage <= 0) {
            damage = 5;
        }

        eseguiTurno(damage);

    }//GEN-LAST:event_btnZoneActionPerformed

    private void btnsalvaSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvaSerActionPerformed
        FileManager.salvaSer(this.player, this.nemicoCorrente);
        javax.swing.JOptionPane.showMessageDialog(this, "Salvato!");
    }//GEN-LAST:event_btnsalvaSerActionPerformed

    private void btnsalvaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvaCSVActionPerformed
        FileManager.salvaCSV(this.player, this.nemicoCorrente);
        javax.swing.JOptionPane.showMessageDialog(this, "Salvato!");
    }//GEN-LAST:event_btnsalvaCSVActionPerformed

    private void btnPhantomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhantomActionPerformed

        int damage = 0;

        if (player.getNome().equals("Kuroko")) {

            Kuroko k = (Kuroko) player;

            k.phantomShoot(nemicoCorrente);
            damage = k.getDannoPersonaggio();

            JOptionPane.showMessageDialog(this, "PHANTOM SHOOT!");

            lblforzaFisicaNemico.setText(nemicoCorrente.getVita() + "");

            eseguiTurno(damage);
        }

    }//GEN-LAST:event_btnPhantomActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbilitàSpeciale;
    private javax.swing.JButton btnBibita;
    private javax.swing.JButton btnPhantom;
    private javax.swing.JButton btnSnack;
    private javax.swing.JButton btnZone;
    private javax.swing.JButton btnsalvaCSV;
    private javax.swing.JButton btnsalvaSer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblBibita;
    private javax.swing.JLabel lblImmagine;
    private javax.swing.JLabel lblImmagineN;
    private javax.swing.JLabel lblSete;
    private javax.swing.JLabel lblSnack;
    private javax.swing.JLabel lblStanchezza;
    private javax.swing.JLabel lblforzaFisica;
    private javax.swing.JLabel lblforzaFisicaNemico;
    private javax.swing.JLabel lblnomeNemico;
    private javax.swing.JLabel lblnomePersonaggio;
    // End of variables declaration//GEN-END:variables
}
