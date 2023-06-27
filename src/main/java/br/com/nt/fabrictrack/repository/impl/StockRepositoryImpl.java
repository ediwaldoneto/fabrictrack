/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.exception.StockNotFoundException;
import br.com.nt.fabrictrack.model.Stock;
import br.com.nt.fabrictrack.repository.StockRepository;
import br.com.nt.fabrictrack.util.Constants;
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
    public Stock findById(Long id) throws StockNotFoundException {
	final String sql = "SELECT * FROM estoque WHERE produto_id = :id";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	try {
	    return jdbcTemplate.queryForObject(sql, source, rowMapper());
	} catch (Exception e) {
	    throw new StockNotFoundException(Constants.STOCK_NOT_FOUND);
	}
    }

    @Override
    public List<Stock> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    private RowMapper<Stock> rowMapper() {
	return (rs, rowNum) -> {
	    final Stock stock = new Stock();
	    stock.setId(rs.getLong("id"));
	    stock.setIdProduct(rs.getLong("produto_id"));
	    stock.setAmount(rs.getInt("quantidade"));
	    stock.setDateRegister(rs.getDate("data_cadastro"));
	    stock.setStockLocation(rs.getString("local_estoque"));
	    return stock;
	};
    }

}
