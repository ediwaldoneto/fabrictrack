/**
 * 
 */
package br.com.nt.fabrictrack.repository;

import java.util.List;

import br.com.nt.fabrictrack.exception.StockNotFoundException;
import br.com.nt.fabrictrack.model.Stock;

/**
 * @author Neto
 *
 */
public interface StockRepository {

    public void save(Stock stock);

    public void update(Stock stock);

    public Stock findById(final Long id) throws StockNotFoundException;

    public List<Stock> findAll();

}
