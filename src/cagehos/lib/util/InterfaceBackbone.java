package cagehos.lib.util;

import cagehos.bd.ConnectionBD;
import cagehos.exc.InvalidFieldException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfaceBackbone {
    public static void validateNameField(
            String name,
            JTextField field,
            boolean mandatory
    ) {
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
    
    public static void validateNumberField(
        String name,
        JTextField field,
        boolean mandatory
    ) {
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
    
    public static void validateAddressField(
        String name,
        JTextField field,
        boolean mandatory
    ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator(
                    name,
                    field,
                    mandatory
                );

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
    
    public static void validateAddressComplementField(
        String name,
        JTextField field,
        boolean mandatory
    ) {
        boolean gotError = false;
        
        if (field.isEditable()) {
            try {
                FieldValidator verifier = new FieldValidator(
                    name,
                    field,
                    mandatory
                );

                verifier.isValidAsAddressComplement();
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
    
    public static void searchQuery(
        JTable tableSearchResults,
        JRadioButton rbDoctor,
        JRadioButton rbEmployee,
        JTextField nameFilter,
        JTextField cpfFilter
    ) {
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
            ConnectionBD conector = new ConnectionBD();
            Connection conexao = conector.getConexao();

            PreparedStatement searchParam = conexao.prepareStatement(search);
            ResultSet resultadoConsulta = searchParam.executeQuery();

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
                
                if (((name.contains(vector[0].toLowerCase()) ||
                        vector[0].toLowerCase().contains(name) ||
                        name.length() == 0)) &&
                        (!mustCompareCPF || cpf.equals(vector[1]))) {
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
        ArrayList<String> lista = new ArrayList<>();
        
        if (evt.getClickCount() == 1) {
            final int mousePositionY = evt.getPoint().y;
            final int rowTotalHeight = (tableSearchResults.getRowHeight() +
                    tableSearchResults.getRowMargin());
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
                ConnectionBD conector = new ConnectionBD();
                Connection conexao = conector.getConexao();
                PreparedStatement searchParam = conexao.prepareStatement(
                    rowSelected);

                return searchParam.executeQuery();
            } catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        
        return null;
    }
    
    public static void deleteFromDatabase(String table, String name) {
        if (name.length() > 0) {
            String path = String.format(
                "DELETE FROM %s WHERE nome=?",
                table
            );
            
            ConnectionBD conector = new ConnectionBD();
            Connection conexao = conector.getConexao();

            try {
                PreparedStatement searchParam = conexao.prepareStatement(path);
                searchParam.setString(1, name);
                searchParam.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
