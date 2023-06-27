/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nt.fabrictrack.model.Financial;
import br.com.nt.fabrictrack.repository.impl.FinancialRepositoryImpl;
import br.com.nt.fabrictrack.service.FinancialService;

/**
 * @author Neto
 *
 */
public class FinancialServiceImpl  implements FinancialService{

    @Autowired
    private FinancialRepositoryImpl repository;
    
    @Override
    public void save(Financial financial) {
	repository.save(financial);
	
    }

}
