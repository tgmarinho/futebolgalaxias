package br.fenomeno.entity;

public class Jogador {
	
	private Long id;
	private String nome;
	private String email;
	private String celular;
	
	public Jogador() {
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Long getId() {
		return id;
	}


	/** TODO: retirar quando estiver em produção, usando apenas para teste */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	
}
