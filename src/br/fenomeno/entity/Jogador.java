package br.fenomeno.entity;

public class Jogador {
	
	private Long id;
	
	private String nome;
	
	private Long qtdAssistencia;
	
	private Long qtdGol;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getQtdAssistencia() {
		return qtdAssistencia;
	}

	public void setQtdAssistencia(Long qtdAssistencia) {
		this.qtdAssistencia = qtdAssistencia;
	}

	public Long getQtdGol() {
		return qtdGol;
	}

	public void setQtdGol(Long qtdGol) {
		this.qtdGol = qtdGol;
	}

	
}
