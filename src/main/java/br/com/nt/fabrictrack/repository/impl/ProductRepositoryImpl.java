/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.exception.ProductNotFoundException;
import br.com.nt.fabrictrack.model.Product;
import br.com.nt.fabrictrack.repository.ProductRepository;
import br.com.nt.fabrictrack.util.Constants;
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
	final String sql = " SELECT p.id, p.nome, p.descricao, p.marca,p.categoria,p.tamanho,p.cor,p.material,p.valor,p.data_cadastro,e.quantidade,e.local_estoque "
		+ " FROM produto p INNER JOIN estoque e ON p.id = e.produto_id WHERE p.id = :id";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("id", id);
	try {
	    return jdbcTemplate.queryForObject(sql, source, mapper());
	} catch (Exception e) {
	    throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND);
	}
    }

    @Override
    public List<Product> findAll() {
	final String sql = " SELECT p.id, p.nome, p.descricao, p.marca,p.categoria,p.tamanho,p.cor,p.material,p.valor,p.data_cadastro,e.quantidade,e.local_estoque "
		+ " FROM produto p INNER JOIN estoque e ON p.id = e.produto_id ";
	return jdbcTemplate.query(sql, mapper());
    }

    @Override
    public Long save(Product product) {
	final String sql = " INSERT INTO produto (id, nome, descricao, marca, categoria, tamanho, cor, material, valor,data_cadastro) "
		+ " VALUES (:id, :name, :description, :brand, :category, :size, :color, :material, :productValue,:dateRegister)";
	final Long id = recoverSequence();
	MapSqlParameterSource source = ObjectSqlParameterConverter.convert(product);
	source.addValue("id", id);
	source.addValue("dateRegister", new Date());
	jdbcTemplate.update(sql, source);
	return id;

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product product) {

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
	    product.setDateRegister(rs.getDate("data_cadastro"));
	    product.setStockLocation(rs.getString("local_estoque"));
	    return product;
	};
    }

    @Override
    public Long recoverSequence() {
	final String sql = "SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'fabric' AND TABLE_NAME = 'produto'";
	return jdbcTemplate.queryForObject(sql, new HashMap<>(), Long.class);
    }
}
