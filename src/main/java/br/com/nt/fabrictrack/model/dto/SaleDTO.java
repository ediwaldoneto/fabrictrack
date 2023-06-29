/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @author Neto
 *
 */
public class SaleDTO {

    @NotNull(message = "id client cannot be null")
    @Positive(message = "id client cannot be negative")
    private Long idClient;
    @NotNull(message = "id seller cannot be null")
    @Positive(message = "id seller cannot be negative")
    private Long idSeller;
    @NotEmpty(message = "item list cannot be empty")
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
