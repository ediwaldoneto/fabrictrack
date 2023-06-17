/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.model.Seller;
import br.com.nt.fabrictrack.model.dto.SellerDTO;
import br.com.nt.fabrictrack.util.Constants;

/**
 * @author Neto
 *
 */
@Service
public class SellerProcessing {

    @Autowired
    private SellerServiceImpl service;
    
    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    
    /**
     * @param dto
     */
    public void registerSeller(final SellerDTO dto) {
	log.info("registering seller {}", dto.getId());
	service.save(dto.convertyEntity());
    }

    /**
     * @param id
     * @return
     * @throws SellerNotFoundException 
     */
    public SellerDTO findBySellerCode(final Long id) throws SellerNotFoundException {
	log.info("searching seller in the database {}", id);
	Seller seller = service.findSeller(id);
	if (seller == null) {
	    throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND);
	}
	return seller.convertyEntity();
    }
}
