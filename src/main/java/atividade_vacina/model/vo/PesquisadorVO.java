package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PesquisadorVO extends PessoaVO {
	
	private String instituicao;
	private int vacinaCriada;
	public PesquisadorVO() {
		super();
	}
	
	public PesquisadorVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf,
			int notaAplicacao, String instituicao, int vacinaCriada) {
		super(nome, dtNascimento, tipoPessoa, sexo, cpf, notaAplicacao);
		this.instituicao = instituicao;
		this.vacinaCriada = vacinaCriada;
		// TODO Auto-generated constructor stub
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	
	public int getVacinaCriada() {
		return vacinaCriada;
	}
	public void setVacinaCriada (int vacinaCriada) {
		this.vacinaCriada = vacinaCriada;
	}
}
