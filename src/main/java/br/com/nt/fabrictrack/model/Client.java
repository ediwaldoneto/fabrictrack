/**
 * 
 */
package br.com.nt.fabrictrack.model;

import org.modelmapper.ModelMapper;

import br.com.nt.fabrictrack.model.dto.ClientDTO;

/**
 * @author Neto
 *
 */
public class Client extends Person {

    private Long id;

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

    public ClientDTO convertEntity() {
	return new ModelMapper().map(this, ClientDTO.class);
    }
}
