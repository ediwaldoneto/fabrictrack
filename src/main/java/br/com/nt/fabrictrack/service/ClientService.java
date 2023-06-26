/**
 * 
 */
package br.com.nt.fabrictrack.service;

import java.util.List;

import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.model.Client;

/**
 * @author Neto
 *
 */
public interface ClientService {

    public Client findByCpfRg(final String cpf, final String rg) throws ClientNotFoundException;

    public List<Client> findName(final String name) throws ClientNotFoundException;

    public void save(final Client client);

    public List<Client> findAll();

    public boolean checkCpfExists(final String cpf);

    public boolean checkRgExists(final String rg);

    public Long checkClientExists(final Long id) throws ClientNotFoundException;
}
