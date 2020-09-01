package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PublicoGeralVO extends PessoaVO{

	public PublicoGeralVO() {
		super();
	}
	public PublicoGeralVO(String nome, LocalDate dtNascimento, char sexo, String cpf,
			int notaAplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao);
	}
	
	
}
