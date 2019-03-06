package br.com.codenation.aceleradev.rec.loja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.codenation.aceleradev.rec.conexao.ConexaoJDBC;
import br.com.codenation.aceleradev.rec.loja.beans.Produto;
import br.com.codenation.aceleradev.rec.loja.enums.CategoriasEnum;
import br.com.codenation.aceleradev.rec.loja.exceptions.DAOException;
import br.com.codenation.aceleradev.rec.loja.util.SQL;

public class ProdutoDAO implements BasicoDAO {

	@Override
	public Produto getById(int id) {
		Connection con = null;
		Produto p = null;
		try {
			con = ConexaoJDBC.getConexaoMySQL();
			PreparedStatement pst;

			pst = con.prepareStatement(SQL.SELECT_PRODUTO_ID);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			p = map(rs);
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
		return p;
	}

	@Override
	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Produto> getProdutosByCategoria(CategoriasEnum idCategoria) {
		Connection con = null;
		List<Produto> resultado = null;
		try {
			con = ConexaoJDBC.getConexaoMySQL();
			PreparedStatement pst;

			pst = con.prepareStatement(SQL.SELECT_PRODUTOS_CATEGORIA);
			pst.setInt(1, idCategoria.getValor());
			ResultSet rs = pst.executeQuery();
			resultado = new ArrayList<Produto>();
			while (rs.next()) {
				Produto p = map(rs);
				resultado.add(p);
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
		return resultado;
	}
	
	private Produto map(ResultSet rs) throws SQLException {
		Produto p = new Produto();
		p.setId(rs.getInt("id"));
		p.setDescricao(rs.getString("descricao"));
		p.setCategoria(rs.getInt("categoria"));
		p.setPreco(rs.getDouble("preco"));
		p.setQtdEstoque(rs.getInt("qtd_estoque"));
		return p;
	}
}
