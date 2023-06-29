/**
 * 
 */
package br.com.nt.fabrictrack.service;

import br.com.nt.fabrictrack.model.Order;

/**
 * @author Neto
 *
 */
public interface OrderService {

    public Long save(final Order order);

    public void update(final Long id, final String reason);
}
