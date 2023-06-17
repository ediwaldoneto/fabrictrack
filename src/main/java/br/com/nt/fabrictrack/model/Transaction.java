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
public class Transaction {
    
    private Long id;
    private String type;
    private Date transactionDate;
    private int amount;
    private BigDecimal transactionValue;
    private Long idProduct;
    private Long idSale;
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
    
    
    
}
