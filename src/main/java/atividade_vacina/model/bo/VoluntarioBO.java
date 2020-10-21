package atividade_vacina.model.bo;

import java.util.List;

import atividade_vacina.model.dao.VoluntarioDAO;
import atividade_vacina.model.vo.VoluntarioVO;

public class VoluntarioBO {
	
	private VoluntarioDAO dao = new VoluntarioDAO();
	
	public VoluntarioVO inserir(VoluntarioVO novoVoluntario) {
		return dao.inserir(novoVoluntario);
	}
	public boolean alterar(VoluntarioVO voluntarioAtualizado) {
		return dao.alterar(voluntarioAtualizado);
	}
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	public List<VoluntarioVO> buscarTodos(){
		return dao.buscarTodos();
	}
}
