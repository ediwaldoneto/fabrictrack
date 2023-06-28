/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class InsufficientStockException extends Exception{

    private static final long serialVersionUID = 3843854190371123363L;

    /**
     * 
     */
    public InsufficientStockException() {
	super();
	
    }

    /**
     * @param message
     * @param cause
     */
    public InsufficientStockException(String message, Throwable cause) {
	super(message, cause);
	
    }

    /**
     * @param message
     */
    public InsufficientStockException(String message) {
	super(message);
	
    }
    
    

}
