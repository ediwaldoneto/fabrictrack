/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.exception.SellerNotFoundException;
import br.com.nt.fabrictrack.model.Seller;
import br.com.nt.fabrictrack.repository.SellerRepository;
import br.com.nt.fabrictrack.util.Constants;

/**
 * @author Neto
 *
 */
@Repository
public class SellerRepositoryImpl implements SellerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void save(Seller seller) {
	final String sql = "INSERT INTO vendedor (user_name, name, id) VALUES (:user_name, :name, :id)";
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue(Constants.USER_NAME_FIELD, seller.getUser());
	params.addValue(Constants.NAME_FIELD, seller.getName());
	params.addValue(Constants.ID_FIELD, seller.getId());

	jdbcTemplate.update(sql, params);
    }

    @Override
    public void update(Seller seller) {
	final String sql = "UPDATE vendedor SET name = :name, user_name = :user_name WHERE id = :id";
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue(Constants.USER_NAME_FIELD, seller.getUser());
	params.addValue(Constants.NAME_FIELD, seller.getName());
	params.addValue(Constants.ID_FIELD, seller.getId());
	jdbcTemplate.update(sql, params);
    }

    @Override
    public Seller findSeller(String user) throws SellerNotFoundException {
	final String sql = "SELECT * FROM vendedor WHERE user_name = :user";
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue(Constants.NAME_FIELD, user);
	return jdbcTemplate.queryForObject(sql, params, rowMapper());
    }

    @Override
    public Seller findSeller(Long id) throws SellerNotFoundException {
	final String sql = "SELECT * FROM vendedor WHERE id = :id";
	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue(Constants.ID_FIELD, id);
	try {
	    return jdbcTemplate.queryForObject(sql, params, rowMapper());
	} catch (Exception e) {
	    throw new SellerNotFoundException(Constants.SELLER_NOT_FOUND);
	}
    }

    private RowMapper<Seller> rowMapper() {
	return (rs, rowNum) -> {
	    final Seller seller = new Seller();
	    seller.setId(rs.getLong("id"));
	    seller.setName(rs.getString("name"));
	    seller.setUser(rs.getString("user_name"));
	    return seller;
	};
    }

}
