/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6701032034268006053L;

    public ProductNotFoundException() {
	super();
    }

    public ProductNotFoundException(String message) {
	super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
	super(message, cause);
    }

}
