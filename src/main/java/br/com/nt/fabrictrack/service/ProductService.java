/**
 * 
 */
package br.com.nt.fabrictrack.service;

import java.util.List;

import br.com.nt.fabrictrack.model.Product;

/**
 * @author Neto
 *
 */
public interface ProductService {

    public List<Product> findAll();

    public Product findById(final Long id);

    public void update(final Product product);

    public void delete(final Long id);

    public Long save(final Product product);
}
