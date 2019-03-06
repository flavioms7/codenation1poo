package br.com.codenation.aceleradev.rec.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.codenation.aceleradev.rec.conexao.ConexaoJDBC;
import br.com.codenation.aceleradev.rec.loja.beans.Usuario;
import br.com.codenation.aceleradev.rec.loja.exceptions.DAOException;
import br.com.codenation.aceleradev.rec.loja.util.SQL;

public class UsuarioDAO implements BasicoDAO{
	
	@Override
	public Usuario getById(int id) {
			Connection con = null;
			Usuario usuario = null;
			try {
				con = ConexaoJDBC.getConexaoMySQL();
				String sql = "select id, cpf, nome from usuario where id = ?";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					usuario = map(rs);
				}
			} catch (SQLException e) {
				throw new DAOException("Operação não realizada com sucesso.", e);
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}
			}
			return usuario;
		
			
	}
	@Override
	public List<Usuario> getAll() {
		
			Connection con = null;
			List<Usuario> result = null;
			try {
				con = ConexaoJDBC.getConexaoMySQL();
				PreparedStatement pst;
				String sql = "select id, cpf, nome from usuario";
				pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				result = new ArrayList<Usuario>();
				while (rs.next()) {
					Usuario cl = map(rs);
					result.add(cl);
				}
			} catch (SQLException e) {
				throw new DAOException("Operação não realizada com sucesso.", e);
			} finally {
				try {
					if (con != null)
						con.close();
				} catch (SQLException e) {
					throw new DAOException("Não foi possível fechar a conexão.",e);
				}
			}
			return result;
		
	}
	public Usuario verificarCpf(String cpf) {
		Connection con = null;
		Usuario usuario = null;
		try {
			con = ConexaoJDBC.getConexaoMySQL();
			String sql =SQL.SELECT_USUARIO_CPF;
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, cpf);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				usuario = map(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("Operação não realizada com sucesso.", e);
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				throw new DAOException("Não foi possível fechar a conexão.",e);
			}
		}
		return usuario;
		
	}
	private Usuario map(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId(rs.getInt("id"));
		usuario.setCpf(rs.getString("cpf"));
		usuario.setNome(rs.getString("nome"));
		return usuario;
	}
}
