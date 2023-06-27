/**
 * 
 */
package br.com.nt.fabrictrack.service;

import java.util.List;

import br.com.nt.fabrictrack.exception.StockNotFoundException;
import br.com.nt.fabrictrack.model.Stock;

/**
 * @author Neto
 *
 */
public interface StockService {

    public void save(final Stock stock);

    public Stock findById(final Long id) throws StockNotFoundException ;

    public List<Stock> findALl();

    public void update(final Stock stock);
}
