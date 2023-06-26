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
import br.com.nt.fabrictrack.repository.impl.SellerRepositoryImpl;
import br.com.nt.fabrictrack.service.SellerService;

/**
 * @author Neto
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepositoryImpl repository;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @Override
    public void save(Seller seller) {
	repository.save(seller);
    }

    @Override
    public void update(Seller seller) {
	repository.update(seller);
    }

    @Override
    public Seller findSeller(String user) throws SellerNotFoundException {
	return repository.findSeller(user);
    }

    @Override
    public Seller findSeller(Long id) throws SellerNotFoundException {
	return repository.findSeller(id);
    }

    @Override
    public Long checkSellerExists(Long id) throws SellerNotFoundException {
	log.info("checking if the seller exists in the database {}", id);
	return repository.checkSellerExists(id);
    }

}
