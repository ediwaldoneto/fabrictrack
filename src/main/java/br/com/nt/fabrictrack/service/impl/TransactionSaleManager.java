/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.nt.fabrictrack.enumeration.TransactionType;
import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.exception.StockNotFoundException;
import br.com.nt.fabrictrack.model.Order;
import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.model.Transaction;
import br.com.nt.fabrictrack.model.dto.SaleDTO;
import br.com.nt.fabrictrack.model.dto.SaleItemsDTO;

/**
 * @author Neto
 *
 */
@Service
public class TransactionSaleManager {

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @Autowired
    private ClientServiceImpl clientService;

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private StockServiceImpl stockService;

    /**
     * @param dto
     * @throws ClientNotFoundException
     * @throws SellerNotFoundException
     * @throws StockNotFoundException
     */
    @Transactional
    public void registerSale(final SaleDTO dto)
	    throws ClientNotFoundException, SellerNotFoundException, StockNotFoundException {

	// Crie um novo pedido
	Order order = new Order();
	order.setIdClient(clientService.checkClientExists(dto.getIdClient()));
	order.setIdSeller(sellerService.checkSellerExists(dto.getIdSeller()));
	Long idOrder = orderService.save(order);
	log.info("created order number {}", idOrder);

	// Percorra os produtos vendidos e atualize o estoque, registre as transações e
	// insira no financeiro
	for (SaleItemsDTO saleItem : dto.getItens()) {
	    Product product = productService.findById(saleItem.getIdProduct());
	    Stock stock = stockService.findById(product.getId());

	    if (stock.getAmount() >= saleItem.getAmount()) {
		log.info("updating stock for the product {}", product.getName());
		stock.setAmount(stock.getAmount() - saleItem.getAmount());
		stockService.save(stock);

		Transaction transaction = new Transaction();
		transaction.setType(TransactionType.SALE.getType());
		transaction.setTransactionDate(new Date());
		transaction.setAmount(saleItem.getAmount());
		transaction.setTransactionValue(
			product.getProductValue().multiply(BigDecimal.valueOf(saleItem.getAmount())));
		transaction.setIdProduct(product.getId());
		transaction.setIdSale(idOrder);
		
	    }
	}

    }
}
