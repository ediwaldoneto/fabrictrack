/**
 * 
 */
package br.com.nt.fabrictrack.model;

import org.modelmapper.ModelMapper;

import br.com.nt.fabrictrack.model.dto.SellerDTO;

/**
 * @author Neto
 *
 */
public class Seller extends Person {

    private Long id;
    private String user;

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
     * @return the user
     */
    public String getUser() {
	return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
	this.user = user;
    }

    public SellerDTO convertyEntity() {
	return new ModelMapper().map(this, SellerDTO.class);
    }
}
