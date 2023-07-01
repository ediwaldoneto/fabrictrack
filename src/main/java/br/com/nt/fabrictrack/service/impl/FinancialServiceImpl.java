/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Financial;
import br.com.nt.fabrictrack.repository.impl.FinancialRepositoryImpl;
import br.com.nt.fabrictrack.service.FinancialService;

/**
 * @author Neto
 *
 */
@Service
public class FinancialServiceImpl  implements FinancialService{

    @Autowired
    private FinancialRepositoryImpl repository;
    
    @Override
    public void save(Financial financial) {
	repository.save(financial);
	
    }

    @Override
    public void delete(Long id) {
	repository.delete(id);
	
    }
    
    

}
