/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.model.Order;
import br.com.nt.fabrictrack.model.dto.SaleDTO;

/**
 * @author Neto
 *
 */
@Service
public class TransactionSalesManager {

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private SellerServiceImpl sellerService;
    
    @Autowired
    private OrderServiceImpl orderService;

    /**
     * @param dto
     * @throws ClientNotFoundException
     * @throws SellerNotFoundException
     */
    @Transactional
    public void registerSale(final SaleDTO dto) throws ClientNotFoundException, SellerNotFoundException {
	Order order = new Order();
	order.setIdClient(clientService.checkClientExists(dto.getIdClient()));
	order.setIdSeller(sellerService.checkSellerExists(dto.getIdSeller()));
	Long idOrder = orderService.save(order);
	log.info("id order {}", idOrder);
	
	
    }
}
