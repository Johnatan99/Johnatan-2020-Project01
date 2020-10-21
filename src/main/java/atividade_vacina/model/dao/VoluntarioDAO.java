package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import atividade_vacina.model.vo.VoluntarioVO;

public class VoluntarioDAO {
	
	public VoluntarioVO inserir(VoluntarioVO novoVoluntario) {
		Connection conn = Banco.getConnection();
		String sql = "insert into voluntario(idPessoa) values (?)";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		try {
			int codRetorno = ps.executeUpdate();
			if(codRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet rs = ps.getGeneratedKeys();
				int chaveGerada = rs.getInt(1);
				novoVoluntario.setId(chaveGerada);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao inserir novo voluntário. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoVoluntario;
	}
	
	public boolean alterar(VoluntarioVO voluntarioAtualizado) {
		Connection conn = Banco.getConnection();
		String sql = "update voluntario"
				   + "where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean alterou = false;
		try {
			ps.setInt(1, voluntarioAtualizado.getId());
			
			int codRetorno = ps.executeUpdate();
			alterou = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao alterar Voluntário. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
				
		return alterou;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from voluntario where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			ps.setInt(1, id);
			
			int codRetorno = ps.executeUpdate();
			excluiu = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao excluir voluntário. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return excluiu;
	}
	
	private VoluntarioVO construirVoluntarioDoResultSet(ResultSet rs) throws SQLException{
		VoluntarioVO voluntarioEncontrado = new VoluntarioVO();
		voluntarioEncontrado.setId(rs.getInt("id"));
		return voluntarioEncontrado;
	}
	
	public List<VoluntarioVO> buscarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "select * "
				   + "from voluntario";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		List<VoluntarioVO> voluntariosEncontrados = new ArrayList<VoluntarioVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VoluntarioVO voluntarioEncontrado = construirVoluntarioDoResultSet(rs);
				voluntariosEncontrados.add(voluntarioEncontrado);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao consultar todos voluntários. \nErro :"+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return voluntariosEncontrados;
	}
}
