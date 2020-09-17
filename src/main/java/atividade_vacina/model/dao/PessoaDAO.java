package atividade_vacina.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

import java.time.LocalDate;

import atividade_vacina.model.vo.PessoaVO;

public class PessoaDAO {
	
	private PessoaVO inserir(PessoaVO novaPessoa) {
		Connection conn = Banco.getConnection();
		String sql = "insert into pessoa(nome, dtNascimento, sexo, cpf, , tipoPessoa, notaAplicacao) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		try {
			ps.setString(1, novaPessoa.getNome());
			ps.setDate(2, java.sql.Date.valueOf(novaPessoa.getDtNascimento()));
			ps.setString(3, novaPessoa.getSexo());
			ps.setString(4, novaPessoa.getCpf());
			ps.setString(5, novaPessoa.getTipoPessoa());
			ps.setInt(6, novaPessoa.getNotaAplicacao());
			
		    int codigoRetorno = ps.executeUpdate();
		    if(codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO) {
		    	ResultSet rs = ps.getGeneratedKeys();
		    	int chaveGerada = rs.getInt(1);
		    	novaPessoa.setId(chaveGerada);
		    }
		}catch(SQLException e) {
			if(novaPessoa.getTipoPessoa() != null) {
				System.out.println("Erro ao inserir "+novaPessoa.getTipoPessoa()+".\n Erro: "+e.getMessage());
			}else {
				System.out.println("Erro ao inserir pessoa.\n Erro: "+e.getMessage());
			}
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return novaPessoa;
	}
	
	private boolean alterar(PessoaVO novaPessoa) {
		Connection conn = Banco.getConnection();
		String sql = "update pessoa "
				   + "set nome = ?, dtNascimenti = ?, sexo = ?, cpf = ?, tipoPessoa = ?, notaAplicacao = ? "
				   + "where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		boolean alterou = false;
		
		try {
			ps.setString(1, novaPessoa.getNome());
			ps.setDate(2, java.sql.Date.valueOf(novaPessoa.getDtNascimento()));
			ps.setString(3, novaPessoa.getSexo());
			ps.setString(4, novaPessoa.getCpf());
			ps.setString(5, novaPessoa.getTipoPessoa());
			ps.setInt(6, novaPessoa.getNotaAplicacao());
			ps.setInt(7, novaPessoa.getId());
			int codigoRetorno = ps.executeUpdate();
			alterou = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);
		} catch(SQLException e){
			if(novaPessoa.getTipoPessoa() != null) {
				System.out.println("Erro ao alterar "+novaPessoa.getTipoPessoa()+".\n Erro: "+e.getMessage());
			}else {
				System.out.println("Erro ao alterar pessoa.\n Erro: "+e.getMessage());
			}
		}
		return alterou;
	}
	
	public boolean excluir(int id) {
		boolean excluiu = false;
		Connection conn = Banco.getConnection();
		String sql = "delete from pessoa where id = ?";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		try {
			ps.setInt(1, id);
			
			int codigoRetorno = ps.executeUpdate();
			excluiu = (codigoRetorno == Banco.CODIGO_RETORNO_SUCESSO);	
		} catch(SQLException e) {
				System.out.println("Erro ao excluir pessoa.\n Erro: "+e.getMessage());
		}
		
		return excluiu;
	}
	
	private PessoaVO construirPessoaDoResultSet(ResultSet rs) throws SQLException {
		PessoaVO pessoaEncontrada = new PessoaVO();
		pessoaEncontrada.setId(rs.getInt("id"));
		pessoaEncontrada.setNome(rs.getString("nome"));
		//pessoaEncontrada.setDtNascimento(rs.getString("dtNascimento"));
		pessoaEncontrada.setSexo(rs.getString("sexo"));
		pessoaEncontrada.setCpf(rs.getString("cpf"));
		pessoaEncontrada.setTipoPessoa(rs.getString("tipoPessoa"));
		pessoaEncontrada.setNotaAplicacao(rs.getInt("notaAplicação"));
		
		return pessoaEncontrada;
	}
	
	private List<PessoaVO> pesquisarTodos() {
		Connection conn = Banco.getConnection();
		String sql = "select * from pessoa";
		PreparedStatement ps = Banco.getPreparedStatement(conn, sql);
		
		List<PessoaVO> pessoasEncontradas = new ArrayList<PessoaVO>();
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				PessoaVO pessoaEncontrada = construirPessoaDoResultSet(rs);
				pessoasEncontradas.add(pessoaEncontrada);
			}
		}catch(SQLException e) {
			System.out.println("Erro ao pesquisar todos. \nErro: "+e.getMessage());
		}finally {
			Banco.closeConnection(conn);
			Banco.closePreparedStatement(ps);
		}
		return pessoasEncontradas;
	}
}
