package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import javax.naming.InvalidNameException;

/**
 * The Employee class provides methods to create and access information about any employee of the hospital.
 * @author Julio Ceron, Leonardo Falk
 */
public class Employee extends Person {
    private String profession, obs, workSection;
    
    /**
     * Creates the object Employee with information about the person.
     * @param name The employee's name.
     * @param sexType The employee's sex gender as 1 for male or 2 for female.
     * @param cpf The employee's CPF.
     * @param birth The employee's birth date.
     * @throws InvalidNameException If the employee's name contains invalid letters.
     * @throws InvalidCPFNumberException If the employee's CPF contains a invalid sequence.
     */
    public Employee(String name, int sexType, String cpf, String birth) throws InvalidNameException, InvalidCPFNumberException {
        super(name, sexType, cpf, birth);
    }
    
    /**
     * Returns the employee's profession name.
     * @return The employee's profession name.
     */
    public String getProfession() {
        return profession;
    }
    
    /**
     * Sets the current employee's profession.
     * @param prof The new employee's profession name.
     */
    public void setProfession(String prof) {
        profession = prof;
    }
    
    public String getObservations() {
        return obs;
    }
    
    public void setObservations(String newObs) {
        obs = newObs;
    }
    
    public void setWorkingSection(String section) {
        workSection = section;
    }
    
    public String getWorkingSection() {
        return workSection;
    }
}
