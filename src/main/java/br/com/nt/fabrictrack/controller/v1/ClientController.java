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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.exception.ValidateExceptionData;
import br.com.nt.fabrictrack.model.dto.ClientDTO;
import br.com.nt.fabrictrack.model.dto.response.Response;
import br.com.nt.fabrictrack.service.impl.CustomerProcessing;

/**
 * @author Neto
 *
 */
@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private CustomerProcessing customerProcessing;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @PostMapping
    public ResponseEntity<Response<ClientDTO>> create(@Valid @RequestBody ClientDTO dto, BindingResult result) {
	Response<ClientDTO> response = new Response<>();

	if (result.hasErrors()) {
	    result.getAllErrors().forEach(error -> response.addErrorMsgResponse(error.getDefaultMessage()));
	    return ResponseEntity.badRequest().body(response);
	}
	try {
	    customerProcessing.registerClient(dto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    
	} catch (ValidateExceptionData e) {
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.badRequest().body(response);
	    
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping("/search")
    public ResponseEntity<Response<ClientDTO>> findClient(@RequestParam(required = false) String cpf,
	    @RequestParam(required = false) String rg) {
	Response<ClientDTO> response = new Response<>();

	try {
	    ClientDTO dto = customerProcessing.findClientCpfRg(cpf, rg);
	    response.setData(dto);
	    return ResponseEntity.ok(response);
	    
	} catch (ClientNotFoundException e) {
	    log.error(e.getMessage());
	    return ResponseEntity.notFound().build();
	    
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Response<List<ClientDTO>>> findClientName(@PathVariable("name") String name) {
	Response<List<ClientDTO>> response = new Response<>();

	try {
	    List<ClientDTO> dto = customerProcessing.findClientName(name);
	    response.setData(dto);
	    return ResponseEntity.ok(response);
	    
	} catch (ClientNotFoundException e) {
	    log.info(e.getMessage());
	    return ResponseEntity.notFound().build();
	    
	} catch (Exception e) {
	    log.error(e.getMessage());
	    response.addErrorMsgResponse(e.getMessage());
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
    }

}
