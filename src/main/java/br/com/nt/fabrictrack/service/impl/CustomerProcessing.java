/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.model.Client;
import br.com.nt.fabrictrack.model.dto.ClientDTO;
import br.com.nt.fabrictrack.util.Constants;

/**
 * @author Neto
 *
 */
/**
 * @author Neto
 *
 */
@Service
public class CustomerProcessing {

    @Autowired
    private ClientServiceImpl service;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    /**
     * @param dto
     */
    public void registerClient(final ClientDTO dto) {
	log.info("checking data entered for registration");
	service.checksInformedData(dto.getCpf(), dto.getRg());
	service.save(dto.convertEntity());
    }

    /**
     * @param cpf
     * @param rg
     * @return
     * @throws ClientNotFoundException
     */
    public ClientDTO findClientCpfRg(final String cpf, final String rg) throws ClientNotFoundException {
	Client client = service.findByCpfRg(cpf, rg);
	if (client == null) {
	    log.info(Constants.CLIENT_NOT_FOUND);
	    throw new ClientNotFoundException(Constants.CLIENT_NOT_FOUND);
	}
	return client.convertEntity();
    }

    /**
     * @param name
     * @return
     * @throws ClientNotFoundException
     */
    public List<ClientDTO> findClientName(final String name) throws ClientNotFoundException {
	List<Client> clients = service.findName(name);
	if (clients.isEmpty()) {
	    log.info(Constants.CLIENT_NOT_FOUND);
	    throw new ClientNotFoundException(Constants.CLIENT_NOT_FOUND);
	}
	List<ClientDTO> dtos = new ArrayList<>();
	clients.stream().forEach(t -> dtos.add(t.convertEntity()));
	return dtos;
    }

}
