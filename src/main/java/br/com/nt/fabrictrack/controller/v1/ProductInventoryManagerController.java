/**

 * 
 */
package br.com.nt.fabrictrack.controller.v1;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.exception.ProductNotFoundException;
import br.com.nt.fabrictrack.model.dto.ProductDTO;
import br.com.nt.fabrictrack.model.dto.ProductStockDTO;
import br.com.nt.fabrictrack.model.dto.response.Response;
import br.com.nt.fabrictrack.service.impl.ProductInventoryManager;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/manager")
public class ProductInventoryManagerController {

    @Autowired
    private ProductInventoryManager productInventoryManager;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @PostMapping("/product")
    public ResponseEntity<Response<ProductStockDTO>> create(@Valid @RequestBody ProductStockDTO dto, BindingResult result) {

	Response<ProductStockDTO> response = new Response<>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.addErrorMsgResponse(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}
	try {
	    productInventoryManager.registerProductStock(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping("/product")
    public ResponseEntity<Response<List<ProductDTO>>> findAll() {
	Response<List<ProductDTO>> response = new Response<>();
	try {
	    response.setData(productInventoryManager.findAllProduct());

	    return ResponseEntity.status(HttpStatus.OK).body(response);
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Response<ProductDTO>> findByIdProduct(@PathVariable Long id) {
	Response<ProductDTO> response = new Response<>();
	try {
	    ProductDTO dto = productInventoryManager.findByIdProduct(id);
	    response.setData(dto);
	    return ResponseEntity.status(HttpStatus.OK).body(response);
	} catch (ProductNotFoundException e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }
}
