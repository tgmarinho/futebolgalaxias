package br.fenomeno.entity;

public class Grupo {

	
	private Integer id;
	private String nome;
	private String descricao;
	private Integer configGols;
	private Integer configMinutos;
	
	public Grupo(){
	}
	
	
	public Grupo(Integer id, String nome, String descricao, Integer configGols,
			Integer configMinutos) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.configGols = configGols;
		this.configMinutos = configMinutos;
	}
	
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", nome=" + nome + ", descrição=" + descricao
				+ ", Config. Gol(s)=" + configGols + ", Config. Tempo=" + configMinutos + "min]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getConfigGols() {
		return configGols;
	}
	public void setConfigGols(Integer configGols) {
		this.configGols = configGols;
	}
	public Integer getConfigMinutos() {
		return configMinutos;
	}
	public void setConfigMinutos(Integer configMinutos) {
		this.configMinutos = configMinutos;
	}
	
	
	
	
}
