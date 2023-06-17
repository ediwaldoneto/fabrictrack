/**
 * 
 */
package br.com.nt.fabrictrack.service;

import br.com.nt.fabrictrack.model.Seller;

/**
 * @author Neto
 *
 */
public interface SellerService {

    public void save(final Seller seller);

    public void update(final Seller seller);

    public Seller findSeller(final String user);

    public Seller findSeller(final Long id);
}
