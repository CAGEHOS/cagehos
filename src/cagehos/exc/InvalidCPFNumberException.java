package cagehos.exc;

/**
 * The class for invalid CPF number exception.
 * @author Julio Ceron, Leonardo Falk
 */
public class InvalidCPFNumberException extends Exception {

    /**
     * Throws the InvalidCPFNumberException object with the message given.
     * @param msg The message to be displayed.
     */
    public InvalidCPFNumberException(String msg) {
        super(msg);
    }
}