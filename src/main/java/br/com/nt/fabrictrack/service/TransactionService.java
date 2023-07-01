/**
 * 
 */
package br.com.nt.fabrictrack.service;

import br.com.nt.fabrictrack.model.Transaction;

/**
 * @author Neto
 *
 */
public interface TransactionService {

    public void save(Transaction transaction);

    public void updateTransactionCanceled(final Long id);
}
