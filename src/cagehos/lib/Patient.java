package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import javax.naming.InvalidNameException;

/**
 * The Patient class provides methods to create and access information about the patients of the hospital.
 * @author Julio Ceron, Leonardo Falk
 */
public class Patient extends Person {
    /**
     * The ID for undefined marital status of a person.
     */
    public final static int MSTATUS_SINGLE = 0;

    /**
     * The ID for married marital status of a person.
     */
    public final static int MSTATUS_MARRIED = 1;

    /**
     * The ID for divorced marital status of a person.
     */
    public final static int MSTATUS_DIVORCED = 2;

    /**
     * The ID for separated marital status of a person.
     */
    public final static int MSTATUS_SEPARATED = 3;

    /**
     * The ID for other marital status of a person.
     */
    public final static int MSTATUS_OTHER = 4;
    
    private String bloodType;
    private String observations;
    private int maritalStatus;
    
    /**
     * Creates the object Patient with the information about the person.
     * @param name The patient's name.
     * @param sexType The patients's sex gender as 1 for male or 2 for female.
     * @param cpf The patient's CPF number.
     * @param birth The patient's birth date.
     * @throws InvalidNameException If the patient's name contains invalid letters.
     * @throws InvalidCPFNumberException  If the patient's CPF number contains a invalid sequence.
     */
    public Patient(String name, int sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
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

    /**
     * Sets the new marital status for the patient object.
     * @param mstatus The new marital status.
     */
    public void setMaritalStatus(int mstatus) {
        maritalStatus = mstatus;
    }
    
    /**
     * Returns the current marital status of the patient object.
     * @return The current marital status.
     */
    public int getMaritalStatus() {
        return maritalStatus;
    }
}
