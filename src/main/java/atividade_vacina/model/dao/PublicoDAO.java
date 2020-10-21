package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import atividade_vacina.model.vo.PublicoGeralVO;

public class PublicoDAO {
	
	public PublicoGeralVO inserir(PublicoGeralVO novoPublico) {
		Connection conn = Banco.getConnection();
		String sql = "insert into publicoGeral values(?)";
		PreparedStatement ps  = Banco.getPreparedStatement(conn, sql);
		
		try {
			int codRetorno = ps.executeUpdate();
			
			if(codRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
					ResultSet rs = ps.getGeneratedKeys();
					int chaveGerada = rs.getInt(1);
					novoPublico.setId(chaveGerada);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao inserir novo Público. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoPublico;
	}
	
	public boolean alterar(PublicoGeralVO publicoAtualizado) {
		Connection conn = Banco.getConnection();
		String sql = "update publicoGeral"
				   + "where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean alterou = false;
		try {
			ps.setInt(1, publicoAtualizado.getId());
			
			int codRetorno = ps.executeUpdate();
			alterou = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao alterar Público. \nErro: "+e.getMessage());
		}
		return alterou;
	}
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from publico where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			ps.setInt(1,  id);
			
			int codRetorno = ps.executeUpdate();
			excluiu = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao excluir Público. \nErro: "+e.getMessage());
		}
		return excluiu;
	}
	
	private PublicoGeralVO construirPublicDoResultSet(ResultSet rs) throws SQLException{
		PublicoGeralVO publicoBuscado = new PublicoGeralVO();
		publicoBuscado.setId(rs.getInt("id"));
		return publicoBuscado;
	}
	
	public List<PublicoGeralVO> buscarTodos(){
		Connection conn = Banco.getConnection();
		String sql = "select *"
				   + "from publicoGeral";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		List<PublicoGeralVO> publicosEncontrados = new ArrayList<PublicoGeralVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PublicoGeralVO publicoEncontrado = construirPublicDoResultSet(rs);
				publicosEncontrados.add(publicoEncontrado);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao buscar todos publicos. \nErro :"+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		
		return publicosEncontrados;
	}
}
