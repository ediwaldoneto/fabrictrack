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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.model.dto.SaleDTO;
import br.com.nt.fabrictrack.model.dto.response.Response;
import br.com.nt.fabrictrack.service.impl.TransactionSaleManager;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/transaction")
public class TransactionSaleManagerController {

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @Autowired
    private TransactionSaleManager transactionSaleManager;

    @PostMapping("/sale")
    public ResponseEntity<Response<String>> registerSale(@Valid @RequestBody SaleDTO dto, BindingResult result) {

	Response<String> response = new Response<>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.addErrorMsgResponse(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}

	try {
	    transactionSaleManager.registerSale(dto);
	    return ResponseEntity.status(HttpStatus.OK).body(response);
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}

    }

}
