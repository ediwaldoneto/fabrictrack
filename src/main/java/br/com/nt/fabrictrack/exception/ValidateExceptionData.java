/**
 * 
 */
package br.com.nt.fabrictrack.exception;

/**
 * @author Neto
 *
 */
public class ValidateExceptionData extends RuntimeException {

    private static final long serialVersionUID = 846903318016032270L;

    /**
     * @param message
     */
    public ValidateExceptionData(String message) {
	super(message);
    }

}
