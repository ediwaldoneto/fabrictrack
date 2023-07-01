/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import br.com.nt.fabrictrack.model.Financial;

/**
 * @author Neto
 *
 */
public interface FinancialRepository {

    public void save(Financial financial);
    
    public void delete(final Long id);
}
