/**
 * 
 */
package br.com.nt.fabrictrack.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Neto
 *
 */
public class Financial {

    private Long id;
    private String type;
    private Date transactionDate;
    private BigDecimal transactionValue;
    private Long idSale;
    private String description;

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
     * @return the type
     */
    public String getType() {
	return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
	this.type = type;
    }

    /**
     * @return the transactionDate
     */
    public Date getTransactionDate() {
	return transactionDate;
    }

    /**
     * @param transactionDate the transactionDate to set
     */
    public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
    }

    /**
     * @return the transactionValue
     */
    public BigDecimal getTransactionValue() {
	return transactionValue;
    }

    /**
     * @param transactionValue the transactionValue to set
     */
    public void setTransactionValue(BigDecimal transactionValue) {
	this.transactionValue = transactionValue;
    }

    /**
     * @return the idSale
     */
    public Long getIdSale() {
	return idSale;
    }

    /**
     * @param idSale the idSale to set
     */
    public void setIdSale(Long idSale) {
	this.idSale = idSale;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

}
