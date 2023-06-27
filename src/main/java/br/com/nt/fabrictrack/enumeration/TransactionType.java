/**
 * 
 */
package br.com.nt.fabrictrack.enumeration;

/**
 * @author Neto
 *
 */
public enum TransactionType {

    SALE("VENDA"), REVENUE("RECEITA"), EXPENSE("DESPESA");

    private String type;

    /**
     * @param type
     */
    private TransactionType(String type) {
	this.type = type;
    }

    /**
     * @return the type
     */
    public String getType() {
	return type;
    }

}
