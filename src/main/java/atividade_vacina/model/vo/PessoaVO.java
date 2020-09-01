package atividade_vacina.model.vo;

import java.time.LocalDate;

public abstract class PessoaVO {
	
	private int id;
	private String nome;
	private LocalDate dtNascimento;
	private char sexo;
	private String cpf;
	private int notaAplicacao;
	
	public PessoaVO(String nome, LocalDate dtNascimento, char sexo, String cpf, int notaAplicacao) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
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
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getNotaAplicacao() {
		return notaAplicacao;
	}
	public void setNotaAplicacao(int notaAplicacao) {
		this.notaAplicacao = notaAplicacao;
	}
	
	@Override
	public String toString() {
		return "PessoaVO [id=" + id + ", nome=" + nome + ", dtNascimento=" + dtNascimento + ", sexo=" + sexo + ", cpf="
				+ cpf + ", notaAplicacao=" + notaAplicacao + "]";
	}
	
	
	
	
}
