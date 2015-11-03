package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import cagehos.exc.InvalidNameException;

/**
 * The Doctor class provides methods to create and access information about any doctor of the hospital.
 * @author Julio Ceron, Leonardo Falk
 */
public class Doctor extends Employee {
    private String treatment;
    private int crmID;
    /**
     * Creates the object Doctor with information about the person.
     * @param name The doctor's name.
     * @param sexType The doctor's sex gender.
     * @param cpf The doctor's CPF.
     * @param birth The doctor's birth date.
     * @throws InvalidNameException If the doctor's name contains invalid letters.
     * @throws InvalidCPFNumberException If the doctor's CPF contains a invalid sequence.
     */
    public Doctor(String name, String sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
        super(name, sexType, cpf, birth);
    }
    
    /**
     * Sets the treatment form for the Doctor object.
     * @param treat The new treatment form.
     */
    public void setTreatment(String treat) {
        treatment = treat;
    }
    
    /**
     * Returns the current treatment form of the Doctor object.
     * @return The current treatment form.
     */
    public String getTreatment() {
        return treatment;
    }
    
    /**
     * Sets the new CRM number for the Doctor object.
     * @param crmNumber The new CRM number.
     */
    public void setCRM(int crmNumber) {
        crmID = crmNumber;
    }
    
    /**
     * Returns the current CRM number of the Doctor object.
     * @return The current CRM number.
     */
    public int getCRM() {
        return crmID;
    }
}
