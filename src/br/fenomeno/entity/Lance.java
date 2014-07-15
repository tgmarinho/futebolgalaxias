package br.fenomeno.entity;

/**
 * Classe que armazena os lances com as assistências e gols da partoda.
 * Uma partida pode ter vários lances: assistencias e gols
 * @author toliveira
 *
 */
public class Lance {

	private Long id;
	private Long idPartida;
	private String lances;
	
	public Lance() {}
	
	
	
	/**
	 * 
	 * @param id
	 * @param idPartida
	 * @param lances
	 */
	public Lance(Long id, Long idPartida, String lances) {
		super();
		this.id = id;
		this.idPartida = idPartida;
		this.lances = lances;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Long idPartida) {
		this.idPartida = idPartida;
	}

	public String getLances() {
		return lances;
	}
	public void setLances(String lances) {
		this.lances = lances;
	}
	
	
	
}
