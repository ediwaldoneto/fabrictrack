/**
 * 
 */
package br.com.nt.fabrictrack.controller.v1;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.model.dto.SellerDTO;
import br.com.nt.fabrictrack.model.dto.response.Response;
import br.com.nt.fabrictrack.service.impl.SellerProcessing;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/seller")
public class SellerController {

    @Autowired
    private SellerProcessing sellerProcessing;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @PostMapping
    public ResponseEntity<Response<SellerDTO>> create(@Valid @RequestBody SellerDTO dto, BindingResult result) {

	Response<SellerDTO> response = new Response<>();
	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.addErrorMsgResponse(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}
	try {
	    sellerProcessing.registerSeller(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);	    
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping("/search")
    public ResponseEntity<Response<SellerDTO>> findBySellerCode(@RequestParam(required = false) Long id) {
	Response<SellerDTO> response = new Response<>();
	try {
	    SellerDTO dto = sellerProcessing.findBySellerCode(id);
	    response.setData(dto);
	    return ResponseEntity.status(HttpStatus.OK).body(response);
	    
	} catch (SellerNotFoundException e) {
	    log.info(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }
}
