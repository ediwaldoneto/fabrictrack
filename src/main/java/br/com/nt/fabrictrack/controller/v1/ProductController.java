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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.model.dto.ProductDTO;
import br.com.nt.fabrictrack.model.dto.response.Response;
import br.com.nt.fabrictrack.service.impl.ProductInventoryManager;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductInventoryManager productInventoryManager;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @PostMapping
    public ResponseEntity<Response<ProductDTO>> create(@Valid @RequestBody ProductDTO dto, BindingResult result) {

	Response<ProductDTO> response = new Response<>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.addErrorMsgResponse(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}
	try {
	    productInventoryManager.registerProduct(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping
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
}
