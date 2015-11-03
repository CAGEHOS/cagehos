package cagehos.exc;

/**
 * The class for invalid CPF number exception.
 * @author Julio Ceron, Leonardo Falk
 */
public class InvalidCPFNumberException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidCPFNumberException</code> without
     * detail message.
     */
    public InvalidCPFNumberException() {
    }
    
    /**
     * Throws the InvalidCPFNumberException object with the message given.
     * @param msg The message to be displayed.
     */
    public InvalidCPFNumberException(String msg) {
        super(msg);
    }
}