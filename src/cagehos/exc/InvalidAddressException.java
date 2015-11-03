package cagehos.exc;

/**
 * The class for invalid Address name or number exception.
 * @author Julio Ceron, Leonardo Falk
 */
public class InvalidAddressException extends RuntimeException {

    /**
     * Creates a new instance of <code>InvalidAddressException</code> without
     * detail message.
     */
    public InvalidAddressException() {
    }
    
   /**
     * Throws the InvalidAddressException object with the message given.
     * @param msg The message to be displayed.
     */
    public InvalidAddressException(String msg) {
        super(msg);
    }
}
