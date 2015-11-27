package cagehos.gui;

import javax.swing.JOptionPane;

public class Central extends javax.swing.JFrame {
    public Central() {
        initComponents();       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMainToolbar = new javax.swing.JToolBar();
        btAddEntry = new javax.swing.JButton();
        btSearchEntry = new javax.swing.JButton();
        btTurnOff = new javax.swing.JButton();
        lbWallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Geral Hospitalar - CAGEHOS");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        jtbMainToolbar.setFloatable(false);
        jtbMainToolbar.setAlignmentY(0.5F);
        jtbMainToolbar.setBorderPainted(false);
        jtbMainToolbar.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        jtbMainToolbar.setMargin(new java.awt.Insets(10, 10, 10, 10));

        btAddEntry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_person_add_black_48dp_1x.png"))); // NOI18N
        btAddEntry.setToolTipText("Adicionar Cadastro");
        btAddEntry.setFocusable(false);
        btAddEntry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAddEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAddEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddEntryActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(btAddEntry);

        btSearchEntry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_search_black_48dp_1x.png"))); // NOI18N
        btSearchEntry.setToolTipText("Pesquisar Cadastro");
        btSearchEntry.setFocusable(false);
        btSearchEntry.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btSearchEntry.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btSearchEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchEntryActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(btSearchEntry);

        btTurnOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_power_settings_new_black_48dp_1x.png"))); // NOI18N
        btTurnOff.setToolTipText("Encerrar o Programa");
        btTurnOff.setFocusable(false);
        btTurnOff.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btTurnOff.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btTurnOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTurnOffActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(btTurnOff);

        lbWallpaper.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbWallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/wallpaper.png"))); // NOI18N
        lbWallpaper.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbWallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 1899, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtbMainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lbWallpaper, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTurnOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTurnOffActionPerformed
        final String[] options = {"Sim", "Não"};
        Object ret = JOptionPane.showOptionDialog(
                null,
                "Deseja encerrar a aplicação ?",
                "Desligar",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        if ("Sim".equals(options[Integer.valueOf(ret.toString())])) {
            System.exit(0);
        }
    }//GEN-LAST:event_btTurnOffActionPerformed

    private void btAddEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddEntryActionPerformed
        final String[] options = new String[] {"Paciente", "Médico", "Empregado"};  
        Object ret = JOptionPane.showOptionDialog(
                null,
                "Selecione o tipo de cadastro:",
                "Opções de Cadastro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        final String choice = options[Integer.valueOf(ret.toString())];
        
        if (null != choice) {
            switch (choice) {
                case "Paciente":
                    TelaCadastro paciente = new TelaCadastro(0, false);
                    paciente.setVisible(true);
                    break;
                case "Médico":
                    TelaCadastro medico = new TelaCadastro(1, false);
                    medico.setVisible(true);
                    break;
                case "Empregado":
                    TelaCadastro empregado = new TelaCadastro(2, false);
                    empregado.setVisible(true);
                    break;
            }
        }
    }//GEN-LAST:event_btAddEntryActionPerformed

    private void btSearchEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchEntryActionPerformed
        Consultar telaConsulta = new Consultar();
        telaConsulta.setVisible(true);
    }//GEN-LAST:event_btSearchEntryActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } else if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Central.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Central().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddEntry;
    private javax.swing.JButton btSearchEntry;
    private javax.swing.JButton btTurnOff;
    private javax.swing.JToolBar jtbMainToolbar;
    private javax.swing.JLabel lbWallpaper;
    // End of variables declaration//GEN-END:variables
}
