package atividade_vacina.model.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import atividade_vacina.model.vo.PesquisadorVO;
import atividade_vacina.model.vo.VacinaVO;
import atividade_vacina.model.vo.PessoaVO;

public class PesquisadorDAO {
	
	PessoaVO pessoa = new PessoaVO();
	public PesquisadorVO inserir(PesquisadorVO novoPesquisador) {
		Connection conn = Banco.getConnection();
		String sql = "insert into pesquisador(instituicao, vacinaCriada) values(?, ?)";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		try {
			ps.setString(1, novoPesquisador.getInstituicao());
		//vacinas criadas
			
			int codigoRetorno = ps.executeUpdate();
			
			if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
				ResultSet rs = ps.getGeneratedKeys();
				int chaveGerada = rs.getInt(1);
				novoPesquisador.setId(chaveGerada);
			}
	
		}catch(SQLException e) {
			System.out.println("Erro ao inserir novo pesquisador. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novoPesquisador;
	}
	
	public boolean alterar(PesquisadorVO pesquisadorAlterado) {
		Connection conn = Banco.getConnection();
		String sql = "update pesquisador "
				    +"set instituicao = ?, vacinaCriada = ?, idPessoa = ?"
				    +"where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		boolean alterou = false;
		
		try {
			ps.setString(1, pesquisadorAlterado.getInstituicao());
			//ps.setInt(2,  pesquisadorAlterado.getVacinaCriada());
			ps.setInt(3, pessoa.getId());
			ps.setInt(4,  pesquisadorAlterado.getId());
			
			int codigoRetorno = ps.executeUpdate();
			
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
			
		} catch(SQLException e) {
			System.out.println("Erro ao alterar pesquisador. \nErro: "+e.getMessage());
		}
	return alterou;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		String sql = "delete from pesquisador where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean excluiu = false;
		
		try {
			ps.setInt(1, id);
			int codigoRetorno = ps.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch (SQLException e){
			System.out.println("Erro ao excluir pesquisador. \nErro: "+e.getMessage());
		}
		
		return excluiu;
	}
	
	public PesquisadorVO criarPesquisadorDoResultSet(ResultSet rs) throws SQLException {
		PesquisadorVO pesquisadorBuscado = new PesquisadorVO();
		pesquisadorBuscado.setId(rs.getInt("id"));
		pesquisadorBuscado.setInstituicao(rs.getString("instituicao"));
		//vacinas criadas
		return pesquisadorBuscado;
	}
	
	public List<PesquisadorVO> buscarTodos(){
		Connection conn = Banco.getConnection();
		String sql = "selext *"
				   + "from pesquisador";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		List<PesquisadorVO> pesquisadoresEncontrados = new ArrayList<PesquisadorVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PesquisadorVO pesquisadorEncontrado = criarPesquisadorDoResultSet(rs);
				pesquisadoresEncontrados.add(pesquisadorEncontrado);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao buscar todas Pessoas. \nErro :"+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pesquisadoresEncontrados;
	}
}














