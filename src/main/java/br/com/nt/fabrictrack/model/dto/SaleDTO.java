/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

import java.util.List;

/**
 * @author Neto
 *
 */
public class SaleDTO {

    private Long idClient;
    private Long idSeller;
    private List<SaleItemsDTO> itens;

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
     * @return the itens
     */
    public List<SaleItemsDTO> getItens() {
	return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<SaleItemsDTO> itens) {
	this.itens = itens;
    }

}
