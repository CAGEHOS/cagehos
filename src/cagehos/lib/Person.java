package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import cagehos.exc.InvalidNameException;

import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;

/**
 * The Person class provides methods to create and access any person information.
 * @author Julio Ceron, Leonardo Falk
 */
public class Person {
    public final static String REGEX_NAME = "^[\\p{L} '-]+$";
    
    private String personName;
    private CPF cpfNumber = null;
    private Date birthDate = null;
    private String sexType;
    private String idType;
    private String idNumber;
    private String maritalStatus;

    /**
     * Returns a Person object with the given information.
     * @param name The person's name.
     * @param sexType The doctor's sex gender.
     * @param cpf The person's CPF number.
     * @param birth The person's birth date.
     * @throws InvalidNameException If the person's name contains any non valid character.
     * @throws InvalidCPFNumberException If the CPF number given is invalid.
     */
    public Person(String name, String sexType, String cpf, String birth)
        throws InvalidNameException, InvalidCPFNumberException
    {
        if (!validateName(name)) {
            throw new InvalidNameException(
                "Letras inválidas para o nome da pessoa."
            );
        }
        
        personName = name;
        this.sexType = sexType;
        cpfNumber  = new CPF(cpf);
        
        final String[] dateParts = birth.split("[^\\d+]");
        
        birthDate  = new Date(String.format("%s/%s/%d", dateParts[1], dateParts[0], Integer.parseInt(dateParts[2]) - 1900));
    }
    
    /**
     * Checks if the given name is valid or not.
     * @param name The person's name to be validated.
     * @return Whether the person's name is valid or not.
     */
    public static boolean validateName(String name) {
        return name.matches(REGEX_NAME);
    }
    
    /**
     * Sets the current Person name.
     * @param name The person's name.
     * @throws InvalidNameException If the name given is invalid.
     */
    public void setName(String name) throws InvalidNameException {
        if (!validateName(name)) {
            throw new InvalidNameException("Invalid characters for the name given.");
        } else {
            personName = name;
        }
    }
    
    /**
     * Returns the current Person name.
     * @return Returns the Person object name.
     */
    public String getName() {
        return personName;
    }
    
    /**
     * Sets the current CPF number to the Person object.
     * @param cpf The cpf number as a string.
     * @throws InvalidCPFNumberException If the CPF given is invalid.
     */
    public void setCPF(String cpf) throws InvalidCPFNumberException {
        cpfNumber = new CPF(cpf);
    }
    
    /**
     * Returns the CPF number data as a CPF object.
     * @return Returns the current CPF number. 
     */
    public CPF getCPF() {
        return cpfNumber;
    }
    
    /**
     * Returns the current gender of the person object.
     * @return The current gender.
     */
    public String getGender() {
        return sexType;
    }
    
    /**
     * Sets the new gender for the person object.
     * @param gender The new gender.
     */
    public void setGender(String gender) {
        sexType = gender;
    }
    
    /**
     * Sets the current birth date to the Person object.
     * @param birth The birth date as a string.
     */
    public void setBirthDate(String birth) {
        birthDate = new Date(birth);
    }
    
    /**
     * Returns the current birth date of the Person object.
     * @return Returns the Person object birth date.
     */
    public String getBirthDate() {
        return String.format("%02d/%02d/%04d", birthDate.getDate(), birthDate.getMonth()+1, birthDate.getYear() + 1900);
    }
    
    /**
     * Sets the new ID type for the person object.
     * @param idType The new ID type.
     */
    public void setIDType(String idType) {
        this.idType = idType;
    }
    
    /**
     * Returns the current ID type of the person object.
     * @return The current ID type.
     */
    public String getIDType() {
        return idType;
    }
    
    /**
     * Sets the new ID number for the person object.
     * @param number The ID number.
     */ 
    public void setIDNumber(String number) {
        idNumber = number;
    }
    
    /**
     * Returns the current ID number of the person object.
     * @return The current ID number.
     */
    public String getIDNumber() {
        return idNumber;
    }
    
    /**
     * Sets the new marital status for the person object.
     * @param mstatus The new marital status.
     */
    public void setMaritalStatus(String mstatus) {
        maritalStatus = mstatus;
    }
    
    /**
     * Returns the current marital status of the person object.
     * @return The current marital status.
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }
}