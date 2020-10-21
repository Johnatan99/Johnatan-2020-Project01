package atividade_vacina.model.vo;

import java.time.LocalDate;

public class VoluntarioVO extends PessoaVO {

	public VoluntarioVO() {
		super();
	}

	public VoluntarioVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf,
			VacinaVO[] vacinasAplicadas, int notaAplicacao) {
		super(nome, dtNascimento, tipoPessoa, sexo, cpf, vacinasAplicadas, notaAplicacao);
	}
	
}
