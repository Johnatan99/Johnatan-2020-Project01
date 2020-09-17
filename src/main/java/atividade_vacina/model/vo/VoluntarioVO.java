package atividade_vacina.model.vo;

import java.time.LocalDate;

public class VoluntarioVO extends PessoaVO {

	public VoluntarioVO() {
		super();
	}

	public VoluntarioVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf,
			int notaAplicacao) {
		super(nome, dtNascimento, tipoPessoa, sexo, cpf, notaAplicacao);
	}
	
}
