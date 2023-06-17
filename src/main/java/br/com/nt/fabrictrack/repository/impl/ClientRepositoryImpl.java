/**
 * 
 */
package br.com.nt.fabrictrack.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.nt.fabrictrack.model.Client;
import br.com.nt.fabrictrack.repository.ClientRepository;

/**
 * @author Neto
 *
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public Client findById(Long id) {

	return null;
    }

    @Override
    public List<Client> findByName(String name) {
	final String sql = "SELECT * FROM cliente WHERE nome LIKE :name";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("name", "%" + name + "%");

	try {
	    return jdbcTemplate.query(sql, source, rowMapper());
	} catch (EmptyResultDataAccessException e) {
	   return new ArrayList<>();
	}
    }

    @Override
    public Client findByCpfRg(String cpf, String rg) {
	final String sql = "SELECT id, nome, cpf, rg, endereco, idade, email, telefone, sexo, estado_civil, data_nascimento FROM cliente "
		+ " WHERE cpf = :cpf OR rg = :rg";
	MapSqlParameterSource source = new MapSqlParameterSource();
	source.addValue("cpf", cpf);
	source.addValue("rg", rg);
	try {
	    return jdbcTemplate.queryForObject(sql, source, rowMapper());
	} catch (EmptyResultDataAccessException e) {
	    return null;
	}
    }

    @Override
    public List<Client> findAll() {
	final String sql = "SELECT * FROM cliente";
	return jdbcTemplate.query(sql, rowMapper());
    }

    @Override
    public void save(Client client) {
	String sql = "INSERT INTO cliente (nome, cpf, rg, endereco, idade, email, telefone, sexo, estado_civil, data_nascimento) "
		+ " VALUES (:nome, :cpf, :rg, :endereco, :idade, :email, :telefone, :sexo, :estado_civil, :data_nascimento)";

	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("nome", client.getName());
	params.addValue("cpf", client.getCpf());
	params.addValue("rg", client.getRg());
	params.addValue("endereco", client.getAddress());
	params.addValue("idade", client.getAge());
	params.addValue("email", client.getEmail());
	params.addValue("telefone", client.getPhone());
	params.addValue("sexo", client.getSex());
	params.addValue("estado_civil", client.getMaritalStatus());
	params.addValue("data_nascimento", client.getBirthDate());

	jdbcTemplate.update(sql, params);

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Client client) {

    }

    private RowMapper<Client> rowMapper() {
	return (rs, rowNum) -> {
	    final Client client = new Client();
	    client.setId(rs.getLong("id"));
	    client.setName(rs.getString("nome"));
	    client.setAddress(rs.getString("endereco"));
	    client.setAge(rs.getInt("idade"));
	    client.setEmail(rs.getString("email"));
	    client.setCpf(rs.getString("cpf"));
	    client.setRg(rs.getString("rg"));
	    client.setPhone(rs.getString("telefone"));
	    client.setSex(rs.getString("sexo"));
	    client.setMaritalStatus(rs.getString("estado_civil"));
	    return client;
	};
    }

    @Override
    public boolean checkCpfExists(String cpf) {
	String sql = "SELECT COUNT(*) FROM cliente WHERE cpf = :cpf";

	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("cpf", cpf);

	return jdbcTemplate.queryForObject(sql, params, Integer.class) > 0;
    }

    @Override
    public boolean checkRgExists(String rg) {
	String sql = "SELECT COUNT(*) FROM cliente WHERE rg = :rg";

	MapSqlParameterSource params = new MapSqlParameterSource();
	params.addValue("rg", rg);

	return jdbcTemplate.queryForObject(sql, params, Integer.class) > 0;
    }
}
