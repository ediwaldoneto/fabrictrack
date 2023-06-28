/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.OrderItem;
import br.com.nt.fabrictrack.repository.impl.OrderItemRepositoryImpl;
import br.com.nt.fabrictrack.service.OrderItemService;

/**
 * @author Neto
 *
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
    
    @Autowired
    private OrderItemRepositoryImpl repository;

    @Override
    public void save(OrderItem orderItem) {
	repository.save(orderItem);
	
    }

}
