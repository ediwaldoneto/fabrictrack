/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.Transaction;
import br.com.nt.fabrictrack.repository.TransactionRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Transaction transaction) {
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(transaction);
	final String sql = "INSERT INTO transacao (tipo, data_transacao,quantidade, valor, produto_id,venda_id) "
		+ " VALUES (:type,:transactionDate,:amount,:transactionValue,:idProduct,:idSale)";
	jdbcTemplate.update(sql, source);

    }

    @Override
    public void update(Transaction transaction) {
	// TODO Auto-generated method stub

    }

    @Override
    public Long findById(Long id) {
	// TODO Auto-generated method stub
	return null;
    }

}
