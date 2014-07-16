package br.fenomeno.entity;

public class Jogador {
	
	private Integer id;
	private String nome;
	private String email;
	private String celular;
	
	public Jogador() {
	}
	
	

	public Jogador(Integer id, String nome, String email, String celular) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.celular = celular;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	
}
