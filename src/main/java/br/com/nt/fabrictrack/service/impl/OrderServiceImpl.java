/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Order;
import br.com.nt.fabrictrack.repository.impl.OrderRepositoryImpl;
import br.com.nt.fabrictrack.service.OrderService;

/**
 * @author Neto
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepositoryImpl repository;

    @Override
    public Long save(Order order) {
	return repository.save(order);
    }

    @Override
    public void update(final Long id, final String reason) {
	repository.update(id, reason);
	
    }

    @Override
    public boolean checkOrderExists(Long id) {
	return repository.checkOrderExists(id);
	
	
    }

}
