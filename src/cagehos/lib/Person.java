package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;

import java.util.Date;
import javax.naming.InvalidNameException;

/**
 * The Person class provides methods to create and access any person information.
 * @author Julio Ceron, Leonardo Falk
 */
public class Person {
    /**
     * The ID of undefined sex for a person.
     */
    public final static int SEX_NONE = 0;

    /**
     * The ID of male sex for a person.
     */
    public final static int SEX_MALE = 1;

    /**
     * The ID of female sex for a person.
     */
    public final static int SEX_FEMALE = 2;
    
    /**
     * The regular expression for people names.
     */
    public final static String REGEX_NAME = "^[\\p{L} '-]+$";
    
    private String personName;
    private CPF cpfNumber = null;
    private Date birthDate = null;
    private int sexType;
    /**
     * Returns a Person object with the given information.
     * @param name The person's name.
     * @param sexType The person's sex gender as 1 for male or 2 for female.
     * @param cpf The person's CPF number.
     * @param birth The person's birth date.
     * @throws InvalidNameException If the person's name contains any non valid character.
     * @throws InvalidCPFNumberException If the CPF number given is invalid.
     */
    public Person(String name, int sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
        if (!validateName(name)) {
            throw new InvalidNameException("Letras inválidas para o nome da pessoa.");
        }
        
        personName = name;
        this.sexType = sexType;
        cpfNumber  = new CPF(cpf);
        birthDate  = new Date(birth);
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
    public Date getBirthDate() {
        return birthDate;
    }
    
    /**
     * Returns a string representation of the Person's object data.
     * @return Returns a string representation of the Person object. 
     */
    @Override
    public String toString() {
        return String.format("[Person] [Name: %s] [CPF: %s] [BirthDate: %s]", personName, cpfNumber.toString(true), birthDate.toString());
    }
}