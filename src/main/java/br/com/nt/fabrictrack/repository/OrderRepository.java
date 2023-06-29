/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import br.com.nt.fabrictrack.model.Order;

/**
 * @author Neto
 *
 */
public interface OrderRepository {

    public Long save(final Order order);

    public void update(final Long id, final String reason);

}
