package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PublicoGeralVO extends PessoaVO{

	public PublicoGeralVO() {
		super();
	}
	public PublicoGeralVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf,
			int notaAplicacao) {
		super(nome, dtNascimento, tipoPessoa, sexo, cpf, notaAplicacao);
	}
	
	
}
