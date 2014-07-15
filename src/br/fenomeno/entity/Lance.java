package br.fenomeno.entity;

/**
 * Classe que armazena os lances com as assistências e gols da partoda.
 * Uma partida pode ter vários lances: assistencias e gols
 * @author toliveira
 *
 */
public class Lance {

	private Long id;
	private Partida partida;
	private String lances;
	
	public Lance() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Partida getPartida() {
		return partida;
	}
	public void setPartida(Partida partida) {
		this.partida = partida;
	}
	public String getLances() {
		return lances;
	}
	public void setLances(String lances) {
		this.lances = lances;
	}
	
	
	
}
