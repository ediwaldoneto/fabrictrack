/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.model.dto.ProductDTO;

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
    public void registerProduct(final ProductDTO dto) {
	log.info("registering product");
	productService.save(dto.convertEntity());
    }

    /**
     * @return
     */
    public List<ProductDTO> findAllProduct() {
	log.info("searching for all database records");
	List<Product> list = productService.findAll();
	return list.stream().map(Product::convertEntity).collect(Collectors.toList());
    }

    public ProductDTO findByIdProduct(final Long id) {
	log.info("Product not found in database {}", id);
	Product product = productService.findById(id);
	return product.convertEntity();

    }

    /**
     * @param stock
     */
    public void registerStock(final Stock stock) {
	log.info("registering product");
	stockService.save(stock);
    }
}
