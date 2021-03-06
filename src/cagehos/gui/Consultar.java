package cagehos.gui;

public class Consultar extends javax.swing.JFrame {
    public Consultar() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchPersonTypeButtonGroup = new javax.swing.ButtonGroup();
        pOptions = new javax.swing.JPanel();
        pEntryType = new javax.swing.JPanel();
        lbTipoDeCadastro = new javax.swing.JLabel();
        rbPatient = new javax.swing.JRadioButton();
        rbDoctor = new javax.swing.JRadioButton();
        rbEmployee = new javax.swing.JRadioButton();
        pKeyWords = new javax.swing.JPanel();
        tfSearchCPF = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfSearchName = new javax.swing.JTextField();
        btSearchQuery = new javax.swing.JButton();
        spResultsPanel = new javax.swing.JScrollPane();
        tableSearchResults = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pOptions.setBorder(javax.swing.BorderFactory.createTitledBorder("Opções"));

        lbTipoDeCadastro.setText("Tipo de Cadastro");

        searchPersonTypeButtonGroup.add(rbPatient);
        rbPatient.setSelected(true);
        rbPatient.setText("Paciente");

        searchPersonTypeButtonGroup.add(rbDoctor);
        rbDoctor.setText("Médico");

        searchPersonTypeButtonGroup.add(rbEmployee);
        rbEmployee.setText("Funcionário");

        javax.swing.GroupLayout pEntryTypeLayout = new javax.swing.GroupLayout(pEntryType);
        pEntryType.setLayout(pEntryTypeLayout);
        pEntryTypeLayout.setHorizontalGroup(
            pEntryTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEntryTypeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pEntryTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbEmployee)
                    .addComponent(rbDoctor)
                    .addComponent(rbPatient)
                    .addComponent(lbTipoDeCadastro))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pEntryTypeLayout.setVerticalGroup(
            pEntryTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEntryTypeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTipoDeCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbPatient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbDoctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbEmployee))
        );

        try {
            tfSearchCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("CPF:");

        jLabel3.setText("Nome:");

        btSearchQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_search_black_48dp_1x.png"))); // NOI18N
        btSearchQuery.setText("Consultar");
        btSearchQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchQueryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pKeyWordsLayout = new javax.swing.GroupLayout(pKeyWords);
        pKeyWords.setLayout(pKeyWordsLayout);
        pKeyWordsLayout.setHorizontalGroup(
            pKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKeyWordsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pKeyWordsLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfSearchName, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pKeyWordsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSearchQuery)))
                .addContainerGap())
        );
        pKeyWordsLayout.setVerticalGroup(
            pKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pKeyWordsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pKeyWordsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(tfSearchName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pOptionsLayout = new javax.swing.GroupLayout(pOptions);
        pOptions.setLayout(pOptionsLayout);
        pOptionsLayout.setHorizontalGroup(
            pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pOptionsLayout.createSequentialGroup()
                .addComponent(pEntryType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pKeyWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pOptionsLayout.setVerticalGroup(
            pOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pKeyWords, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pEntryType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tableSearchResults.setAutoCreateRowSorter(true);
        tableSearchResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSearchResults.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSearchResults.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSearchResultsMouseClicked(evt);
            }
        });
        spResultsPanel.setViewportView(tableSearchResults);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spResultsPanel)
                    .addComponent(pOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spResultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSearchQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchQueryActionPerformed
        cagehos.lib.util.InterfaceBackbone.searchQuery(
            tableSearchResults,
            rbDoctor,
            rbEmployee,
            tfSearchName,
            tfSearchCPF
        );
        
        tfSearchCPF.setText("");
    }//GEN-LAST:event_btSearchQueryActionPerformed

    private void tableSearchResultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSearchResultsMouseClicked
        int option = 0;
        
        if (rbDoctor.isSelected()) {
            option = 1;
        } else if (rbEmployee.isSelected()) {
            option = 2;
        }
        
        TelaCadastro tela = new TelaCadastro(
            option,
            true,
            cagehos.lib.util.InterfaceBackbone.getInformationFromSearchEntry(
                evt,
                tableSearchResults,
                rbDoctor,
                rbEmployee,
                rbPatient
            )
        );
        
        tela.setVisible(true);
    }//GEN-LAST:event_tableSearchResultsMouseClicked

    public static void main(String args[]) {
        try {
            OUTER:
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (null != info.getName()) {
                    switch (info.getName()) {
                        case "GTK+":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                        case "Windows":
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break OUTER;
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Consultar().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton btSearchQuery;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbTipoDeCadastro;
    private javax.swing.JPanel pEntryType;
    private javax.swing.JPanel pKeyWords;
    private javax.swing.JPanel pOptions;
    private javax.swing.JRadioButton rbDoctor;
    private javax.swing.JRadioButton rbEmployee;
    private javax.swing.JRadioButton rbPatient;
    private javax.swing.ButtonGroup searchPersonTypeButtonGroup;
    private javax.swing.JScrollPane spResultsPanel;
    private javax.swing.JTable tableSearchResults;
    private javax.swing.JFormattedTextField tfSearchCPF;
    private javax.swing.JTextField tfSearchName;
    // End of variables declaration//GEN-END:variables
}
