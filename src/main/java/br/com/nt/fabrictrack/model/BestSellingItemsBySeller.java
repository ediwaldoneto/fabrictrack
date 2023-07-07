/**
 * 
 */
package br.com.nt.fabrictrack.model;

/**
 * @author Neto
 *
 */
public class BestSellingItemsBySeller {

    private String seller;
    private String product;
    private int soldAmount;

    /**
     * @return the seller
     */
    public String getSeller() {
	return seller;
    }

    /**
     * @param seller the seller to set
     */
    public void setSeller(String seller) {
	this.seller = seller;
    }

    /**
     * @return the product
     */
    public String getProduct() {
	return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(String product) {
	this.product = product;
    }

    /**
     * @return the soldAmount
     */
    public int getSoldAmount() {
	return soldAmount;
    }

    /**
     * @param soldAmount the soldAmount to set
     */
    public void setSoldAmount(int soldAmount) {
	this.soldAmount = soldAmount;
    }

}
