/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

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

    @Override
    public void save(Seller seller) {
	repository.save(seller);
    }

    @Override
    public void update(Seller seller) {
	repository.update(seller);
    }

    @Override
    public Seller findSeller(String user) throws SellerNotFoundException{
	return repository.findSeller(user);
    }

    @Override
    public Seller findSeller(Long id) throws SellerNotFoundException {
	return repository.findSeller(id);
    }

}
