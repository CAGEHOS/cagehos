package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;

/**
 * The CPF class provides static methods to create and validate CPF numbers.
 * @author Julio Ceron, Leonardo Falk
 */
public class CPF {

    /**
     * The CPF number maximum size of digits.
     */
    public static final int CPF_MAXSIZE = 11;

    /**
     * The CPF number weights for each digit.
     */
    public static final int[] CPF_WEIGHT = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    /**
     * The regular expression for CPF numbers.
     */
    public static final String REGEX_CPF = "[^\\d]+";
    
    private String cpfNumber = null;
    
    private static String removeDots(String cpf) {
        return cpf.replaceAll(REGEX_CPF, "");
    }
    
    private static int checkDigit(String str, int[] peso) {
        int soma = 0;
        
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        
        soma = 11 - soma % 11;
        
        return soma > 9 ? 0 : soma;
    }
    
    /**
     * Returns a CPF object with the CPF given string as initial value.
     * @param cpf The cpf string.
     * @throws InvalidCPFNumberException Whether the given CPF is valid or not.
     */
    public CPF(String cpf) throws InvalidCPFNumberException {
        cpf = removeDots(cpf);
        
        if (!isValidCPF(cpf)) {
            throw new InvalidCPFNumberException("Número de CPF inválido.");
        } else {
            cpfNumber = cpf;
        }
    }

    /**
     * Checks if the given CPF is valid.
     * @param cpf The cpf string value.
     * @return Returns true if it's valid, false otherwise.
     */
    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = checkDigit(cpf.substring(0, 9), CPF_WEIGHT);
        Integer digito2 = checkDigit(cpf.substring(0, 9) + digito1, CPF_WEIGHT);
        
        return cpf.equals(cpf.substring(0,9) + digito1 + digito2);
    }
    
    /**
     * Sets the current CPF number in the object.
     * @param num_CPF The CPF string.
     * @throws InvalidCPFNumberException Whether the given CPF is valid or not.
     */
    public void setCPF(String num_CPF) throws InvalidCPFNumberException {
        num_CPF = removeDots(num_CPF);
        
	if (isValidCPF(num_CPF)) {
            cpfNumber = num_CPF;
        } else {
            throw new InvalidCPFNumberException("Número de CPF inválido.");
        }
    }
    
    /**
     * Returns the CPF as a string.
     * @return The CPF number as a string without any separators.
     */
    public String getCPF() {
        return cpfNumber;
    }
    
    /**
     * Returns the CPF object as a string formatted with dots and hyphen.
     * @param formatted If the string should be formatted or not.
     * @return The CPF number formatted.
     */
    public String toString(boolean formatted) {
        if (!formatted) {
            return cpfNumber;
        }
        
        return cpfNumber.substring(0, 3) + "." + cpfNumber.substring(3, 6) + "." + cpfNumber.substring(6, 9) + "-" + cpfNumber.substring(9, 11);
    }
    
    @Override
    public String toString() {
        return cpfNumber;
    }
    
    public boolean equals(CPF toCompare) {
        return toCompare.cpfNumber.equals(this.cpfNumber);
    }
}
