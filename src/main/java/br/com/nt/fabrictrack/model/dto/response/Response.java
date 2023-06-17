/**
 * 
 */
package br.com.nt.fabrictrack.model.dto.response;

import java.time.LocalDateTime;

/**
 * @author Neto
 *
 */
public class Response<T> {

    private T data;
    private Object errors;

    public void addErrorMsgResponse(final String msgError) {
	ResponseError error = new ResponseError();
	error.setDetails(msgError);
	error.setLocalDateTime(LocalDateTime.now());
	setErrors(error);

    }

    /**
     * @return the data
     */
    public T getData() {
	return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(T data) {
	this.data = data;
    }

    /**
     * @return the errors
     */
    public Object getErrors() {
	return errors;
    }

    /**
     * @param errors the errors to set
     */
    public void setErrors(Object errors) {
	this.errors = errors;
    }

}
