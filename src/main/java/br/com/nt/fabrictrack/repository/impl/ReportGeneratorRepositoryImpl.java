/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.BestSellingItemsBySeller;
import br.com.nt.fabrictrack.repository.ReportGeneratorRepository;

/**
 * @author Neto
 *
 */
@Repository
public class ReportGeneratorRepositoryImpl implements ReportGeneratorRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<BestSellingItemsBySeller> bestSellingItemsBySeller() {
	final String sql = "SELECT " + " v.name AS vendedor, "
		+ " p.nome AS produto, SUM(t.quantidade) AS quantidade_vendida " + " FROM " + " vendedor v " + " JOIN "
		+ " pedido pe ON v.id = pe.vendedor_id " + " JOIN " + " transacao t ON pe.id = t.venda_id " + " JOIN "
		+ " produto p ON t.produto_id = p.id " + " WHERE " + " t.tipo = 'Venda' " + " GROUP BY " + " v.name, "
		+ " p.nome " + " ORDER BY " + " v.name, " + " quantidade_vendida DESC";

	return jdbcTemplate.query(sql, rowMapper());

    }

    private RowMapper<BestSellingItemsBySeller> rowMapper() {
	return (rs, rowNum) -> {
	    final BestSellingItemsBySeller retVal = new BestSellingItemsBySeller();
	    retVal.setSeller(rs.getString("vendedor"));
	    retVal.setProduct(rs.getString("produto"));
	    retVal.setSoldAmount(rs.getInt("quantidade_vendida"));
	    return retVal;
	};
    }

}
