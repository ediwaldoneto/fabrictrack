/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import java.util.List;

import br.com.nt.fabrictrack.exception.ClientNotFoundException;
import br.com.nt.fabrictrack.model.Client;

/**
 * @author Neto
 *
 */
public interface ClientRepository {

    public Client findById(final Long id);

    public List<Client> findByName(final String name);

    public Client findByCpfRg(final String cpf, final String rg) throws ClientNotFoundException;

    public List<Client> findAll();

    public void save(final Client client);

    public void delete(final Long id);

    public void update(final Client client);

    public boolean checkCpfExists(final String cpf);

    public boolean checkRgExists(final String rg);
}
