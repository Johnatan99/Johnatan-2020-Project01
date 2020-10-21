package atividade_vacina.model.bo;

import java.util.List;

import atividade_vacina.model.dao.PesquisadorDAO;
import atividade_vacina.model.vo.PesquisadorVO;

public class PesquisadorBO {
	
	private PesquisadorDAO dao = new PesquisadorDAO();
	
	public PesquisadorVO inserir(PesquisadorVO novoPesquisador) {
		return dao.inserir(novoPesquisador);
	}
	
	public boolean alterar(PesquisadorVO pesquisadorAtualizado) {
		return dao.alterar(pesquisadorAtualizado);
	}
	
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	
	public List<PesquisadorVO> buscarTodos(){
		return buscarTodos();
	}
}
