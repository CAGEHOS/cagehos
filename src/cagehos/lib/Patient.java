package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import cagehos.exc.InvalidNameException;

/**
 * The Patient class provides methods to create and access information about the patients of the hospital.
 * @author Julio Ceron, Leonardo Falk
 */
public class Patient extends Person {
    private String bloodType;
    private String observations;
    
    /**
     * Creates the object Patient with the information about the person.
     * @param name The patient's name.
     * @param sexType The doctor's sex gender.
     * @param cpf The patient's CPF number.
     * @param birth The patient's birth date.
     * @throws InvalidNameException If the patient's name contains invalid letters.
     * @throws InvalidCPFNumberException  If the patient's CPF number contains a invalid sequence.
     */
    public Patient(String name, String sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
        super(name, sexType, cpf, birth);
    }
    
    /**
     * Sets the new blood type for the patient object.
     * @param bType The new blood type.
     */
    public void setBloodType(String bType) {
        bloodType = bType;
    }
    
    /**
     * Returns the current blood type of the patient object.
     * @return The current blood type.
     */
    public String getBloodType() {
        return bloodType;
    }
    
    /**
     * Sets the new medical observations for the patient object.
     * @param obs The new observations.
     */
    public void setObservations(String obs) {
        observations = obs;
    }
    
    /**
     * Returns the current medical observations of the patient object.
     * @return The current observations.
     */
    public String getObservations() {
        return observations;
    }
}
