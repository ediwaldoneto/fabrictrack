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

import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.repository.ProductRepository;
import br.com.nt.fabrictrack.util.ObjectSqlParameterConverter;

/**
 * @author Neto
 *
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Product findById(Long id) {
	final String sql = "SELECT * FROM produto WHERE id = :id";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	return jdbcTemplate.queryForObject(sql, source, mapper());
    }

    @Override
    public List<Product> findAll() {
	final String sql = "SELECT * FROM produto";
	return jdbcTemplate.query(sql, mapper());
    }

    @Override
    public void save(Product product) {
	final String sql = " INSERT INTO produto (nome, descricao, marca, categoria, tamanho, cor, material, valor) "
		+ " VALUES (:name, :description, :brand, :category, :size, :color, :material, :productValue)";
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(product);
	jdbcTemplate.update(sql, source);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id) {

    }

    private RowMapper<Product> mapper() {
	return (rs, rowNum) -> {
	    final Product product = new Product();
	    product.setId(rs.getLong("id"));
	    product.setName(rs.getString("nome"));
	    product.setDescription(rs.getString("descricao"));
	    product.setBrand(rs.getString("marca"));
	    product.setCategory(rs.getString("categoria"));
	    product.setColor(rs.getString("cor"));
	    product.setMaterial(rs.getString("material"));
	    product.setSize(rs.getInt("tamanho"));
	    product.setProductValue(rs.getBigDecimal("valor"));
	    return product;
	};
    }
}
