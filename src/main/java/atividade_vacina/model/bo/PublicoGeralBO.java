package atividade_vacina.model.bo;

import java.util.List;
import atividade_vacina.model.vo.PublicoGeralVO;
import atividade_vacina.model.dao.PublicoDAO;

public class PublicoGeralBO {
	
	private PublicoDAO dao = new PublicoDAO();
	
	public PublicoGeralVO inserir(PublicoGeralVO novoPublico) {
		return dao.inserir(novoPublico);
	}
	public boolean alterar(PublicoGeralVO publicoAtualizado) {
		return dao.alterar(publicoAtualizado);
	}
	public boolean excluir(int id) {
		return dao.excluir(id);
	}
	public List<PublicoGeralVO> buscarTodos(){
		return dao.buscarTodos();
	}
}
