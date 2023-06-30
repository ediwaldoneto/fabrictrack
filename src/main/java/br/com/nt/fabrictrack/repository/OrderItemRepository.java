/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import br.com.nt.fabrictrack.model.OrderItem;

/**
 * @author Neto
 *
 */
public interface OrderItemRepository {

    public void save(final OrderItem orderItem);
    
}
