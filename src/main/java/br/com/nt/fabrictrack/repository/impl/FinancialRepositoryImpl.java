/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.Financial;
import br.com.nt.fabrictrack.repository.FinancialRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class FinancialRepositoryImpl implements FinancialRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Financial financial) {
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(financial);
	final String sql = "INSERT INTO financeiro (tipo, data_transacao, valor, descricao, venda_id) "
		+ " VALUES (:type,:transactionDate,:transactionValue,:description,:idSale)";
	jdbcTemplate.update(sql, source);

    }

    @Override
    public void delete(Long id) {
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	final String sql = "DELETE FROM financeiro WHERE venda_id = :id";
	jdbcTemplate.update(sql, source);

    }

}
