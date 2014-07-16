package br.fenomeno.entity;

/**
 * Classe que armazena os lances com as assistências e gols da partoda.
 * Uma partida pode ter vários lances: assistencias e gols
 * @author toliveira
 *
 */
public class Lance {

	private Integer id;
	private Integer tempo;
	private Integer idJogadorAssistencia;
	private Integer idJogadorGol;
	private Integer idPartida;
	private EnumTime time;
	
	public Lance() {}

	
	public Lance(Integer id, Integer tempo, Integer idJogadorAssistencia,
			Integer idJogadorGol, Integer idPartida, EnumTime time) {
		super();
		this.id = id;
		this.tempo = tempo;
		this.idJogadorAssistencia = idJogadorAssistencia;
		this.idJogadorGol = idJogadorGol;
		this.idPartida = idPartida;
		this.time = time;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getIdJogadorAssistencia() {
		return idJogadorAssistencia;
	}

	public void setIdJogadorAssistencia(Integer idJogadorAssistencia) {
		this.idJogadorAssistencia = idJogadorAssistencia;
	}

	public Integer getIdJogadorGol() {
		return idJogadorGol;
	}

	public void setIdJogadorGol(Integer idJogadorGol) {
		this.idJogadorGol = idJogadorGol;
	}

	public Integer getIdPartida() {
		return idPartida;
	}

	public void setIdPartida(Integer idPartida) {
		this.idPartida = idPartida;
	}

	public EnumTime getTime() {
		return time;
	}

	public void setTime(EnumTime time) {
		this.time = time;
	}
	
	
	

	
	
	
}
