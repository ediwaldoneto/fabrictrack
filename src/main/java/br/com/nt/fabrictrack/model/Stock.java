/**
 * 
 */
package br.com.nt.fabrictrack.model;

import java.util.Date;

/**
 * @author Neto
 *
 */
public class Stock {

    private Long id;
    private Long idProduct;
    private int amount;
    private Date dateRegister;
    private String stockLocation;

    /**
     * @return the dateRegister
     */
    public Date getDateRegister() {
	return dateRegister;
    }

    /**
     * @param dateRegister the dateRegister to set
     */
    public void setDateRegister(Date dateRegister) {
	this.dateRegister = dateRegister;
    }

    /**
     * @return the stockLocation
     */
    public String getStockLocation() {
	return stockLocation;
    }

    /**
     * @param stockLocation the stockLocation to set
     */
    public void setStockLocation(String stockLocation) {
	this.stockLocation = stockLocation;
    }

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
     * @return the idProduct
     */
    public Long getIdProduct() {
	return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(Long idProduct) {
	this.idProduct = idProduct;
    }

    /**
     * @return the amount
     */
    public int getAmount() {
	return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
	this.amount = amount;
    }

}
