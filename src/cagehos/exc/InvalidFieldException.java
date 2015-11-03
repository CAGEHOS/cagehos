package cagehos.exc;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException() {
        
    }
    
    public InvalidFieldException(String msg) {
        super(msg);
    }
}