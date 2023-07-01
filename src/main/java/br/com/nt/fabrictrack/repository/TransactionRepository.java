/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import br.com.nt.fabrictrack.model.Transaction;

/**
 * @author Neto
 *
 */
public interface TransactionRepository {

    public void save(final Transaction transaction);

    public void update(final Transaction transaction);

    public Long findById(final Long id);

    public void updateTransactionCanceled(final Long id);
}
