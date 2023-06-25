/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import java.util.List;

import br.com.nt.fabrictrack.model.Product;

/**
 * @author Neto
 *
 */
public interface ProductRepository {

    public Product findById(final Long id);

    public List<Product> findAll();

    public Long save(final Product product);

    public void delete(final Long id);

    public void update(final Long id);

    public Long recoverSequence();
}
