package atividade_vacina.model.vo;

import java.time.LocalDate;

public class VacinaVO {
	
	private int id;
	private String nome;
	private String pais;
	private String estagio;
	private LocalDate dtInicioPesquisa;
	private LocalDate dtTerminoPesquisa;
    public PesquisadorVO criador;
	
	public VacinaVO(int id, String nome, String pais, String estagio, LocalDate dtInicioPesquisa,
			LocalDate dtTerminoPesquisa, PesquisadorVO criador) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.estagio = estagio;
		this.dtInicioPesquisa = dtInicioPesquisa;
		this.dtTerminoPesquisa = dtTerminoPesquisa;
		this.criador = criador;
	}
	public VacinaVO() {
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstagio() {
		return estagio;
	}
	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}
	public LocalDate getDtInicioPesquisa() {
		return dtInicioPesquisa;
	}
	public void setDtInicioPesquisa(LocalDate dtInicioPesquisa) {
		this.dtInicioPesquisa = dtInicioPesquisa;
	}
	public  LocalDate getDtTerminoPesquisa() {
		return dtTerminoPesquisa;
	}
	public void setDtTerminoPesquisa(LocalDate dtTerminoPesquisa) {
		this.dtTerminoPesquisa = dtTerminoPesquisa;
	}
	public PesquisadorVO getPesquisador() {
		return criador;
	}
	public void setPesquisador(PesquisadorVO criador) {
		this.criador = criador;
	}
	@Override
	public String toString() {
		return "VacinaVO [id=" + id + ", nome=" + nome + ", pais=" + pais + ", estagio=" + estagio
				+ ", dtInicioPesquisa=" + dtInicioPesquisa + ", dtTerminoPesquisa=" + dtTerminoPesquisa
				+ ", pesquisador=" + criador + "]";
	}
	
	
}
