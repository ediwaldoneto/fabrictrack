/**
 * 
 */
package br.com.nt.fabrictrack.service;

import java.util.List;

import br.com.nt.fabrictrack.model.Stock;

/**
 * @author Neto
 *
 */
public interface StockService {

    public void save(final Stock stock);

    public void finById(final Long id);

    public List<Stock> findALl();

    public void update(final Stock stock);
}
