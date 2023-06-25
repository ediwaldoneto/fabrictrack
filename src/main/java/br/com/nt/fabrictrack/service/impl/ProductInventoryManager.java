/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.model.dto.ProductDTO;
import br.com.nt.fabrictrack.model.dto.ProductStockDTO;

/**
 * @author Neto
 *
 */
@Service
public class ProductInventoryManager {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private StockServiceImpl stockService;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    /**
     * @param dto
     */
    public void registerProductStock(final ProductStockDTO dto) {
	log.info("product registration in the database");

	final long idProduct = productService.save(dto.convertEntityProduct());

	final Stock stock = new Stock();
	stock.setIdProduct(idProduct);
	stock.setStockLocation(dto.getStockLocation());
	stock.setAmount(dto.getAmount());
	stock.setDateRegister(new Date());
	registerStock(stock);
    }

    /**
     * @return
     */
    public List<ProductDTO> findAllProduct() {
	log.info("searching for all database records");
	List<Product> list = productService.findAll();
	return list.stream().map(Product::convertEntity).collect(Collectors.toList());
    }

    /**
     * @param id
     * @return
     */
    public ProductDTO findByIdProduct(final Long id) {
	Product product = productService.findById(id);
	return product.convertEntity();
    }

    /**
     * @param stock
     */
    public void registerStock(final Stock stock) {
	log.info("saving stock for the product");
	stockService.save(stock);
    }
}
