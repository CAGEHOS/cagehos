package cagehos.lib.util;

import cagehos.exc.InvalidFieldException;
import java.util.LinkedHashMap;

public class InterfaceBackbone {
    public static void validateNameField(String name, javax.swing.JTextField field, boolean mandatory) {
        boolean gotError = false;
        
        try {
            FieldValidator verifier = new FieldValidator(name, field, mandatory);
            verifier.isValidAsName();
        } catch (InvalidFieldException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } finally {
            if (gotError) {
                field.grabFocus();
            }
        }
    }
    
    public static void validateNumberField(String name, javax.swing.JTextField field, boolean mandatory) {
        boolean gotError = false;
        
        try {
            FieldValidator verifier = new FieldValidator(name, field, mandatory);
            verifier.isValidAsNumber();
        } catch (InvalidFieldException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } finally {
            if (gotError) {
                field.grabFocus();
            }
        }
    }
    
    public static void validateAddressField(String name, javax.swing.JTextField field, boolean mandatory) {
        boolean gotError = false;
        
        try {
            FieldValidator verifier = new FieldValidator(name, field, mandatory);
            verifier.isValidAsAddress();
        } catch (InvalidFieldException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } finally {
            if (gotError) {
                field.grabFocus();
            }
        }
    }
    
    public static void validateAddressComplementField(String name, javax.swing.JTextField field, boolean mandatory) {
        boolean gotError = false;
        
        try {
            FieldValidator verifier = new FieldValidator(name, field, mandatory);
            verifier.isValidAsAddressComplement();
        } catch (InvalidFieldException e) {
            javax.swing.JOptionPane.showMessageDialog(null, e.getMessage(), "", javax.swing.JOptionPane.ERROR_MESSAGE);
            gotError = true;
        } finally {
            if (gotError) {
                field.grabFocus();
            }
        }
    }
    
    public static void validatePatientEntry(LinkedHashMap<String, String> info) {
        
    }
    
    public static void validateDoctorEntry(LinkedHashMap<String, String> info) {
        
    }
    
    public static void validateEmployeeEntry(LinkedHashMap<String, String> info) {
        
    }
}
