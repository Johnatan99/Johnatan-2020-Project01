package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;

	public PesquisadorVO() {
		super();
	}

	public PesquisadorVO(String nome, LocalDate dtNascimento, char sexo, String cpf,
			int notaAplicacao) {
		super(nome, dtNascimento, sexo, cpf, notaAplicacao);
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
}
