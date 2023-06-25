/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.exception.ProductNotFoundException;
import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.repository.impl.ProductRepositoryImpl;
import br.com.nt.fabrictrack.service.ProductService;
import br.com.nt.fabrictrack.util.Constants;

/**
 * @author Neto
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryImpl repository;

    @Override
    public List<Product> findAll() {
	return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
	try {
	    return repository.findById(id);
	} catch (Exception e) {
	    throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND);
	}
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long save(Product product) {
	return repository.save(product);
    }

}
