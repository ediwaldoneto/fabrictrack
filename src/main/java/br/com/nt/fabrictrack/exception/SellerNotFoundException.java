/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class SellerNotFoundException extends Exception {

    private static final long serialVersionUID = -8403582717999893071L;

    /**
     * 
     */
    public SellerNotFoundException() {
	super();

    }

    /**
     * @param message
     * @param cause
     */
    public SellerNotFoundException(String message, Throwable cause) {
	super(message, cause);

    }

    /**
     * @param message
     */
    public SellerNotFoundException(String message) {
	super(message);

    }

}
