/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class StockNotFoundException extends Exception {

    private static final long serialVersionUID = 3754217530478236126L;

    /**
     * 
     */
    public StockNotFoundException() {
	super();

    }

    /**
     * @param message
     * @param cause
     */
    public StockNotFoundException(String message, Throwable cause) {
	super(message, cause);

    }

    /**
     * @param message
     */
    public StockNotFoundException(String message) {
	super(message);

    }

}
