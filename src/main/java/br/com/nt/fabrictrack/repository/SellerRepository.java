/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.model.Seller;

/**
 * @author Neto
 *
 */
public interface SellerRepository {

    public void save(final Seller seller);

    public void update(final Seller seller);

    public Seller findSeller(final String user) throws SellerNotFoundException;

    public Seller findSeller(final Long id)throws SellerNotFoundException;
}
