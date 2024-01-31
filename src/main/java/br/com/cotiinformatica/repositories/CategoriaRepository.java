package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.cotiinformatica.entities.Categoria;
import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class CategoriaRepository {
	public void insert(Categoria categoria) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("insert into categoria(id, nome, email,telefone, contato_id) values(?,?,?,?,?)");

		statement.setObject(1, categoria.getId());
		statement.setString(2, categoria.getNome());
		statement.setString(3, categoria.getEmail());
		statement.setString(4, categoria.getTelefone());
		statement.setObject(5, categoria.getContato().getId());
		statement.execute();
		connection.close();
	}

	public void update(Categoria categoria) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection
				.prepareStatement("update cliente set nome=?, email=?,telefone=?, contato_id=? where id=?");
		statement.setString(1, categoria.getNome());
		statement.setString(2, categoria.getEmail());
		statement.setString(3, categoria.getTelefone());
		statement.setObject(4, categoria.getContato().getId());
		statement.setObject(5, categoria.getId());
		statement.execute();
		connection.close();
	}

	public void delete(Categoria categoria) throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("delete from cliente where id=?");
		statement.setObject(1, categoria.getId());
		statement.execute();
		connection.close();
	}

	public List<Categoria> findAll() throws Exception {
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from categoria order by nome");
		ResultSet resultSet = statement.executeQuery();
		List<Categoria> lista = new ArrayList<Categoria>();
		while (resultSet.next()) {
			Categoria categoria = new Categoria();
			categoria.setContato(new Contato());
			categoria.setId(UUID.fromString(resultSet.getString("id")));
			categoria.setNome(resultSet.getString("nome"));
			categoria.setEmail(resultSet.getString("email"));
			categoria.setTelefone(resultSet.getString("telefone"));
			categoria.getContato().setId(UUID.fromString(resultSet.getString("contato_id")));
			lista.add(categoria);
		}
		connection.close();
		return lista;
	}
}
