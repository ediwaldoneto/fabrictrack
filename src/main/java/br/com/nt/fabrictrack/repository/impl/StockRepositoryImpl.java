/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.repository.StockRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class StockRepositoryImpl implements StockRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Stock stock) {
	final String sql = "INSERT INTO estoque (produto_id,quantidade,data_cadastro,local_estoque) "
		+ " VALUES (:idProduct, :amount, :dateRegister, :stockLocation)";
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(stock);
	jdbcTemplate.update(sql, source);
    }

    @Override
    public void update(Stock stock) {
	final String sql = "UPDATE estoque SET quantidade = :amount WHERE produto_id = :id";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("amount", stock.getAmount());
	source.addValue("id", stock.getId());
	jdbcTemplate.update(sql, source);
    }

    @Override
    public Stock findById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Stock> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

}
