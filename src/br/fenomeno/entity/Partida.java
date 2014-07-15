package br.fenomeno.entity;

public class Partida {

	private Long id;
	
	/** atributos transientes, calculados pela AssistenciaGol */
	private Integer qtdeGolTimeA;
	private Integer qtdeGolTimeB;
	
	
	public Partida() { }
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQtdeGolTimeA() {
		return qtdeGolTimeA;
	}
	public void setQtdeGolTimeA(Integer qtdeGolTimeA) {
		this.qtdeGolTimeA = qtdeGolTimeA;
	}
	public Integer getQtdeGolTimeB() {
		return qtdeGolTimeB;
	}
	public void setQtdeGolTimeB(Integer qtdeGolTimeB) {
		this.qtdeGolTimeB = qtdeGolTimeB;
	}
	
	
	
}
