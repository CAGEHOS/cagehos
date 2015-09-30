package cagehos.tests;

import cagehos.exc.InvalidCPFNumberException;
import cagehos.lib.Person;
import javax.naming.InvalidNameException;

public class TestPerson {
    public static void main(String[] args) throws InvalidNameException, InvalidCPFNumberException {
        Person eu = new Person("Leonardo Falk", cagehos.lib.Person.SEX_MALE, "03359459024", "06/20/1994");
        Person invalid = new Person("450", cagehos.lib.Person.SEX_MALE, "03359459024", "06/20/1994");
        
        System.out.println(eu);
        System.out.println(invalid);
    }
}
