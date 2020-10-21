package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;
	private VacinaVO[] vacinasCriadas;
	public PesquisadorVO() {
		super();
	}
	
	public PesquisadorVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf,
			int notaAplicacao, String instituicao, VacinaVO[] vacinasAplicadas, VacinaVO[] vacinasCriadas) {
		super(nome, dtNascimento, tipoPessoa, sexo, cpf, vacinasAplicadas, notaAplicacao);
		this.instituicao = instituicao;
		this.vacinasCriadas = vacinasCriadas;
		// TODO Auto-generated constructor stub
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public VacinaVO[] getVacinasCriadas() {
		return vacinasCriadas;
	}
	public void setVacinasCriadas (VacinaVO[] vacinasCriadas) {
		this.vacinasCriadas = vacinasCriadas;
	}
}
