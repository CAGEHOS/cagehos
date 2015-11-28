package cagehos.gui;

import cagehos.bd.ConnectionBD;
import cagehos.exc.InvalidAddressException;
import cagehos.exc.InvalidCPFNumberException;
import cagehos.lib.Address;
import cagehos.lib.Doctor;
import cagehos.lib.Employee;
import cagehos.lib.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import cagehos.exc.InvalidNameException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {
    private final String[] TIPO_CADASTRO_STRING = {
        "paciente",
        "medico",
        "empregado",
    };
    
    private int tipoCadastro = 0;
    
    public TelaCadastro(int tipoCadastro, boolean editMode, ResultSet info) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.tipoCadastro = tipoCadastro;
        
        if (tipoCadastro == 0) {
            mTabCadastro.removeTabAt(2);
            mTabCadastro.removeTabAt(2);
            
            try {            
                ConnectionBD conector = new ConnectionBD();
                Connection conexao = conector.getConexao();

                PreparedStatement searchParam = conexao.prepareStatement("SELECT nome FROM medico ORDER BY nome ASC");
                ResultSet resultadoConsulta = searchParam.executeQuery();

                while(resultadoConsulta.next()) {
                    cbPrefDoctor.addItem(resultadoConsulta.getString("nome"));
                }
            
            } catch (SQLException e){
                 e.printStackTrace(System.out);
            }

        } else if (tipoCadastro == 1) {
            mTabCadastro.removeTabAt(1);
            mTabCadastro.removeTabAt(1);
        } else if (tipoCadastro == 2) {
            mTabCadastro.removeTabAt(1);
            mTabCadastro.removeTabAt(2);
        }
        
        if (!editMode) {
            btEdit.setVisible(false);
            btDelete.setVisible(false);
        } else {
            btFinish1.setVisible(false);
            btFinish2.setVisible(false);
            btFinish3.setVisible(false);
            
            tfPersonName.setEditable(false);
            tfBirthday.setEditable(false);
            tfCPF.setEditable(false);
            cbIDType.setEditable(false);
            tfIDNumber.setEditable(false);
            cbSexType.setEditable(false);
            cbMaritalStatus.setEditable(false);
            tfCityName.setEditable(false);
            cbState.setEditable(false);
            tfCEP.setEditable(false);
            tfAddressName.setEditable(false);
            tfAddressNumber.setEditable(false);
            tfAddressDistrict.setEditable(false);
            tfAddressComplement.setEditable(false);
            
            if (tipoCadastro == 0){
                cbBloodType.setEditable(false);
                cbPrefDoctor.setEditable(false);
                tfPatientObservations.setEditable(false);
            }

            if (tipoCadastro == 1){
                tfDoctorCRM.setEditable(false);
                cbDoctorSpecialTreatment.setEditable(false);
                tfDoctorObservations.setEditable(false);
            }

            if (tipoCadastro == 2){
                tfEmployeeSection.setEditable(false);
                tfEmployeeFunction.setEditable(false);
                tfEmployeeObservations.setEditable(false);
            }
        }
        
        if (info != null) {
            try {
                if (info.next()) {

                    tfPersonName.setText(info.getString("nome"));
                    tfBirthday.setText(info.getString("data_nascimento"));
                    tfCPF.setText(info.getString("cpf"));
                    cbIDType.setSelectedItem(info.getString("tipo_id"));
                    tfIDNumber.setText(info.getString("numero_id"));
                    cbSexType.setSelectedItem(info.getString("sexo"));
                    cbMaritalStatus.setSelectedItem(info.getString("estado_civil"));
                    tfCityName.setText(info.getString("cidade"));
                    cbState.setSelectedItem(info.getString("estado"));
                    tfCEP.setText(info.getString("cep"));
                    tfAddressName.setText(info.getString("logradouro"));
                    tfAddressNumber.setText(info.getString("numero"));
                    tfAddressDistrict.setText(info.getString("bairro"));
                    tfAddressComplement.setText(info.getString("complemento"));                    

                    if (tipoCadastro == 0){
                        cbBloodType.setSelectedItem(info.getString("tipo_sanguineo"));
                        cbPrefDoctor.setSelectedItem(info.getString("medico_preferencial"));
                        tfPatientObservations.setText(info.getString("observacoes"));
                    }

                    if (tipoCadastro == 1){
                        tfDoctorCRM.setText(info.getString("crm"));
                        cbDoctorSpecialTreatment.setSelectedItem(info.getString("pron_tratamento"));
                        tfDoctorObservations.setText(info.getString("area_especialidades"));
                    }

                    if (tipoCadastro == 2){
                        tfEmployeeSection.setText(info.getString("setor"));
                        tfEmployeeFunction.setText(info.getString("cargo"));
                        tfEmployeeObservations.setText(info.getString("area_especialidades"));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mTabCadastro = new javax.swing.JTabbedPane();
        pGeneraInfo = new javax.swing.JPanel();
        pMainInfo = new javax.swing.JPanel();
        InsertionInformationPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        tfIDNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbMaritalStatus = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cbSexType = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        cbIDType = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfPersonName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfBirthday = new javax.swing.JFormattedTextField();
        pAddressInfo = new javax.swing.JPanel();
        InsertionInformationPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfCityName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbState = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JFormattedTextField();
        InsertionInformationPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfAddressName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfAddressNumber = new javax.swing.JTextField();
        InsertionInformationPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        tfAddressComplement = new javax.swing.JTextField();
        tfAddressDistrict = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        pButtons = new javax.swing.JPanel();
        btDelete = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btCancel1 = new javax.swing.JButton();
        btNext = new javax.swing.JButton();
        pPacTab = new javax.swing.JPanel();
        pPatientInfo = new javax.swing.JPanel();
        InsertionInformationPanel1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cbBloodType = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        cbPrefDoctor = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tfPatientObservations = new javax.swing.JTextArea();
        pButtons2Page = new javax.swing.JPanel();
        btCancel4 = new javax.swing.JButton();
        btFinish3 = new javax.swing.JButton();
        pFunTab = new javax.swing.JPanel();
        InsertionInformationPanel6 = new javax.swing.JPanel();
        InsertionInformationPanel8 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        tfEmployeeSection = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        tfEmployeeFunction = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfEmployeeObservations = new javax.swing.JTextArea();
        InsertionInformationPanel7 = new javax.swing.JPanel();
        btCancel3 = new javax.swing.JButton();
        btFinish2 = new javax.swing.JButton();
        pMedTab = new javax.swing.JPanel();
        InsertionInformationPanel9 = new javax.swing.JPanel();
        InsertionInformationPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tfDoctorCRM = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbDoctorSpecialTreatment = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfDoctorObservations = new javax.swing.JTextArea();
        InsertionInformationPanel10 = new javax.swing.JPanel();
        btCancel2 = new javax.swing.JButton();
        btFinish1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        pMainInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Principais"));

        InsertionInformationPanel2.setPreferredSize(new java.awt.Dimension(699, 29));

        jLabel3.setText("CPF:");

        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Número ID:");

        tfIDNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfIDNumberFocusLost(evt);
            }
        });

        jLabel5.setText("Sexo:");

        cbMaritalStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro(a)", "Casado(a)", "Divorciado(a)", "Separado(a)", "Outro" }));

        jLabel6.setText("Estado Civil:");

        cbSexType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jLabel7.setText("Tipo de ID:");

        cbIDType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "RG", "CNH", "CT", "CIP" }));

        javax.swing.GroupLayout InsertionInformationPanel2Layout = new javax.swing.GroupLayout(InsertionInformationPanel2);
        InsertionInformationPanel2.setLayout(InsertionInformationPanel2Layout);
        InsertionInformationPanel2Layout.setHorizontalGroup(
            InsertionInformationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIDType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSexType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        InsertionInformationPanel2Layout.setVerticalGroup(
            InsertionInformationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(tfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(tfIDNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel5)
                .addComponent(cbMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel6)
                .addComponent(cbSexType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel7)
                .addComponent(cbIDType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setText("Nome:");

        tfPersonName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfPersonName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPersonNameFocusLost(evt);
            }
        });

        jLabel1.setText("Data de Nascimento:");

        try {
            tfBirthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel1)
                .addComponent(tfBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pMainInfoLayout = new javax.swing.GroupLayout(pMainInfo);
        pMainInfo.setLayout(pMainInfoLayout);
        pMainInfoLayout.setHorizontalGroup(
            pMainInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InsertionInformationPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        pMainInfoLayout.setVerticalGroup(
            pMainInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMainInfoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InsertionInformationPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pAddressInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel8.setText("Cidade:");

        tfCityName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfCityName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCityNameFocusLost(evt);
            }
        });

        jLabel9.setText("Estado:");

        cbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel10.setText("CEP:");

        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout InsertionInformationPanel3Layout = new javax.swing.GroupLayout(InsertionInformationPanel3);
        InsertionInformationPanel3.setLayout(InsertionInformationPanel3Layout);
        InsertionInformationPanel3Layout.setHorizontalGroup(
            InsertionInformationPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InsertionInformationPanel3Layout.setVerticalGroup(
            InsertionInformationPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9)
                .addComponent(cbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10)
                .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel11.setText("Logradouro:");

        tfAddressName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfAddressName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAddressNameFocusLost(evt);
            }
        });

        jLabel12.setText("Número:");

        tfAddressNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAddressNumberFocusLost(evt);
            }
        });

        javax.swing.GroupLayout InsertionInformationPanel4Layout = new javax.swing.GroupLayout(InsertionInformationPanel4);
        InsertionInformationPanel4.setLayout(InsertionInformationPanel4Layout);
        InsertionInformationPanel4Layout.setHorizontalGroup(
            InsertionInformationPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddressNumber)
                .addContainerGap())
        );
        InsertionInformationPanel4Layout.setVerticalGroup(
            InsertionInformationPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfAddressName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel12)
                .addComponent(tfAddressNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel13.setText("Complemento:");

        tfAddressComplement.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfAddressComplement.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAddressComplementFocusLost(evt);
            }
        });

        tfAddressDistrict.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfAddressDistrict.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfAddressDistrictFocusLost(evt);
            }
        });

        jLabel25.setText("Bairro:");

        javax.swing.GroupLayout InsertionInformationPanel5Layout = new javax.swing.GroupLayout(InsertionInformationPanel5);
        InsertionInformationPanel5.setLayout(InsertionInformationPanel5Layout);
        InsertionInformationPanel5Layout.setHorizontalGroup(
            InsertionInformationPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddressDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InsertionInformationPanel5Layout.setVerticalGroup(
            InsertionInformationPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfAddressComplement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(tfAddressDistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pAddressInfoLayout = new javax.swing.GroupLayout(pAddressInfo);
        pAddressInfo.setLayout(pAddressInfoLayout);
        pAddressInfoLayout.setHorizontalGroup(
            pAddressInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertionInformationPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InsertionInformationPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(InsertionInformationPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pAddressInfoLayout.setVerticalGroup(
            pAddressInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pAddressInfoLayout.createSequentialGroup()
                .addComponent(InsertionInformationPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InsertionInformationPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InsertionInformationPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pButtons.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_highlight_off_black_48dp_1x.png"))); // NOI18N
        btDelete.setText("Excluir");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        pButtons.add(btDelete);

        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_edit_black_48dp_1x.png"))); // NOI18N
        btEdit.setText("Editar");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });
        pButtons.add(btEdit);

        btCancel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_close_black_48dp_1x.png"))); // NOI18N
        btCancel1.setText("Cancelar");
        btCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancel1ActionPerformed(evt);
            }
        });
        pButtons.add(btCancel1);

        btNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_keyboard_arrow_right_black_48dp_1x.png"))); // NOI18N
        btNext.setText("Avançar");
        btNext.setMinimumSize(new java.awt.Dimension(100, 57));
        btNext.setPreferredSize(new java.awt.Dimension(100, 57));
        btNext.setRequestFocusEnabled(false);
        btNext.setRolloverEnabled(false);
        btNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNextActionPerformed(evt);
            }
        });
        pButtons.add(btNext);

        javax.swing.GroupLayout pGeneraInfoLayout = new javax.swing.GroupLayout(pGeneraInfo);
        pGeneraInfo.setLayout(pGeneraInfoLayout);
        pGeneraInfoLayout.setHorizontalGroup(
            pGeneraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pGeneraInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pGeneraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pGeneraInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pMainInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pAddressInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pGeneraInfoLayout.setVerticalGroup(
            pGeneraInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGeneraInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pMainInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pAddressInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        mTabCadastro.addTab("Dados Gerais", pGeneraInfo);

        pPatientInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Paciente"));

        jLabel21.setText("Tipo Sanguíneo:");

        cbBloodType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O-", "O+", "A-", "A+", "B-", "B+", "AB-", "AB+" }));

        jLabel23.setText("Médico Preferencial:");

        jLabel24.setText("Observações:");

        tfPatientObservations.setColumns(20);
        tfPatientObservations.setRows(5);
        jScrollPane3.setViewportView(tfPatientObservations);

        javax.swing.GroupLayout InsertionInformationPanel1Layout = new javax.swing.GroupLayout(InsertionInformationPanel1);
        InsertionInformationPanel1.setLayout(InsertionInformationPanel1Layout);
        InsertionInformationPanel1Layout.setHorizontalGroup(
            InsertionInformationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertionInformationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InsertionInformationPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(557, 724, Short.MAX_VALUE))
                    .addGroup(InsertionInformationPanel1Layout.createSequentialGroup()
                        .addGroup(InsertionInformationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(InsertionInformationPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPrefDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        InsertionInformationPanel1Layout.setVerticalGroup(
            InsertionInformationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel1Layout.createSequentialGroup()
                .addGroup(InsertionInformationPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cbBloodType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(cbPrefDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pPatientInfoLayout = new javax.swing.GroupLayout(pPatientInfo);
        pPatientInfo.setLayout(pPatientInfoLayout);
        pPatientInfoLayout.setHorizontalGroup(
            pPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertionInformationPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pPatientInfoLayout.setVerticalGroup(
            pPatientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPatientInfoLayout.createSequentialGroup()
                .addComponent(InsertionInformationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pButtons2Page.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btCancel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_close_black_48dp_1x.png"))); // NOI18N
        btCancel4.setText("Cancelar");
        btCancel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancel4ActionPerformed(evt);
            }
        });
        pButtons2Page.add(btCancel4);

        btFinish3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_done_black_48dp_1x.png"))); // NOI18N
        btFinish3.setText("Concluir");
        btFinish3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinish3ActionPerformed(evt);
            }
        });
        pButtons2Page.add(btFinish3);

        javax.swing.GroupLayout pPacTabLayout = new javax.swing.GroupLayout(pPacTab);
        pPacTab.setLayout(pPacTabLayout);
        pPacTabLayout.setHorizontalGroup(
            pPacTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPacTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPacTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pPatientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPacTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pButtons2Page, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pPacTabLayout.setVerticalGroup(
            pPacTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPacTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pPatientInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(pButtons2Page, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        mTabCadastro.addTab("Dados Hospitalares", pPacTab);

        InsertionInformationPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Funcionário"));

        jLabel18.setText("Setor:");

        jLabel19.setText("Cargo:");

        javax.swing.GroupLayout InsertionInformationPanel8Layout = new javax.swing.GroupLayout(InsertionInformationPanel8);
        InsertionInformationPanel8.setLayout(InsertionInformationPanel8Layout);
        InsertionInformationPanel8Layout.setHorizontalGroup(
            InsertionInformationPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmployeeSection, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEmployeeFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        InsertionInformationPanel8Layout.setVerticalGroup(
            InsertionInformationPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(tfEmployeeSection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel19)
                .addComponent(tfEmployeeFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel20.setText("Área(s) de especialidade(s):");

        tfEmployeeObservations.setColumns(20);
        tfEmployeeObservations.setRows(5);
        jScrollPane2.setViewportView(tfEmployeeObservations);

        javax.swing.GroupLayout InsertionInformationPanel6Layout = new javax.swing.GroupLayout(InsertionInformationPanel6);
        InsertionInformationPanel6.setLayout(InsertionInformationPanel6Layout);
        InsertionInformationPanel6Layout.setHorizontalGroup(
            InsertionInformationPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertionInformationPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(InsertionInformationPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertionInformationPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(InsertionInformationPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InsertionInformationPanel6Layout.setVerticalGroup(
            InsertionInformationPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel6Layout.createSequentialGroup()
                .addComponent(InsertionInformationPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InsertionInformationPanel7.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btCancel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_close_black_48dp_1x.png"))); // NOI18N
        btCancel3.setText("Cancelar");
        btCancel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancel3ActionPerformed(evt);
            }
        });
        InsertionInformationPanel7.add(btCancel3);

        btFinish2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_done_black_48dp_1x.png"))); // NOI18N
        btFinish2.setText("Concluir");
        btFinish2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinish2ActionPerformed(evt);
            }
        });
        InsertionInformationPanel7.add(btFinish2);

        javax.swing.GroupLayout pFunTabLayout = new javax.swing.GroupLayout(pFunTab);
        pFunTab.setLayout(pFunTabLayout);
        pFunTabLayout.setHorizontalGroup(
            pFunTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFunTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pFunTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InsertionInformationPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pFunTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(InsertionInformationPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pFunTabLayout.setVerticalGroup(
            pFunTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pFunTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InsertionInformationPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(InsertionInformationPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        mTabCadastro.addTab("Dados do Funcionário", pFunTab);

        InsertionInformationPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Médico"));

        jLabel15.setText("CRM:");

        jLabel16.setText("Pron. Tratamento:");

        cbDoctorSpecialTreatment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Méd.", "Dr.", "Dra." }));

        javax.swing.GroupLayout InsertionInformationPanel11Layout = new javax.swing.GroupLayout(InsertionInformationPanel11);
        InsertionInformationPanel11.setLayout(InsertionInformationPanel11Layout);
        InsertionInformationPanel11Layout.setHorizontalGroup(
            InsertionInformationPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDoctorCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDoctorSpecialTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(495, Short.MAX_VALUE))
        );
        InsertionInformationPanel11Layout.setVerticalGroup(
            InsertionInformationPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addComponent(tfDoctorCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel16)
                .addComponent(cbDoctorSpecialTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel17.setText("Área(s) de especialidade(s):");

        tfDoctorObservations.setColumns(20);
        tfDoctorObservations.setRows(5);
        jScrollPane1.setViewportView(tfDoctorObservations);

        javax.swing.GroupLayout InsertionInformationPanel9Layout = new javax.swing.GroupLayout(InsertionInformationPanel9);
        InsertionInformationPanel9.setLayout(InsertionInformationPanel9Layout);
        InsertionInformationPanel9Layout.setHorizontalGroup(
            InsertionInformationPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InsertionInformationPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(InsertionInformationPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InsertionInformationPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(InsertionInformationPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        InsertionInformationPanel9Layout.setVerticalGroup(
            InsertionInformationPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertionInformationPanel9Layout.createSequentialGroup()
                .addComponent(InsertionInformationPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        InsertionInformationPanel10.setLayout(new java.awt.GridLayout(1, 3, 5, 5));

        btCancel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_close_black_48dp_1x.png"))); // NOI18N
        btCancel2.setText("Cancelar");
        btCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancel2ActionPerformed(evt);
            }
        });
        InsertionInformationPanel10.add(btCancel2);

        btFinish1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cagehos/img/ic_done_black_48dp_1x.png"))); // NOI18N
        btFinish1.setText("Concluir");
        btFinish1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinish1ActionPerformed(evt);
            }
        });
        InsertionInformationPanel10.add(btFinish1);

        javax.swing.GroupLayout pMedTabLayout = new javax.swing.GroupLayout(pMedTab);
        pMedTab.setLayout(pMedTabLayout);
        pMedTabLayout.setHorizontalGroup(
            pMedTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMedTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pMedTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InsertionInformationPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMedTabLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(InsertionInformationPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pMedTabLayout.setVerticalGroup(
            pMedTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pMedTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InsertionInformationPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(InsertionInformationPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        mTabCadastro.addTab("Dados do Médico", pMedTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mTabCadastro)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mTabCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancel1ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancel1ActionPerformed

    private void btCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancel2ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancel2ActionPerformed

    private void btCancel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancel3ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancel3ActionPerformed

    private void btCancel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancel4ActionPerformed
        dispose();
    }//GEN-LAST:event_btCancel4ActionPerformed

    private void btNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNextActionPerformed
        mTabCadastro.setSelectedIndex(1);
    }//GEN-LAST:event_btNextActionPerformed

    private void btFinish1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinish1ActionPerformed
        // cria entrada dos medicos
        // to do: criar metodo padrao para inserir os dados
        boolean gotError = false;
        
        try {
            Doctor entry = new Doctor(
                tfPersonName.getText(),
                (String)cbSexType.getSelectedItem(),
                tfCPF.getText(),
                tfBirthday.getText()
            );
            
            entry.setProfession("Médico");
            entry.setTreatment((String)cbDoctorSpecialTreatment.getSelectedItem());
            entry.setObservations(tfDoctorObservations.getText());
            entry.setCRM(Integer.parseInt("0" + tfDoctorCRM.getText()));
            entry.setMaritalStatus((String)cbMaritalStatus.getSelectedItem());
            entry.setIDType((String)cbIDType.getSelectedItem());
            entry.setIDNumber(tfIDNumber.getText());
            
            Address entryAddress = new Address(
                tfAddressName.getText(),
                Integer.parseInt("0" + tfAddressNumber.getText()),
                tfAddressDistrict.getText(),
                tfCityName.getText(),
                (String)cbState.getSelectedItem(),
                tfCEP.getText(),
                tfAddressComplement.getText()
            );
            
            ConnectionBD conector = new ConnectionBD();
            Connection conexao = conector.getConexao();
            
            PreparedStatement cmdParam = 
            conexao.prepareStatement("INSERT INTO medico (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade, estado, cep, logradouro, numero, bairro, complemento, crm, pron_tratamento, area_especialidades, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 

            cmdParam.setString(1, entry.getName());
            cmdParam.setString(2, entry.getCPF().toString(true));                
            cmdParam.setString(3, entry.getIDType());
            cmdParam.setString(4, entry.getIDNumber());
            cmdParam.setString(5, entry.getGender());
            cmdParam.setString(6, entry.getMaritalStatus());
            cmdParam.setString(7, entryAddress.getCityName());
            cmdParam.setString(8, entryAddress.getStateName());
            cmdParam.setString(9, entryAddress.getZipCode());
            cmdParam.setString(10, entryAddress.getName());
            cmdParam.setString(11, String.valueOf(entryAddress.getNumber()));
            cmdParam.setString(12, entryAddress.getDistrict());
            cmdParam.setString(13, entryAddress.getComplement());
            cmdParam.setString(14, String.valueOf(entry.getCRM()));
            cmdParam.setString(15, entry.getTreatment());
            cmdParam.setString(16, entry.getObservations());
            cmdParam.setString(17, entry.getBirthDate());
            
            int changedLines = cmdParam.executeUpdate();

            dispose();
        } catch (InvalidNameException | InvalidCPFNumberException | InvalidAddressException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            if (gotError) {
                mTabCadastro.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btFinish1ActionPerformed

    private void btFinish2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinish2ActionPerformed
        // cria entrada dos medicos
        // to do: criar metodo padrao para inserir os dados
        boolean gotError = false;
        
        try {
            Employee entry = new Employee(
                tfPersonName.getText(),
                (String)cbSexType.getSelectedItem(),
                tfCPF.getText(),
                tfBirthday.getText()
            );
            
            entry.setProfession(tfEmployeeFunction.getText());
            entry.setWorkingSection(tfEmployeeSection.getText());
            entry.setObservations(tfEmployeeObservations.getText());
            entry.setMaritalStatus((String)cbMaritalStatus.getSelectedItem());
            entry.setIDType((String)cbIDType.getSelectedItem());
            entry.setIDNumber((String) tfIDNumber.getText());
            
            Address entryAddress = new Address(
                tfAddressName.getText(),
                Integer.parseInt("0" + tfAddressNumber.getText()),
                tfAddressDistrict.getText(),
                tfCityName.getText(),
                (String)cbState.getSelectedItem(),
                tfCEP.getText(),
                tfAddressComplement.getText()
            );
            
            ConnectionBD conector = new ConnectionBD();
            Connection conexao = conector.getConexao();
            
            PreparedStatement cmdParam = 
            conexao.prepareStatement("INSERT INTO empregado (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade, estado, cep, logradouro, numero, bairro, complemento, setor, cargo, area_especialidades, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 

            cmdParam.setString(1, entry.getName());
            cmdParam.setString(2, entry.getCPF().toString(true));                
            cmdParam.setString(3, entry.getIDType());
            cmdParam.setString(4, entry.getIDNumber());
            cmdParam.setString(5, entry.getGender());
            cmdParam.setString(6, entry.getMaritalStatus());
            cmdParam.setString(7, entryAddress.getCityName());
            cmdParam.setString(8, entryAddress.getStateName());
            cmdParam.setString(9, entryAddress.getZipCode());
            cmdParam.setString(10, entryAddress.getName());
            cmdParam.setString(11, String.valueOf(entryAddress.getNumber()));
            cmdParam.setString(12, entryAddress.getDistrict());
            cmdParam.setString(13, entryAddress.getComplement());
            cmdParam.setString(14, entry.getWorkingSection());
            cmdParam.setString(15, entry.getProfession());
            cmdParam.setString(16, entry.getObservations());
            cmdParam.setString(17, entry.getBirthDate());
            
            int changedLines = cmdParam.executeUpdate();

            dispose();
        } catch (InvalidNameException | InvalidCPFNumberException | InvalidAddressException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            if (gotError) {
                mTabCadastro.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btFinish2ActionPerformed

    private void btFinish3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinish3ActionPerformed
        // cria entrada no cadastro dos pacientes
         // to do: criar metodo padrao para inserir os dados
        boolean gotError = false;
        
        try {
            Patient entry = new Patient(
                tfPersonName.getText(),
                (String)cbSexType.getSelectedItem(),
                tfCPF.getText(),
                tfBirthday.getText()
            );
            
            entry.setBloodType((String) cbBloodType.getSelectedItem());
            entry.setObservations(tfPatientObservations.getText());
            entry.setMaritalStatus((String)cbMaritalStatus.getSelectedItem());
            entry.setIDType((String)cbIDType.getSelectedItem());
            entry.setIDNumber((String) tfIDNumber.getText());
            
            Address entryAddress = new Address(
                tfAddressName.getText(),
                Integer.parseInt("0" + tfAddressNumber.getText()),
                tfAddressDistrict.getText(),
                tfCityName.getText(),
                (String)cbState.getSelectedItem(),
                tfCEP.getText(),
                tfAddressComplement.getText()
            );
            
            ConnectionBD conector = new ConnectionBD();
            Connection conexao = conector.getConexao();
            
            PreparedStatement cmdParam = 
            conexao.prepareStatement("INSERT INTO paciente (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade, estado, cep, logradouro, numero, bairro, complemento, tipo_sanguineo, medico_preferencial, observacoes, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 

            cmdParam.setString(1, entry.getName());
            cmdParam.setString(2, entry.getCPF().toString(true));                
            cmdParam.setString(3, entry.getIDType());
            cmdParam.setString(4, entry.getIDNumber());
            cmdParam.setString(5, entry.getGender());
            cmdParam.setString(6, entry.getMaritalStatus());
            cmdParam.setString(7, entryAddress.getCityName());
            cmdParam.setString(8, entryAddress.getStateName());
            cmdParam.setString(9, entryAddress.getZipCode());
            cmdParam.setString(10, entryAddress.getName());
            cmdParam.setString(11, String.valueOf(entryAddress.getNumber()));
            cmdParam.setString(12, entryAddress.getDistrict());
            cmdParam.setString(13, entryAddress.getComplement());
            cmdParam.setString(14, entry.getBloodType());
            cmdParam.setString(15, (String) cbPrefDoctor.getSelectedItem());
            cmdParam.setString(16, entry.getObservations());
            cmdParam.setString(17, entry.getBirthDate());
            
            int changedLines = cmdParam.executeUpdate();

            dispose();
        } catch (InvalidNameException | InvalidCPFNumberException | InvalidAddressException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            if (gotError) {
                mTabCadastro.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_btFinish3ActionPerformed

    private void tfPersonNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPersonNameFocusLost
        cagehos.lib.util.InterfaceBackbone.validateNameField(
            "Nome",
            tfPersonName,
            !tfPersonName.getText().equals("")
        );
    }//GEN-LAST:event_tfPersonNameFocusLost

    private void tfIDNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfIDNumberFocusLost
        cagehos.lib.util.InterfaceBackbone.validateNumberField(
            "Número de RG",
            tfIDNumber,
            !tfIDNumber.getText().equals("")
        );
    }//GEN-LAST:event_tfIDNumberFocusLost

    private void tfCityNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCityNameFocusLost
        cagehos.lib.util.InterfaceBackbone.validateNameField(
            "Cidade",
            tfCityName,
            !tfCityName.getText().equals("")
        );
    }//GEN-LAST:event_tfCityNameFocusLost

    private void tfAddressNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressNameFocusLost
        cagehos.lib.util.InterfaceBackbone.validateAddressField(
            "Logradouro",
            tfAddressName,
            !tfAddressName.getText().equals("")
        );
    }//GEN-LAST:event_tfAddressNameFocusLost

    private void tfAddressNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressNumberFocusLost
        cagehos.lib.util.InterfaceBackbone.validateNumberField(
            "Número de Endereço",
            tfAddressNumber,
            !tfAddressNumber.getText().equals("")
        );
    }//GEN-LAST:event_tfAddressNumberFocusLost

    private void tfAddressDistrictFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressDistrictFocusLost
        cagehos.lib.util.InterfaceBackbone.validateAddressComplementField(
            "Bairro",
            tfAddressDistrict,
            !tfAddressDistrict.getText().equals("")
        );
    }//GEN-LAST:event_tfAddressDistrictFocusLost

    private void tfAddressComplementFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfAddressComplementFocusLost
        cagehos.lib.util.InterfaceBackbone.validateAddressComplementField(
            "Complemento",
            tfAddressComplement,
            !tfAddressComplement.getText().equals("")
        );
    }//GEN-LAST:event_tfAddressComplementFocusLost

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        btEdit.setVisible(false);
        btDelete.setVisible(false);
        
        btFinish1.setVisible(true);
        btFinish2.setVisible(true);
        btFinish3.setVisible(true);

        tfPersonName.setEditable(true);
        tfBirthday.setEditable(true);
        tfCPF.setEditable(true);
        cbIDType.setEditable(true);
        tfIDNumber.setEditable(true);
        cbSexType.setEditable(true);
        cbMaritalStatus.setEditable(true);
        tfCityName.setEditable(true);
        cbState.setEditable(true);
        tfCEP.setEditable(true);
        tfAddressName.setEditable(true);
        tfAddressNumber.setEditable(true);
        tfAddressDistrict.setEditable(true);
        tfAddressComplement.setEditable(true);

        if (tipoCadastro == 0){
            cbBloodType.setEditable(true);
            cbPrefDoctor.setEditable(true);
            tfPatientObservations.setEditable(true);
        }

        if (tipoCadastro == 1){
            tfDoctorCRM.setEditable(true);
            cbDoctorSpecialTreatment.setEditable(true);
            tfDoctorObservations.setEditable(true);
        }

        if (tipoCadastro == 2){
            tfEmployeeSection.setEditable(true);
            tfEmployeeFunction.setEditable(true);
            tfEmployeeObservations.setEditable(true);
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        final String[] options = {"Sim", "Não"};
        
        Integer ret = JOptionPane.showOptionDialog(
                null,
                "Deseja excluir essa entrada?",
                "Exclusão de entrada",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]
        );
        
        if ("Sim".equals(options[Integer.valueOf(ret.toString())])) {
            cagehos.lib.util.InterfaceBackbone.deleteFromDatabase(
                TIPO_CADASTRO_STRING[tipoCadastro],
                tfPersonName.getText()
            );
            
            dispose();
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    @SuppressWarnings("ConvertToStringSwitch")
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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaCadastro(0, false, null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InsertionInformationPanel1;
    private javax.swing.JPanel InsertionInformationPanel10;
    private javax.swing.JPanel InsertionInformationPanel11;
    private javax.swing.JPanel InsertionInformationPanel2;
    private javax.swing.JPanel InsertionInformationPanel3;
    private javax.swing.JPanel InsertionInformationPanel4;
    private javax.swing.JPanel InsertionInformationPanel5;
    private javax.swing.JPanel InsertionInformationPanel6;
    private javax.swing.JPanel InsertionInformationPanel7;
    private javax.swing.JPanel InsertionInformationPanel8;
    private javax.swing.JPanel InsertionInformationPanel9;
    private javax.swing.JButton btCancel1;
    private javax.swing.JButton btCancel2;
    private javax.swing.JButton btCancel3;
    private javax.swing.JButton btCancel4;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btFinish1;
    private javax.swing.JButton btFinish2;
    private javax.swing.JButton btFinish3;
    private javax.swing.JButton btNext;
    private javax.swing.JComboBox cbBloodType;
    private javax.swing.JComboBox cbDoctorSpecialTreatment;
    private javax.swing.JComboBox cbIDType;
    private javax.swing.JComboBox cbMaritalStatus;
    private javax.swing.JComboBox cbPrefDoctor;
    private javax.swing.JComboBox cbSexType;
    private javax.swing.JComboBox cbState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane mTabCadastro;
    private javax.swing.JPanel pAddressInfo;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pButtons2Page;
    private javax.swing.JPanel pFunTab;
    private javax.swing.JPanel pGeneraInfo;
    private javax.swing.JPanel pMainInfo;
    private javax.swing.JPanel pMedTab;
    private javax.swing.JPanel pPacTab;
    private javax.swing.JPanel pPatientInfo;
    private javax.swing.JTextField tfAddressComplement;
    private javax.swing.JTextField tfAddressDistrict;
    private javax.swing.JTextField tfAddressName;
    private javax.swing.JTextField tfAddressNumber;
    private javax.swing.JFormattedTextField tfBirthday;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfCityName;
    private javax.swing.JTextField tfDoctorCRM;
    private javax.swing.JTextArea tfDoctorObservations;
    private javax.swing.JTextField tfEmployeeFunction;
    private javax.swing.JTextArea tfEmployeeObservations;
    private javax.swing.JTextField tfEmployeeSection;
    private javax.swing.JTextField tfIDNumber;
    private javax.swing.JTextArea tfPatientObservations;
    private javax.swing.JTextField tfPersonName;
    // End of variables declaration//GEN-END:variables
}
