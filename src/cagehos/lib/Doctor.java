package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import javax.naming.InvalidNameException;

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
     * @param sexType The doctor's sex gender as 1 for male or 2 for female.
     * @param cpf The doctor's CPF.
     * @param birth The doctor's birth date.
     * @throws InvalidNameException If the doctor's name contains invalid letters.
     * @throws InvalidCPFNumberException If the doctor's CPF contains a invalid sequence.
     */
    public Doctor(String name, int sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
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
    
    public void setCRM(int crmNumber) {
        crmID = crmNumber;
    }
    
    public int getCRM() {
        return crmID;
    }
}
