/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.exception.ValidateExceptionData;
import br.com.nt.fabrictrack.model.Client;
import br.com.nt.fabrictrack.repository.impl.ClientRepositoryImpl;
import br.com.nt.fabrictrack.service.ClientService;

/**
 * @author Neto
 *
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepositoryImpl repositoryImpl;

    private static final Logger log = LoggerFactory.getLogger("ServiceInformation");

    @Override
    public Client findByCpfRg(String cpf, String rg) {
	return repositoryImpl.findByCpfRg(cpf, rg);
    }

    @Override
    public List<Client> findName(String name) {
	return repositoryImpl.findByName(name);
    }

    @Override
    public void save(Client client) {
	repositoryImpl.save(client);
    }

    @Override
    public List<Client> findAll() {
	List<Client> clients = repositoryImpl.findAll();
	if (clients == null) {
	    return Collections.emptyList();
	}

	return clients;
    }

    @Override
    public boolean checkCpfExists(String cpf) {
	return repositoryImpl.checkCpfExists(cpf);
    }

    @Override
    public boolean checkRgExists(String rg) {
	return repositoryImpl.checkRgExists(rg);
    }

    
    /**
     * @param cpf
     * @return
     */
    public boolean isValidCPF(final String cpf) {
	    if (cpf == null || cpf.length() != 11) {
	        return false;
	    }

	    if (areAllDigitsEqual(cpf)) {
	        return false;
	    }

	    if (!isValidFirstDigit(cpf)) {
	        return false;
	    }

	    if (!isValidSecondDigit(cpf)) {
	        return false;
	    }

	    return true;
	}

	private boolean areAllDigitsEqual(String cpf) {
	    char firstDigit = cpf.charAt(0);
	    for (int i = 1; i < cpf.length(); i++) {
	        if (cpf.charAt(i) != firstDigit) {
	            return false;
	        }
	    }
	    return true;
	}

	private boolean isValidFirstDigit(String cpf) {
	    int firstDigit = Character.getNumericValue(cpf.charAt(9));
	    int sum = 0;
	    for (int i = 0; i < 9; i++) {
	        sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
	    }
	    int remainder = sum % 11;
	    if (remainder < 2) {
	        return firstDigit == 0;
	    } else {
	        return firstDigit == 11 - remainder;
	    }
	}

	private boolean isValidSecondDigit(String cpf) {
	    int secondDigit = Character.getNumericValue(cpf.charAt(10));
	    int sum = 0;
	    for (int i = 0; i < 10; i++) {
	        sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
	    }
	    int remainder = sum % 11;
	    if (remainder < 2) {
	        return secondDigit == 0;
	    } else {
	        return secondDigit == 11 - remainder;
	    }
	}

    /**
     * @param cpfData
     * @param rgData
     */
    public void checksInformedData(final String cpfData, final String rgData) {

	if (!isValidCPF(cpfData)) {
	    log.info("invalid cpf {}", cpfData);
	    throw new ValidateExceptionData("invalid cpf");
	}

	if (checkCpfExists(cpfData)) {
	    log.info("cpf already registered {}", cpfData);
	    throw new ValidateExceptionData("cpf already registered");
	}

	if (checkRgExists(rgData)) {
	    log.info("rg already registered {}", rgData);
	    throw new ValidateExceptionData("rg already registered");
	}

    }

}
