package atividade_vacina.model.vo;

import java.time.LocalDate;

public class PessoaVO {
	
	private int id;
	private String nome;
	private LocalDate dtNascimento;
	private String tipoPessoa;
	private String sexo;
	private String cpf;
	private VacinaVO[] vacinasAplicadas;
	private int notaAplicacao;
	
	public PessoaVO(String nome, LocalDate dtNascimento, String tipoPessoa, String sexo, String cpf, VacinaVO[] vacinasAplicadas, int notaAplicacao) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.tipoPessoa = tipoPessoa;
		this.sexo = sexo;
		this.cpf = cpf;
		this.vacinasAplicadas = vacinasAplicadas;
		this.notaAplicacao = notaAplicacao;
	}
	public PessoaVO() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public VacinaVO[] getVacinasAplicadas() {
		return vacinasAplicadas;
	}
	public void setVacinasAplicadas(VacinaVO[] vacinasAplicadas) {
		this.vacinasAplicadas = vacinasAplicadas;
	}
	public int getNotaAplicacao() {
		return notaAplicacao;
	}
	public void setNotaAplicacao(int notaAplicacao) {
		this.notaAplicacao = notaAplicacao;
	}
	
}
