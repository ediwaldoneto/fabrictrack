/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.OrderItem;
import br.com.nt.fabrictrack.repository.OrderItemRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository{
    
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(OrderItem orderItem) {
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(orderItem);
	final String sql = "INSERT INTO item_pedido (pedido_id, produto_id, quantidade) VALUE (:idOrder, :idProduct, :amount)";
	jdbcTemplate.update(sql, source);
    }

}
