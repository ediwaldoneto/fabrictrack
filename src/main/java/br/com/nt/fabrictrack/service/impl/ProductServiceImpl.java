/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.repository.impl.ProductRepositoryImpl;
import br.com.nt.fabrictrack.service.ProductService;

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
	return repository.findById(id);
    }

    @Override
    public void update(Product product) {
	repository.update(product);
    }

    @Override
    public void delete(Long id) {
	repository.delete(id);
    }

    @Override
    public Long save(Product product) {
	return repository.save(product);
    }

}
