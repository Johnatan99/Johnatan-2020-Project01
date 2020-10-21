package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.util.List;
import java.util.ArrayList;

import atividade_vacina.model.vo.VacinaVO;
import atividade_vacina.model.vo.PesquisadorVO;

public class VacinaDAO {
	
	private PesquisadorVO pesquisador = new PesquisadorVO();
	public VacinaVO inserir(VacinaVO novaVacina) {

		Connection conn = Banco.getConnection();
		String sql = "insert into vacina(nome, pais, estagio, dtInicioPesquisa, dtTerminoPesquisa, idPesquisador) values(?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		try {
			ps.setString(1, novaVacina.getNome());
			ps.setString(2, novaVacina.getPais());
			ps.setString(3,novaVacina.getEstagio());
			ps.setDate(4, java.sql.Date.valueOf(novaVacina.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(novaVacina.getDtTerminoPesquisa()));
			ps.setInt(6, pesquisador.getId());
			int codRetorno = ps.executeUpdate();
			
			if(codRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet rs = ps.getGeneratedKeys();
				int chaveGerada = rs.getInt(1);
				novaVacina.setId(chaveGerada);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao inserir vacia. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novaVacina;
	}
	
	public boolean alterar(VacinaVO vacinaAtualizada) {
		Connection conn = Banco.getConnection();
		String sql = "update vacina"
				   + "set nome = ?, pais = ?, estagio = ?, dtInicioPesquisa = ?, dtTerminoPesquisa = ?, idPesquisador = ?"
				   + "where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean alterou = false;
		try {
			ps.setString(1, vacinaAtualizada.getNome());
			ps.setString(2, vacinaAtualizada.getPais());
			ps.setString(3, vacinaAtualizada.getEstagio());
			ps.setDate(4, java.sql.Date.valueOf(vacinaAtualizada.getDtInicioPesquisa()));
			ps.setDate(5, java.sql.Date.valueOf(vacinaAtualizada.getDtTerminoPesquisa()));
			ps.setInt(6, pesquisador.getId());
			ps.setInt(7, vacinaAtualizada.getId());
			
			int codRetorno = ps.executeUpdate();
			alterou = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao alterar Vacina. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return alterou;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from vacina where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		try {
			ps.setInt(1, id);
			int codRetorno = ps.executeUpdate();
			excluiu = (codRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		}catch(SQLException e) {
			System.out.println("Erro ao excluir vacina. Erro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return excluiu;
	}
	
	private VacinaVO construirVacinaDoResultSet(ResultSet rs) throws SQLException{
		VacinaVO vacinaEncontrada = new VacinaVO();
		vacinaEncontrada.setId(rs.getInt("id"));
		vacinaEncontrada.setNome(rs.getString("nome"));
		vacinaEncontrada.setPais(rs.getString("pais"));
		
		Date dataSQL = rs.getDate("dtInicioPesquisa");
		vacinaEncontrada.setDtInicioPesquisa(dataSQL.toLocalDate());
		
		Date dataSQL2 = rs.getDate("dtTerminoPesquisa");
		vacinaEncontrada.setDtTerminoPesquisa(dataSQL2.toLocalDate());
		
		vacinaEncontrada.criador.setId(rs.getInt("idPesquisador"));
		return vacinaEncontrada;
	}
	
	public List<VacinaVO> buscarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "select * "
				   + "from vacina";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		List<VacinaVO> vacinasEncontradas = new ArrayList<VacinaVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				VacinaVO vacinaEncontrada = construirVacinaDoResultSet(rs);
				vacinasEncontradas.add(vacinaEncontrada);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao consultar todas c=vacinas. Erro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return vacinasEncontradas;
	}
}
