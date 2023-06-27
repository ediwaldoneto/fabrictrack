/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import br.com.nt.fabrictrack.model.Financial;
import br.com.nt.fabrictrack.repository.FinancialRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
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

}
