/**
 * 
 */
package br.com.nt.fabrictrack.model;

import java.util.Date;

/**
 * @author Neto
 *
 */
public class Order {

    private Long id;
    private Long idClient;
    private Long idSeller;
    private boolean canceled;
    private Date orderDate;
    private String cancellationReason;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the idClient
     */
    public Long getIdClient() {
	return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Long idClient) {
	this.idClient = idClient;
    }

    /**
     * @return the idSeller
     */
    public Long getIdSeller() {
	return idSeller;
    }

    /**
     * @param idSeller the idSeller to set
     */
    public void setIdSeller(Long idSeller) {
	this.idSeller = idSeller;
    }

    /**
     * @return the canceled
     */
    public boolean isCanceled() {
	return canceled;
    }

    /**
     * @param canceled the canceled to set
     */
    public void setCanceled(boolean canceled) {
	this.canceled = canceled;
    }

    public Date getOrderDate() {
	return orderDate;
    }

    public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
    }

    public String getCancellationReason() {
	return cancellationReason;
    }

    public void setCancellationReason(String cancellationReason) {
	this.cancellationReason = cancellationReason;
    }

}
