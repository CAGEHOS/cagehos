package cagehos.lib.util;

import cagehos.exc.InvalidFieldException;

public class FieldValidator {
    private final int FIELD_ERROR_NONE               = 0;
    private final int FIELD_ERROR_EMPTY              = 1;
    private final int FIELD_ERROR_INVALID_CHARACTERS = 2;
    private final int FIELD_ERROR_NON_NUMERIC_CHARS  = 3;
    
    private final String[] ERROR_TYPES = {
        "",
        "vazio.",
        "contém caracteres inválidos.",
        "contém caracteres não numéricos."
    };
    
    /* ########################## */
    
    private String fieldName = "";
    private String fieldInfo = "";
    private boolean mandatoryField = false;
    
    public FieldValidator(String fieldName, String fieldInfo, boolean mandatoryField) {
        this.fieldName = fieldName;
        this.fieldInfo = fieldInfo;
        this.mandatoryField = mandatoryField;
    }
    
    public FieldValidator(String fieldName, javax.swing.JTextField field, boolean mandatoryField) {
        this.fieldName = fieldName;
        this.fieldInfo = field.getText();
        this.mandatoryField = mandatoryField;
    }
    
    public String createExceptionMessage(int errorType) {
        return String.format("Campo%s\'%s\' %s", (mandatoryField ? " obrigatório " : " "), fieldName, ERROR_TYPES[errorType]);
    }
    
    public void capitalize() {
        char[] chars = fieldInfo.toLowerCase().toCharArray();
        boolean found = false;
        
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i] == '.' || chars[i]=='\'') {
                found = false;
            }
        }
        
        fieldInfo = String.valueOf(chars);
    }
    
    private void validateField(String regex) throws InvalidFieldException {
        if (fieldInfo.equals("") && mandatoryField) {
            throw new InvalidFieldException(
                createExceptionMessage(FIELD_ERROR_EMPTY)
            );
        } else if (!fieldInfo.matches(regex) && mandatoryField) {
            throw new InvalidFieldException(
                createExceptionMessage(FIELD_ERROR_INVALID_CHARACTERS)
            );
        }
    }
    
    public void isValidAsName() throws InvalidFieldException {
        validateField("^[\\p{L} '-]+$");
    }
    
    public void isValidAsAddress() throws InvalidFieldException {
        validateField("^[\\p{L} '-]+$");
    }
    
    public void isValidAsNumber() throws InvalidFieldException {
        char[] chars = fieldInfo.toCharArray();
        
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new InvalidFieldException(
                    createExceptionMessage(FIELD_ERROR_NON_NUMERIC_CHARS)
                );
            }
        }
    }
    
    public void isValidAsAddressComplement() throws InvalidFieldException {
        validateField("^[a-zA-Z0-9\\s]+");
    }
    
    public void isValidAsAddressDistrict() throws InvalidFieldException {
        validateField("^[a-zA-Z0-9\\s]+");
    }
}
