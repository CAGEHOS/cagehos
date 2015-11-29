package cagehos.lib.util;

import cagehos.bd.ConnectionBD;
import cagehos.exc.InvalidFieldException;
import cagehos.lib.Address;
import cagehos.lib.Doctor;
import cagehos.lib.Employee;
import cagehos.lib.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfaceBackbone {
    private static final String INSERT_PATIENT_DBPATH = "INSERT INTO paciente"
            + " (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade, "
            + "estado, cep, logradouro, numero, bairro, complemento, "
            + "tipo_sanguineo, medico_preferencial, observacoes, "
            + "data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,"
            + " ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_EMPLOYEE_DBPATH = "INSERT INTO empregado"
            + " (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade,"
            + " estado, cep, logradouro, numero, bairro, complemento, setor,"
            + " cargo, area_especialidades, data_nascimento) VALUES (?, ?, ?,"
            + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String INSERT_DOCTOR_DBPATH = "INSERT INTO medico"
            + " (nome, cpf, tipo_id, numero_id, sexo, estado_civil, cidade, "
            + "estado, cep, logradouro, numero, bairro, complemento, crm, "
            + "pron_tratamento, area_especialidades, data_nascimento) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    
    private static ConnectionBD conector = null;
    private static Connection conexao = null;
    private static PreparedStatement cmdParam = null;
    
    
    public static void validateNameField( String name, JTextField field, boolean mandatory ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator(
                    name,
                    field,
                    mandatory
                );

                verifier.isValidAsName();
            } catch (InvalidFieldException e) {
                JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "",
                    JOptionPane.ERROR_MESSAGE
                );

                gotError = true;
            } finally {
                if (gotError) {
                    field.grabFocus();
                }
            }
        }
    }
    
    public static void validateNumberField(String name, JTextField field, boolean mandatory ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator(
                    name,
                    field,
                    mandatory
                );

                verifier.isValidAsNumber();
            } catch (InvalidFieldException e) {
                JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "",
                    JOptionPane.ERROR_MESSAGE
                );

                gotError = true;
            } finally {
                if (gotError) {
                    field.grabFocus();
                }
            }
        }
    }
    
    public static void validateAddressField( String name, JTextField field, boolean mandatory ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator( name, field, mandatory );

                verifier.isValidAsAddress();
            } catch (InvalidFieldException e) {
                JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "",
                    JOptionPane.ERROR_MESSAGE
                );

                gotError = true;
            } finally {
                if (gotError) {
                    field.grabFocus();
                }
            }
        }
    }
    
    public static void validateAddressComplementField( String name, JTextField field, boolean mandatory ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator(name, field, mandatory);

                verifier.isValidAsAddressComplement();
            } catch (InvalidFieldException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "", JOptionPane.ERROR_MESSAGE );
                gotError = true;
            } finally {
                if (gotError) {
                    field.grabFocus();
                }
            }
        }
    }
    
    public static void searchQuery(JTable tableSearchResults, JRadioButton rbDoctor, JRadioButton rbEmployee, JTextField nameFilter, JTextField cpfFilter) {
         String tipo = "paciente";
        
        if (rbDoctor.isSelected()) {
            tipo = "medico";
        } else if (rbEmployee.isSelected()) {
            tipo = "empregado";              
        }

        String search = String.format(
            "SELECT * FROM %s ORDER BY nome ASC",
            tipo
        );
        
        try {            
            conector = new ConnectionBD();
            conexao = conector.getConexao();

            cmdParam = conexao.prepareStatement(search);
            ResultSet resultadoConsulta = cmdParam.executeQuery();

            ArrayList<String[]>  lista = new ArrayList<>();

            String name = nameFilter.getText().toLowerCase();
            String cpf = cpfFilter.getText();
            
            boolean mustCompareCPF = false;
            
            if (cpf.split("[^\\d+]").length == 4) {
                mustCompareCPF = true;
            }
            
            while(resultadoConsulta.next()) {                    
                String vector[] = {
                    resultadoConsulta.getString("nome"),
                    resultadoConsulta.getString("cpf"),
                };
                
                if (((name.contains(vector[0].toLowerCase()) || vector[0].toLowerCase().contains(name) || name.length() == 0)) && (!mustCompareCPF || cpf.equals(vector[1]))) {
                    lista.add(vector);
                }
            }

            Iterator it = lista.iterator();
            
            DefaultTableModel dtm = (DefaultTableModel)
            tableSearchResults.getModel();
            dtm.setRowCount(lista.size());
            tableSearchResults.setModel(dtm);
            
            for (int j = 0; j < lista.size(); j++) {
                if (it.hasNext()) {
                    String[] info = (String[])it.next();
                    tableSearchResults.getModel().setValueAt(info[0], j, 0);
                    tableSearchResults.getModel().setValueAt(info[1], j, 1);
                } else {
                    break;
                }
            }
        } catch (SQLException e){
             e.printStackTrace(System.out);
        }
    }
    
    public static ResultSet getInformationFromSearchEntry(
        java.awt.event.MouseEvent evt,
        JTable tableSearchResults,
        JRadioButton rbDoctor,
        JRadioButton rbEmployee,
        JRadioButton rbPatient
    ) {
        if (evt.getClickCount() == 1) {
            final int mousePositionY = evt.getPoint().y;
            final int rowTotalHeight = (tableSearchResults.getRowHeight() + tableSearchResults.getRowMargin());
            final int rowIndex = mousePositionY / rowTotalHeight;
            
            Object userEntry = tableSearchResults.getModel().getValueAt(
                rowIndex, 0);
            
            if (userEntry == null) {
                userEntry = "";
            }

            String tipo = "paciente";
        
            if (rbDoctor.isSelected()) {
                tipo = "medico";
            } else if (rbEmployee.isSelected()) {
                tipo = "empregado";
            }

            String rowSelected = String.format(
                "SELECT * FROM %s WHERE NOME = '%s'",
                tipo,
                userEntry.toString()
            );
            
            try {            
                conector = new ConnectionBD();
                conexao = conector.getConexao();
                cmdParam = conexao.prepareStatement(rowSelected);

                return cmdParam.executeQuery();
            } catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
        return null;
    }
    
    public static void deleteFromDatabase(String table, String cpf) {
        if (cpf.length() > 0) {
            String path = String.format(
                "DELETE FROM %s WHERE cpf=?",
                table
            );
            
            conector = new ConnectionBD();
            conexao = conector.getConexao();

            try {
                cmdParam = conexao.prepareStatement(path);
                cmdParam.setString(1, cpf);
                cmdParam.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }
    
    public static void insertDoctor(Doctor entry, Address entryAddress) {
        try {
            conector = new ConnectionBD();
            conexao = conector.getConexao();
            
            String cpfSearch = entry.getCPF().toString(true),            
            searchBd = "SELECT cpf FROM medico WHERE cpf = '" + cpfSearch + "'";
            PreparedStatement searchParam = conexao.prepareStatement(searchBd);
            ResultSet resultadoConsulta = searchParam.executeQuery();
            
            if(!resultadoConsulta.next()) {            
                conector = new ConnectionBD();
                conexao = conector.getConexao();
                cmdParam = conexao.prepareStatement(INSERT_DOCTOR_DBPATH);

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

                cmdParam.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void insertEmployee(Employee entry, Address entryAddress) {
        try {
            conector = new ConnectionBD();
            conexao = conector.getConexao();
            
            String cpfSearch = entry.getCPF().toString(true);            
            String searchBd = "SELECT cpf FROM empregado WHERE cpf = '" + cpfSearch + "'";                      
            PreparedStatement searchParam = conexao.prepareStatement(searchBd);
            ResultSet resultadoConsulta = searchParam.executeQuery();
            
            if(!resultadoConsulta.next()) {
                conector = new ConnectionBD();
                conexao = conector.getConexao();
                cmdParam = conexao.prepareStatement(INSERT_EMPLOYEE_DBPATH);

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

                cmdParam.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void insertPatient(Patient entry, Address entryAddress, JComboBox cbPrefDoctor) {
        try {
            conector = new ConnectionBD();
            conexao = conector.getConexao();
            
            String cpfSearch = entry.getCPF().toString(true);            
            String searchBd = "SELECT cpf FROM paciente WHERE cpf = '" + cpfSearch + "'";                      
            PreparedStatement searchParam = conexao.prepareStatement(searchBd);
            ResultSet resultadoConsulta = searchParam.executeQuery();
            
             if(!resultadoConsulta.next()) {
                conector = new ConnectionBD();
                conexao = conector.getConexao();
                cmdParam = conexao.prepareStatement(INSERT_PATIENT_DBPATH);

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

                cmdParam.executeUpdate();
             }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
