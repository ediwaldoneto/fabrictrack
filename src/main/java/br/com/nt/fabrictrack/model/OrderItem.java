/**
 * 
 */
package br.com.nt.fabrictrack.model;

/**
 * @author Neto
 *
 */
public class OrderItem {

    private Long id;
    private Long idOrder;
    private Long idProduct;
    private int amount;

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
     * @return the idOrder
     */
    public Long getIdOrder() {
	return idOrder;
    }

    /**
     * @param idOrder the idOrder to set
     */
    public void setIdOrder(Long idOrder) {
	this.idOrder = idOrder;
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
