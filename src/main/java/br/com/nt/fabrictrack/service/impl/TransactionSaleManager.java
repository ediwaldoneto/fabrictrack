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
import br.com.nt.fabrictrack.exception.InsufficientStockException;
import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.exception.StockNotFoundException;
import br.com.nt.fabrictrack.model.Financial;
import br.com.nt.fabrictrack.model.Order;
import br.com.nt.fabrictrack.model.OrderItem;
import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.model.Transaction;
import br.com.nt.fabrictrack.model.dto.SaleDTO;
import br.com.nt.fabrictrack.model.dto.SaleItemsDTO;
import br.com.nt.fabrictrack.util.Constants;

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

    @Autowired
    private TransactionServiceImpl transactionService;

    @Autowired
    private FinancialServiceImpl financialService;

    @Autowired
    private OrderItemServiceImpl orderItemService;

    /**
     * @param dto
     * @throws ClientNotFoundException
     * @throws SellerNotFoundException
     * @throws StockNotFoundException
     * @throws InsufficientStockException
     */
    @Transactional
    public void registerSale(final SaleDTO dto) throws ClientNotFoundException, SellerNotFoundException,
	    StockNotFoundException, InsufficientStockException {

	// Cria um novo pedido
	Order order = new Order();
	order.setIdClient(clientService.checkClientExists(dto.getIdClient()));
	order.setIdSeller(sellerService.checkSellerExists(dto.getIdSeller()));
	order.setOrderDate(new Date());
	Long idOrder = orderService.save(order);
	log.info("created order number {}", idOrder);

	// Percorre os produtos vendidos e atualize o estoque, registre as transações e
	// insira no financeiro
	for (SaleItemsDTO saleItem : dto.getItens()) {
	    Product product = productService.findById(saleItem.getIdProduct());
	    Stock stock = stockService.findById(product.getId());

	    // Verifica se há estoque disponível
	    if (stock.getAmount() >= saleItem.getAmount()) {
		log.info("updating stock for the product {}", product.getName());
		// Atualiza o estoque
		stock.setAmount(stock.getAmount() - saleItem.getAmount());
		stockService.update(stock);

		// Registra a transação de venda
		Transaction transaction = new Transaction();
		transaction.setType(TransactionType.SALE.getType()); // VENDA
		transaction.setTransactionDate(new Date());
		transaction.setAmount(saleItem.getAmount());
		transaction.setTransactionValue(
			product.getProductValue().multiply(BigDecimal.valueOf(saleItem.getAmount())));
		transaction.setIdProduct(product.getId());
		transaction.setIdSale(idOrder); // Associando o ID da venda à transação
		transactionService.save(transaction);

		// Insire a transação no financeiro, associando o ID da venda
		Financial financial = new Financial();
		financial.setType(TransactionType.REVENUE.getType()); // RECEITA
		financial.setTransactionDate(new Date());
		financial.setTransactionValue(
			product.getProductValue().multiply(BigDecimal.valueOf(saleItem.getAmount())));
		financial.setDescription(Constants.MSG_DESCRIPTION_01);
		financial.setIdSale(idOrder);
		financialService.save(financial);

		// Cria um novo item de pedido e associe-o ao pedido atual
		OrderItem orderItem = new OrderItem();
		orderItem.setIdOrder(idOrder);
		orderItem.setIdProduct(product.getId());
		orderItem.setAmount(saleItem.getAmount());
		orderItemService.save(orderItem);
		log.info("successful sale");
	    } else {
		orderService.update(idOrder, Constants.MSG_DESCRIPTION_02 + product.getId());
		throw new InsufficientStockException("Insufficient stock for the product: " + product.getName());
	    }
	}

    }

    public void cancelSale() {
    }
}
