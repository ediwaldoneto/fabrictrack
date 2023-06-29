/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

/**
 * @author Neto
 *
 */
public class SaleItemsDTO {

    
    private Long idProduct;
    private int amount;

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
