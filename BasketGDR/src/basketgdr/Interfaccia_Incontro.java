/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package basketgdr;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    private PannelloSfondo mioPannello2;

    /**
     * Creates new form Interfaccia_Incontro
     */
    public Interfaccia_Incontro(Personaggio player, Nemico nemico) {

        initComponents();

        mioPannello2 = new Interfaccia_Incontro.PannelloSfondo("/immagini/Sfondo1.png");
        mioPannello2.add(jLabel4);
        mioPannello2.add(jLabel5);
        mioPannello2.add(lblnomePersonaggio);
        mioPannello2.add(lblnomeNemico);
        mioPannello2.add(btnsalvaSer);
        mioPannello2.add(btnsalvaCSV);
        mioPannello2.add(jLabel1);
        mioPannello2.add(jLabel2);
        mioPannello2.add(jLabel3);
        mioPannello2.add(btnSnack);
        mioPannello2.add(btnBibita);
        mioPannello2.add(lblforzaFisica);
        mioPannello2.add(lblStanchezza);
        mioPannello2.add(lblSete);
        mioPannello2.add(lblBibita);
        mioPannello2.add(lblSnack);
        mioPannello2.add(btnAbilitàSpeciale);
        mioPannello2.add(btnPhantom);
        mioPannello2.add(btnZone);
        mioPannello2.add(jLabel6);
        mioPannello2.add(jLabel7);
        mioPannello2.add(lblforzaFisicaNemico);
        mioPannello2.add(lblImmagine);
        mioPannello2.add(lblImmagineN);

        this.setContentPane(mioPannello2);
        this.revalidate();
        this.repaint();

        this.player = player;
        this.nemicoCorrente = nemico;

        caricaDatiPartita();
        caricaImmaginiNemici();
    }

    public class PannelloSfondo extends JPanel {

        private Image immagine;

        public PannelloSfondo(String percorso) {
            
            this.setLayout(null);
            try {
                
                this.immagine = new ImageIcon(getClass().getResource("/Immagini/Sfondo1.png")).getImage();
            } catch (Exception e) {
                System.err.println("Errore: Impossibile trovare l'immagine al percorso: " + percorso);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            if (immagine != null) {
                Graphics2D g2d = (Graphics2D) g;

                
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                
                g2d.drawImage(immagine, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    private void caricaDatiPartita() {
        if (player != null) {

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

        Sfida s = new Sfida(player, nemicoCorrente);

        s.combattimentoBase();

        caricaDatiPartita();
        controllaMorti();
    }

    private void controllaMorti() {

        if (player.getForzaFisica() <= 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Sei stato sconfitto!");
            this.dispose();

        } else if (player.getSete() >= 40) {
            javax.swing.JOptionPane.showMessageDialog(this, "Troppa sete! Ti sei dovuto fermare. Game Over!");
            this.dispose();

        } else if (player.getStanchezza() >= 40) {
            javax.swing.JOptionPane.showMessageDialog(this, "Troppo stanco! Kuroko è svenuto in campo. Game Over!");
            this.dispose();

        } else if (nemicoCorrente.getVita() <= 0) {
            nemiciSconfitti++;

            if (nemiciSconfitti < MAX_NEMICI) {
                javax.swing.JOptionPane.showMessageDialog(this, "Nemico abbattuto! Premere OK per il prossimo.");
                generaNuovoNemico();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "SEI RIUSCITO A SCONFIGGERE CON LE TUE MOSSE I 4 AVVERSARI, HAI VINTO!!!");
                this.dispose();
            }
        }
    }

    private void generaNuovoNemico() {
        try {
            Gioco g = new Gioco();

            String nomeVecchio = "";
            if (this.nemicoCorrente != null) {
                nomeVecchio = this.nemicoCorrente.getNome();
            }

            Nemico nuovoPescato = g.selezionaNemico();

            while (nuovoPescato.getNome().equals(nomeVecchio)) {
                nuovoPescato = g.selezionaNemico();
            }

            this.nemicoCorrente = nuovoPescato;

            lblnomeNemico.setText(this.nemicoCorrente.getNome());
            lblforzaFisicaNemico.setText(String.valueOf(this.nemicoCorrente.getVita()));

            caricaImmaginiNemici();
            caricaDatiPartita();

        } catch (Exception e) {
            System.out.println("Errore nel cambio: " + e.getMessage());
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
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Forza Fisica:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 550, 120, 25);

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Stanchezza:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 590, 110, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sete:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 630, 60, 25);

        lblforzaFisica.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblforzaFisica.setForeground(new java.awt.Color(255, 255, 255));
        lblforzaFisica.setText("0");
        getContentPane().add(lblforzaFisica);
        lblforzaFisica.setBounds(320, 560, 37, 16);

        lblStanchezza.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblStanchezza.setForeground(new java.awt.Color(255, 255, 255));
        lblStanchezza.setText("0");
        getContentPane().add(lblStanchezza);
        lblStanchezza.setBounds(320, 600, 30, 16);

        lblSete.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblSete.setForeground(new java.awt.Color(255, 255, 255));
        lblSete.setText("0");
        getContentPane().add(lblSete);
        lblSete.setBounds(320, 640, 37, 16);

        btnSnack.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnSnack.setText("Snack");
        btnSnack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnackActionPerformed(evt);
            }
        });
        getContentPane().add(btnSnack);
        btnSnack.setBounds(140, 680, 72, 27);

        lblSnack.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblSnack.setForeground(new java.awt.Color(255, 255, 255));
        lblSnack.setText("0");
        getContentPane().add(lblSnack);
        lblSnack.setBounds(320, 690, 37, 16);

        btnBibita.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        btnBibita.setText("Bibita");
        btnBibita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBibitaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBibita);
        btnBibita.setBounds(140, 720, 72, 27);

        lblBibita.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblBibita.setForeground(new java.awt.Color(255, 255, 255));
        lblBibita.setText("0");
        getContentPane().add(lblBibita);
        lblBibita.setBounds(320, 730, 37, 16);

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("GIOCATORE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(220, 100, 170, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("AVVERSARIO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(870, 110, 160, 32);

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Forza Fisica");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(820, 570, 120, 25);

        btnAbilitàSpeciale.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnAbilitàSpeciale.setText("Abilità Speciale");
        btnAbilitàSpeciale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbilitàSpecialeActionPerformed(evt);
            }
        });
        getContentPane().add(btnAbilitàSpeciale);
        btnAbilitàSpeciale.setBounds(380, 550, 160, 32);

        btnZone.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnZone.setText("ZONE");
        btnZone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoneActionPerformed(evt);
            }
        });
        getContentPane().add(btnZone);
        btnZone.setBounds(380, 710, 160, 32);

        lblforzaFisicaNemico.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        lblforzaFisicaNemico.setForeground(new java.awt.Color(255, 255, 255));
        lblforzaFisicaNemico.setText("0");
        getContentPane().add(lblforzaFisicaNemico);
        lblforzaFisicaNemico.setBounds(960, 580, 40, 16);

        btnPhantom.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnPhantom.setText("Phantom Shot");
        btnPhantom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhantomActionPerformed(evt);
            }
        });
        getContentPane().add(btnPhantom);
        btnPhantom.setBounds(380, 630, 160, 32);

        lblnomePersonaggio.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblnomePersonaggio.setForeground(new java.awt.Color(255, 255, 255));
        lblnomePersonaggio.setText("...");
        getContentPane().add(lblnomePersonaggio);
        lblnomePersonaggio.setBounds(230, 140, 130, 25);

        lblnomeNemico.setFont(new java.awt.Font("Segoe UI Variable", 1, 18)); // NOI18N
        lblnomeNemico.setForeground(new java.awt.Color(255, 255, 255));
        lblnomeNemico.setText("...");
        getContentPane().add(lblnomeNemico);
        lblnomeNemico.setBounds(880, 150, 140, 25);
        getContentPane().add(lblImmagine);
        lblImmagine.setBounds(180, 180, 310, 350);
        getContentPane().add(lblImmagineN);
        lblImmagineN.setBounds(790, 180, 310, 380);

        btnsalvaSer.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnsalvaSer.setText("Ser");
        btnsalvaSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvaSerActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvaSer);
        btnsalvaSer.setBounds(430, 90, 110, 23);

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Salva partita");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(520, 40, 160, 32);

        btnsalvaCSV.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnsalvaCSV.setText("CSV");
        btnsalvaCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalvaCSVActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalvaCSV);
        btnsalvaCSV.setBounds(650, 90, 100, 20);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1140, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSnackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnackActionPerformed
        int nuovaSete = player.getSete() - 5;
        if (player.getSnack() > 0) {
            player.mangiaSnack();

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
            player.setStanchezza(player.getStanchezza() + 10);
            player.setSete(player.getSete() + 10);
            JOptionPane.showMessageDialog(this, "KAGAMI E' ENTRATO NELLA ZONE!");
            damage = k.getDannoPersonaggio();
        } else if (nome.equals("Aomine")) {
            Aomine a = (Aomine) player;
            a.attivaZone();
            player.setStanchezza(player.getStanchezza() + 10);
            player.setSete(player.getSete() + 10);
            JOptionPane.showMessageDialog(this, "AOMINE E' ENTRATO NELLA ZONE!");
            damage = a.getDannoPersonaggio();
        } else if (nome.equals("Akashi")) {
            Akashi ak = (Akashi) player;
            ak.attivaZone();
            player.setStanchezza(player.getStanchezza() + 10);
            player.setSete(player.getSete() + 10);
            damage = ak.getDannoPersonaggio();
            JOptionPane.showMessageDialog(this, "AKASHI E' ENTRATO NELLA ZONE!");
        }

        eseguiTurno(damage);

    }//GEN-LAST:event_btnZoneActionPerformed

    private void btnsalvaSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvaSerActionPerformed
        FileManager.salvaSer(this.player, this.nemicoCorrente);
        JOptionPane.showMessageDialog(this, "Salvato!");
    }//GEN-LAST:event_btnsalvaSerActionPerformed

    private void btnsalvaCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalvaCSVActionPerformed
        FileManager.salvaCSV(this.player, this.nemicoCorrente);
        JOptionPane.showMessageDialog(this, "Salvato!");
    }//GEN-LAST:event_btnsalvaCSVActionPerformed

    private void btnPhantomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhantomActionPerformed

        if(player.getSete() < 25 && player.getStanchezza() < 40){

            int damage = 50;

            JOptionPane.showMessageDialog(this, "PHANTOM SHOOT!");

            eseguiTurno(damage);
            player.setStanchezza(player.getStanchezza() + 10);
            player.setSete(player.getSete() + 10);
        }
        else{
            
            JOptionPane.showMessageDialog(this, "Purtroppo sei troppo stanco per poter utilizzare il Phantom Shot!!");
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
    private javax.swing.JPanel jPanel1;
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
