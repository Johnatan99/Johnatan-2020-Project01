package atividade_vacina.controller;

import java.util.List;

import atividade_vacina.model.bo.PessoaBO;
import atividade_vacina.model.vo.PessoaVO;

public class PessoaController {
	
	private PessoaVO pessoa = new PessoaVO();
	private PessoaBO bo = new PessoaBO();
	
	public String inserir(PessoaVO novaPessoa) {
		String mensagem = "";
		
		validarCpf(novaPessoa.getCpf());
		novaPessoa = bo.inserir(novaPessoa);
		
		mensagem = "Pessoa salva com sucesso. Id gerado: "+novaPessoa.getId();
		
		return mensagem;
	}
	
	public String alterar(PessoaVO pessoaAtualizada) {
		String mensagem = "";
		
		validarCpf(pessoaAtualizada.getCpf());
		boolean atualizou = bo.alterar(pessoaAtualizada);
		
		if(atualizou) {
			mensagem = "Pessoa atualizada com sucesso";
		} else {
			mensagem += "Erro ao atualizar pessoa";
		}
		return mensagem;
	}
	
	private void validarCpf(String cpf) {
		
		if(cpf == null || cpf.isEmpty() || cpf.length() != 11) {
			System.out.println("O CPF deve possuir 11 dígitos");
		}
		try {
			Integer.parseInt(cpf);
		}catch(NumberFormatException ex) {
			System.out.println("O CPF deve possuir 11 dígitos numéricos");
		}
	}
	
	public void excluir(int id) {
		bo.excluir(id);
	}
	
	public PessoaVO buscarPorId(int id) {
		
		return bo.buscarPorId(id);
		
	}
	
	public List<PessoaVO> buscarTodos(){
		return bo.buscarTodos();
	}
	
}
