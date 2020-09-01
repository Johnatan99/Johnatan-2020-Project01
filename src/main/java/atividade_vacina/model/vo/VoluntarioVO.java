package atividade_vacina.model.vo;

import java.time.LocalDate;

public class VoluntarioVO extends PessoaVO {

	public VoluntarioVO() {
		super();
	}

	public VoluntarioVO(String nome, LocalDate dtNascimento, char sexo, String cpf,
			int notaAplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao);
	}
	
}
