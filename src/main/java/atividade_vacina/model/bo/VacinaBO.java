package atividade_vacina.model.bo;

import java.util.List;

import atividade_vacina.model.vo.VacinaVO;
import atividade_vacina.model.dao.VacinaDAO;

public class VacinaBO {
	
	private VacinaDAO dao = new VacinaDAO();
			
	public VacinaVO inserir(VacinaVO novaVacina) {
		return dao.inserir(novaVacina);
	}
	public boolean alterar(VacinaVO vacinaAtualizada) {
		return dao.alterar(vacinaAtualizada);
	}
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	public List<VacinaVO> buscarTodos(){
		return dao.buscarTodos();
	}
}
