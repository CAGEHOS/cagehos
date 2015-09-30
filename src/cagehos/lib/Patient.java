package cagehos.lib;

import cagehos.exc.InvalidCPFNumberException;
import javax.naming.InvalidNameException;

/**
 * The Patient class provides methods to create and access information about the patients of the hospital.
 * @author Julio Ceron, Leonardo Falk
 */
public class Patient extends Person {

    /**
     * The ID for undefined racial class for a person.
     */
    public final static int CLASS_NONE = 0;

    /**
     * The ID for white racial class for a person.
     */
    public final static int CLASS_WHITE = 1;

    /**
     * The ID for black racial class for a person.
     */
    public final static int CLASS_BLACK = 2;

    /**
     * The ID for indian racial class for a person.
     */
    public final static int CLASS_INDIAN = 3;

    /**
     * The ID for mulatto racial class for a person.
     */
    public final static int CLASS_MULATTO = 4;

    /**
     * The ID for yellow racial class for a person.
     */
    public final static int CLASS_YELLOW = 5;
    
    /**
     * The ID for undefined marital status of a person.
     */
    public final static int MSTATUS_NONE = 0;

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
    
    private String fatherName;
    private String motherName;
    private String bloodType;
    private String bloodFactor;
    private String observations;
    private int classType;
    private Address address;
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
}
