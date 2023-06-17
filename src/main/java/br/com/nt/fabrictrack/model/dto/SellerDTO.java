/**
 * 
 */
package br.com.nt.fabrictrack.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.modelmapper.ModelMapper;

import br.com.nt.fabrictrack.model.Seller;

/**
 * @author Neto
 *
 */
public class SellerDTO {

    @NotNull(message = "choose a code for the seller and inform")
    private Long id;
    @NotBlank(message = "full username is required")
    @Pattern(regexp = "^[a-zA-Z]+\\.[a-zA-Z]+$", message = " the username must be in the format 'name.surname'")
    private String user;
    @NotNull(message = "name cannot be null")
    private String name;

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

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    public Seller convertyEntity() {
	return new ModelMapper().map(this, Seller.class);
    }

}
