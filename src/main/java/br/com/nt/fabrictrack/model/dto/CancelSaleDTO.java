/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

/**
 * @author Neto
 *
 */
public class CancelSaleDTO {

    private Long order;
    private String reason;

    /**
     * @return the order
     */
    public Long getOrder() {
	return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(Long order) {
	this.order = order;
    }

    /**
     * @return the reason
     */
    public String getReason() {
	return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
	this.reason = reason;
    }

}
