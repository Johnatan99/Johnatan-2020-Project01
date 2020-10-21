package atividade_vacina.model.bo;

import java.util.List;
import atividade_vacina.model.vo.PessoaVO;
import atividade_vacina.model.dao.PessoaDAO;

public class PessoaBO {
	
	private PessoaDAO dao = new PessoaDAO();
	
	public PessoaVO inserir(PessoaVO novaPessoa) {
		
		PessoaVO pessoa = new PessoaVO();
		if(pessoa.getCpf() == null) {
			System.out.println("A pessoa deve possuir CPF.");
		}
		if(dao.cpfJaCadastrado(novaPessoa)) {
			System.out.println("O CPF informado "+pessoa.getCpf()+" já foi cadastrado.");
		}
		return dao.inserir(novaPessoa);
	}
	
	public boolean alterar(PessoaVO pessoaAtualizada) {
		
		PessoaVO pessoa = new PessoaVO();
		if(pessoa.getCpf() == null) {
			System.out.println("A pessoa deve possuir CPF.");
		}
		if(dao.cpfJaCadastrado(pessoaAtualizada)) {
			System.out.println("O CPF informado "+pessoa.getCpf()+" já foi cadastrado.");
		}
		
		return dao.alterar(pessoaAtualizada);
	}
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	
	public PessoaVO buscarPorId(int id){
		return dao.buscarPorId(id);
	}
	public List<PessoaVO> buscarTodos(){
		return dao.buscarTodos();
	}
	
	
}
