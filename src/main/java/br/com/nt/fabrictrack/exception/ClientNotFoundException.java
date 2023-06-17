/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class ClientNotFoundException extends Exception{

    private static final long serialVersionUID = -3298558563329298181L;

    /**
     * 
     */
    public ClientNotFoundException() {
	super();
	
    }

    /**
     * @param message
     * @param cause
     */
    public ClientNotFoundException(String message, Throwable cause) {
	super(message, cause);
	
    }

    /**
     * @param message
     */
    public ClientNotFoundException(String message) {
	super(message);
	
    }
    
    

}
