package application.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.dao.EnderecoDao;
import application.db.DbException;
import application.entities.Endereco;

public class EnderecoDaoJdbc implements EnderecoDao {

	private Connection conn;

	public EnderecoDaoJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Endereco findById(int id) {
		try {
			PreparedStatement st;
			ResultSet rs;
			st = conn.prepareStatement(
					"SELECT te.cep, te.bairro, te.logradouro, te.home FROM tb_endereco te WHERE te.id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();

			if (rs.next()) {
				Endereco end = new Endereco();
				end.setCep(rs.getString("cep"));
				end.setBairro(rs.getString("bairro"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setHome(rs.getString("home"));
				return end;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public Endereco findByCep(String cep) {
		try {
			PreparedStatement st;
			ResultSet rs;
			st = conn.prepareStatement(
					"SELECT te.cep, te.bairro, te.logradouro, te.home FROM tb_endereco te WHERE te.cep = ?");
			st.setString(1, cep);
			rs = st.executeQuery();

			if (rs.next()) {
				Endereco end = new Endereco();
				end.setCep(rs.getString("cep"));
				end.setBairro(rs.getString("bairro"));
				end.setLogradouro(rs.getString("logradouro"));
				end.setHome(rs.getString("home"));
				return end;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void delete(long id) {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("DELETE FROM tb_endereco tb WHERE tb.id = ?");
			st.setFloat(1, id);

			int rows = st.executeUpdate();

			if (rows == 0) {
				System.out.println("Id: " + id + ", Not found!!!");
			} else {
				System.out.println("deletado com sucesso!!!");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

	@Override
	public void save(Endereco end) {
		PreparedStatement st;
		try {
			st = conn.prepareStatement("INSERT INTO tb_endereco( cep, bairro, logradouro, home ) VALUES (?,?,?,?)");
			st.setString(1, end.getCep());
			st.setString(2, end.getBairro());
			st.setString(3, end.getLogradouro());
			st.setString(4, end.getHome());
			int rows = st.executeUpdate();

			if (rows == 0) {
				System.out.println("{ \"error\" : \"400\" }");
			} else {
				System.out.println("{ \"sucesso\" : \"200\" }");
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}

	}

}
