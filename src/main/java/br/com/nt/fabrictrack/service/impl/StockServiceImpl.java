/**
 * 
 */
package br.com.nt.fabrictrack.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.repository.impl.StockRepositoryImpl;
import br.com.nt.fabrictrack.service.StockService;

/**
 * @author Neto
 *
 */
@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepositoryImpl repository;

    @Override
    public void save(Stock stock) {
	repository.save(stock);

    }

    @Override
    public void finById(Long id) {
	// TODO Auto-generated method stub

    }

    @Override
    public List<Stock> findALl() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void update(Stock stock) {
	repository.update(stock);

    }

}
