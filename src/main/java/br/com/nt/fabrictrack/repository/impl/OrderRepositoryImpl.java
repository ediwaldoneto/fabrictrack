/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.Order;
import br.com.nt.fabrictrack.repository.OrderRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Long save(Order order) {

	String getLastSequenceQuery = "SELECT MAX(id) FROM pedido FOR UPDATE";
	Long lastSequence = jdbcTemplate.queryForObject(getLastSequenceQuery, new HashMap<>(), Long.class);

	if (lastSequence == null) {
	    lastSequence = 0L;
	}

	Long nextSequence = lastSequence + 1;

	String insertQuery = "INSERT INTO pedido (id, cliente_id, vendedor_id,data_pedido, motivo_cancelamento) VALUES "
		+ " (id, :idClient, :idSeller, :orderDate, :cancellationReason)";
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(order);
	source.addValue("id", nextSequence);
	KeyHolder keyHolder = new GeneratedKeyHolder();
	jdbcTemplate.update(insertQuery, source, keyHolder);

	Long generatedId = keyHolder.getKey().longValue();

	return generatedId;

    }

    @Override
    public void update(Long id, String reason) {
	final String sql = "UPDATE pedido SET cancelado = 1, motivo_cancelamento = :reason WHERE id = :id";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	source.addValue("reason", reason);
	jdbcTemplate.update(sql, source);

    }

    @Override
    public boolean checkOrderExists(Long id) {
	final String sql = " SELECT COUNT(*) FROM pedido WHERE id = :id ";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	return jdbcTemplate.queryForObject(sql, source, Integer.class) > 0;
    }

}
