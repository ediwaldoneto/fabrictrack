/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Transaction;
import br.com.nt.fabrictrack.repository.impl.TransactionRepositoryImpl;
import br.com.nt.fabrictrack.service.TransactionService;

/**
 * @author Neto
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepositoryImpl repository;

    @Override
    public void save(Transaction transaction) {
	repository.save(transaction);

    }

}
